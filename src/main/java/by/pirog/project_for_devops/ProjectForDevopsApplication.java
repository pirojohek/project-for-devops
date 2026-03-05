package by.pirog.project_for_devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ProjectForDevopsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjectForDevopsApplication.class, args);
	}

}
