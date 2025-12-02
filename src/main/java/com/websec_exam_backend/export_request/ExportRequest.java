package com.websec_exam_backend.export_request;
import com.websec_exam_backend.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExportRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Employee employee;

    @CreationTimestamp
    private LocalDateTime exportCreation;

    @Lob
    private String appliedFiltersJson;

    @Transient
    private List<Map<String, FilterDTO>> appliedFilters;

    private String exportFormat;

    private String selectedEntities;

    private String status;

    private String fileName;

    private String fileSize;

    private static final ObjectMapper mapper = new ObjectMapper();

    public void setAppliedFilters(List<Map<String, FilterDTO>> filters) {
        this.appliedFilters = filters;
        try {
            this.appliedFiltersJson = new ObjectMapper().writeValueAsString(filters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, FilterDTO>> getAppliedFilters() {
        if (appliedFilters == null && appliedFiltersJson != null) {
            try {
                var type = mapper.getTypeFactory().constructCollectionType(
                        List.class,
                        mapper.getTypeFactory().constructMapType(Map.class, String.class, FilterDTO.class)
                );
                appliedFilters = mapper.readValue(appliedFiltersJson, type);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return appliedFilters;
    }

}
