package org.yascode.middleware_etl.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "input_file_name")
    private String inputFileName;

    @Column(name = "output_file_name")
    private String outputFileName;

    @Column(name = "processed_at")
    private LocalDateTime processedAt;

    @Column(name = "status")
    private String status;

    @PrePersist
    protected void onCreate() {
        processedAt = LocalDateTime.now();
    }
}
