package edu.tutorial;
import edu.tutorial.entity.Tutorial;
import edu.tutorial.repository.TutorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class TutorialManagementBackendApplication implements CommandLineRunner {
    private final TutorialRepository tutorialRepository;
    public static void main(String[] args)
    {
        SpringApplication.run(TutorialManagementBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Tutorial> tutorials = List.of(
                Tutorial.builder().title("Spring Boot Tutorial").description("Spring Boot Tutorial Description").publish_status(true).build(),
                Tutorial.builder().title("Spring Boot JPA").description("Spring MVC Tutorial Description").publish_status(true).build(),
                Tutorial.builder().title("Python").description("Advanced Python").publish_status(false).build(),
                Tutorial.builder().title("Sql").description("All Parts of Sql").publish_status(false).build()
        );
        tutorialRepository.saveAll(tutorials);
        IO.println("-------------Tutorials Saved Successfully------------");
    }
}
