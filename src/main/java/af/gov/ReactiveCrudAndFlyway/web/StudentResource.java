package af.gov.ReactiveCrudAndFlyway.web;


import java.time.Duration;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import af.gov.ReactiveCrudAndFlyway.domain.Student;
import af.gov.ReactiveCrudAndFlyway.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/student/")
@AllArgsConstructor
public class StudentResource {
    private final StudentService studentService;
    @PostMapping("save")
    public Mono<Student> saveStudent(@Valid @RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("getAll")
    public Flux<Student> getAll(){
        return studentService.findAll()
            .flatMap(stu -> {
                stu.setStu_name(stu.getStu_name()+", "+stu.getLastname());
                return Mono.just(stu);
            });
    }
    
}
