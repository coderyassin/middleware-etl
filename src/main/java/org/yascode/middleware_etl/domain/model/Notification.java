package org.yascode.middleware_etl.domain.model;

import java.time.LocalDateTime;

public class Notification {

    private Long id;

    private String inputFileName;

    private String outputFileName;

    private LocalDateTime processedAt;

    private String status;

    public Notification() {
    }

    public Notification(Long id,
                        String inputFileName,
                        String outputFileName,
                        LocalDateTime processedAt,
                        String status) {
        this.id = id;
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.processedAt = processedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(LocalDateTime processedAt) {
        this.processedAt = processedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", inputFileName='" + inputFileName + '\'' +
                ", outputFileName='" + outputFileName + '\'' +
                ", processedAt=" + processedAt +
                ", status='" + status + '\'' +
                '}';
    }
}
