package org.yascode.middleware_etl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.yascode.middleware_etl.domain.entity.Notification;
import org.yascode.middleware_etl.domain.repository.NotificationRepository;

@SpringBootApplication
public class MiddlewareEtlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddlewareEtlApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(NotificationRepository notificationRepository) {
		return args -> {
			Notification notification = Notification.builder()
					.inputFileName("input.csv")
					.outputFileName("output.csv")
					.status("SUCCESS")
					.build();

			notificationRepository.save(notification);
		};
	}

}
