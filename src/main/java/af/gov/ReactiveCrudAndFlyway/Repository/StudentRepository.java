package af.gov.ReactiveCrudAndFlyway.Repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import af.gov.ReactiveCrudAndFlyway.domain.Student;

public interface StudentRepository extends ReactiveCrudRepository<Student,Long> {
    
}
