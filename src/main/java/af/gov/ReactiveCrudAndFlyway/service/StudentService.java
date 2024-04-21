package af.gov.ReactiveCrudAndFlyway.service;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Service;

import af.gov.ReactiveCrudAndFlyway.Repository.StudentRepository;
import af.gov.ReactiveCrudAndFlyway.domain.Student;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    //reactive method
    public Flux<Student> findAll(){
       return  studentRepository.findAll();
    }

    //blocking method
    public List<Student> findAllBlock(){
        return  studentRepository.findAll().collectList().block();
     }

     //reactive method
    public Mono<Student> save(Student student){
       return studentRepository.save(student);
    } 
    //blocking method
    public Student saveBlock(Student student){
        return studentRepository.save(student).block();
     } 
    
}
