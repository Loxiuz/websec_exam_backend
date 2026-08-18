package com.websec_exam_backend.service;

import com.websec_exam_backend.model.Employee;
import com.websec_exam_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class EmployeeService {

    private static final long MAX_IMAGE_SIZE_BYTES = 5L * 1024 * 1024;
    private static final Set<String> ALLOWED_IMAGE_FORMATS = Set.of("png", "jpeg");

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(UUID id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new IllegalArgumentException("Employee with id " + id + " not found");
        }
    }

    public void saveImage(String id, MultipartFile file) throws IOException {
        Employee employee = getEmployee(UUID.fromString(id));
        byte[] imageBytes = validateAndReadImage(file);

        String contentType = file.getContentType();
        if (contentType != null && (
                contentType.startsWith("image/jpeg") ||
                contentType.startsWith("image/jpg")  ||
                contentType.startsWith("image/png")
        )) {
            employee.setImage(imageBytes);
            employee.setImageMimeType(contentType);

            employeeRepository.save(employee);
        } else {
            throw new IllegalArgumentException("Only image files are allowed" + file.getContentType());
        }
    }

    public byte[] getImage(String id) {
        Employee employee = getEmployee(UUID.fromString(id));
        return employee.getImage();
    }

    private byte[] validateAndReadImage(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Image file is required");
        }

        if (file.getSize() > MAX_IMAGE_SIZE_BYTES) {
            throw new IllegalArgumentException("Image file is too large");
        }

        byte[] imageBytes = file.getBytes();
        String imageFormat = detectImageFormat(imageBytes);

        if (!ALLOWED_IMAGE_FORMATS.contains(imageFormat)) {
            throw new IllegalArgumentException("Only PNG and JPEG images are allowed");
        }

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
        if (image == null) {
            throw new IllegalArgumentException("Uploaded file is not a valid image");
        }

        return imageBytes;
    }

    private String detectImageFormat(byte[] imageBytes) throws IOException {
        try (ImageInputStream imageInputStream = ImageIO.createImageInputStream(new ByteArrayInputStream(imageBytes))) {
            if (imageInputStream == null) {
                throw new IllegalArgumentException("Uploaded file is not a valid image");
            }

            Iterator<ImageReader> readers = ImageIO.getImageReaders(imageInputStream);
            if (!readers.hasNext()) {
                throw new IllegalArgumentException("Uploaded file is not a supported image");
            }

            return readers.next().getFormatName().toLowerCase(Locale.ROOT);
        }
    }
}
