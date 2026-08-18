package com.websec_exam_backend.config;

import com.websec_exam_backend.model.Employee;
import com.websec_exam_backend.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Assigns sample images from classpath data/images to employees that don't have one yet.
@Component
public class EmployeeImageSeeder implements CommandLineRunner {

    private static final String IMAGES_LOCATION_PATTERN = "classpath:data/images/*.jpg";

    private final EmployeeRepository employeeRepository;

    public EmployeeImageSeeder(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws IOException {
        List<Resource> images = Arrays.stream(
                        new PathMatchingResourcePatternResolver().getResources(IMAGES_LOCATION_PATTERN))
                .sorted(Comparator.comparing(Resource::getFilename))
                .toList();

        if (images.isEmpty()) {
            return;
        }

        List<Employee> employees = employeeRepository.findAll().stream()
                .filter(employee -> employee.getImage() == null)
                .toList();

        for (int i = 0; i < employees.size(); i++) {
            Resource image = images.get(i % images.size());
            Employee employee = employees.get(i);

            try (InputStream inputStream = image.getInputStream()) {
                employee.setImage(inputStream.readAllBytes());
                employee.setImageMimeType(URLConnection.guessContentTypeFromName(image.getFilename()));
            }
        }

        employeeRepository.saveAll(employees);
    }
}
