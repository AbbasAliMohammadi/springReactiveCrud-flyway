package af.gov.ReactiveCrudAndFlyway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import af.gov.ReactiveCrudAndFlyway.Repository.StudentRepository;
import af.gov.ReactiveCrudAndFlyway.domain.Student;

@SpringBootApplication
public class ReactiveCrudAndFlywayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveCrudAndFlywayApplication.class, args);
	}



	@Bean
	public CommandLineRunner saveData(StudentRepository studentRepository){
		return arg->{
        for(int i=0; i<100; i++){
             studentRepository.save(
				Student.builder().stu_name("Ali "+i).lastname("Mohammadi "+i).build()
			 ).subscribe();
		}
	};
	}

}
