package com.websec_exam_backend.service;

import com.websec_exam_backend.dto.AdminUserEmployeeDTO;
import com.websec_exam_backend.model.Employee;
import com.websec_exam_backend.model.User;
import com.websec_exam_backend.repository.EmployeeRepository;
import com.websec_exam_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
    }

    public AdminUserEmployeeDTO[] getAllWithEmployees() {
        return userRepository.findAll().stream()
                .map(user -> toDto(user, user.getEmployee()))
                .toArray(AdminUserEmployeeDTO[]::new);
    }

    private AdminUserEmployeeDTO toDto(User user, Employee employee) {
        if (employee == null) {
            return new AdminUserEmployeeDTO(
                    null,
                    user.getUsername(),
                    null,
                    user.getRole().getRoleName().split("_")[1],
                    null
            );
        }
        return new AdminUserEmployeeDTO(
                employee.getName(),
                user.getUsername(),
                employee.getEmail(),
                user.getRole().getRoleName().split("_")[1],
                employee.getId()
        );
    }
}
