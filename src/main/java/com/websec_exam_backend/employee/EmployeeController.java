package com.websec_exam_backend.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/{id}/upload-image")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Void> uploadImage(
            @PathVariable String id,
            @RequestParam("file") MultipartFile file) throws IOException {

        employeeService.saveImage(id, file);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/image")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) {
        byte[] image = employeeService.getImage(id);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
