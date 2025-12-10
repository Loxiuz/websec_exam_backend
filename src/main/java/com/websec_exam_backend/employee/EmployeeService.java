package com.websec_exam_backend.employee;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new IllegalArgumentException("Employee with id " + id + " not found");
        }
    }

    public void saveImage(String id, MultipartFile file) throws IOException {
        Employee employee = getEmployee(Integer.parseInt(id));

        employee.setImage(file.getBytes());

        employeeRepository.save(employee);
    }

    public byte[] getImage(String id) {
        Employee employee = getEmployee(Integer.parseInt(id));
        return employee.getImage();
    }
}
