package com.websec_exam_backend.service;

import com.websec_exam_backend.model.Employee;
import com.websec_exam_backend.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.ArgumentCaptor;
import org.springframework.mock.web.MockMultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    private Employee employee;
    private UUID employeeId;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeService = new EmployeeService(employeeRepository);
        employeeId = UUID.randomUUID();
        employee = new Employee();
        employee.setId(employeeId);
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
    }

    @Test
    void saveImageStoresValidPng() throws IOException {
        byte[] pngBytes = createImageBytes("png");
        MockMultipartFile file = new MockMultipartFile("file", "avatar.png", "image/png", pngBytes);

        employeeService.saveImage(employeeId.toString(), file);

        ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save(employeeCaptor.capture());
        assertArrayEquals(pngBytes, employeeCaptor.getValue().getImage());
    }

    @Test
    void saveImageStoresValidJpeg() throws IOException {
        byte[] jpegBytes = createImageBytes("jpeg");
        MockMultipartFile file = new MockMultipartFile("file", "avatar.jpg", "image/jpeg", jpegBytes);

        employeeService.saveImage(employeeId.toString(), file);

        ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save(employeeCaptor.capture());
        assertArrayEquals(jpegBytes, employeeCaptor.getValue().getImage());
    }

    @Test
    void saveImageRejectsEmptyFile() {
        MockMultipartFile file = new MockMultipartFile("file", "empty.png", "image/png", new byte[0]);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> employeeService.saveImage(employeeId.toString(), file));

        assertEquals("Image file is required", exception.getMessage());
        verify(employeeRepository, never()).save(employee);
    }

    @Test
    void saveImageRejectsUnsupportedContentEvenIfMimeClaimsPng() {
        MockMultipartFile file = new MockMultipartFile("file", "fake.png", "image/png", "not-an-image".getBytes());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> employeeService.saveImage(employeeId.toString(), file));

        assertEquals("Uploaded file is not a supported image", exception.getMessage());
        verify(employeeRepository, never()).save(employee);
    }

    @Test
    void saveImageRejectsTooLargeFile(@TempDir Path tempDir) throws IOException {
        java.nio.file.Path largeFile = tempDir.resolve("large.bin");
        java.nio.file.Files.write(largeFile, new byte[5 * 1024 * 1024 + 1]);

        MockMultipartFile file = new MockMultipartFile(
                "file",
                "large.png",
                "image/png",
                java.nio.file.Files.newInputStream(largeFile)
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> employeeService.saveImage(employeeId.toString(), file));

        assertEquals("Image file is too large", exception.getMessage());
        verify(employeeRepository, never()).save(employee);
    }

    private byte[] createImageBytes(String formatName) throws IOException {
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        boolean written = ImageIO.write(image, formatName, outputStream);
        if (!written) {
            throw new IllegalStateException("Test image format not supported: " + formatName);
        }
        return outputStream.toByteArray();
    }
}

