package com.websec_exam_backend.controller;

import com.websec_exam_backend.dto.AdminUserEmployeeDTO;
import com.websec_exam_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

     public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all/with-employees")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AdminUserEmployeeDTO[]> getAllUsersWithEmployees() {
         AdminUserEmployeeDTO[] userEmployeeDTOS = userService.getAllWithEmployees();
         if(userEmployeeDTOS == null || userEmployeeDTOS.length == 0) {
             return ResponseEntity.notFound().build();
         }
            return ResponseEntity.ok(userEmployeeDTOS);
    }
}
