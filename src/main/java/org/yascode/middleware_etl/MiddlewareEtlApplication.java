package org.yascode.middleware_etl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.yascode.middleware_etl.infrastructure.adapter.output.entity.NotificationEntity;
import org.yascode.middleware_etl.infrastructure.adapter.output.repository.NotificationRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class MiddlewareEtlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddlewareEtlApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(NotificationRepository notificationRepository) {
		return args -> {

			NotificationEntity notification = NotificationEntity.builder()
					.inputFileName("file-input.csv")
					.outputFileName("file-output.csv")
					.processedAt(LocalDateTime.now())
					.status("PENDING")
					.build();

			notificationRepository.save(notification);
		};
	}

}
