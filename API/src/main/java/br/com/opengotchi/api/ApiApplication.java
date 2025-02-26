package br.com.opengotchi.api;

import br.com.opengotchi.api.Util.DataLoader.ColorDataLoader;
import br.com.opengotchi.api.Util.DataLoader.PersonalityDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private ColorDataLoader colorDataLoader;

	@Autowired
	private PersonalityDataLoader personalityDataLoader;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		colorDataLoader.load();
		personalityDataLoader.load();
	}
}
