package br.com.opengotchi.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class ApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.printf("\n" +
				" \n" +
				"  ______                                                __              __       __ \n" +
				" /      \\                                              |  \\            |  \\     |  \\\n" +
				"|  $$$$$$\\ ______   ______  _______   ______   ______ _| $$_    _______| $$____  \\$$\n" +
				"| $$  | $$/      \\ /      \\|       \\ /      \\ /      |   $$ \\  /       | $$    \\|  \\\n" +
				"| $$  | $|  $$$$$$|  $$$$$$| $$$$$$$|  $$$$$$|  $$$$$$\\$$$$$$ |  $$$$$$| $$$$$$$| $$\n" +
				"| $$  | $| $$  | $| $$    $| $$  | $| $$  | $| $$  | $$| $$ __| $$     | $$  | $| $$\n" +
				"| $$__/ $| $$__/ $| $$$$$$$| $$  | $| $$__| $| $$__/ $$| $$|  | $$_____| $$  | $| $$\n" +
				" \\$$    $| $$    $$\\$$     | $$  | $$\\$$    $$\\$$    $$ \\$$  $$\\$$     | $$  | $| $$\n" +
				"  \\$$$$$$| $$$$$$$  \\$$$$$$$\\$$   \\$$_\\$$$$$$$ \\$$$$$$   \\$$$$  \\$$$$$$$\\$$   \\$$\\$$\n" +
				"         | $$                       |  \\__| $$                                      \n" +
				"         | $$                        \\$$    $$                                      \n" +
				"          \\$$                         \\$$$$$$                                       \n\n");
	}
}
