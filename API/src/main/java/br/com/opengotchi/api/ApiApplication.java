package br.com.opengotchi.api;

import br.com.opengotchi.api.Util.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
