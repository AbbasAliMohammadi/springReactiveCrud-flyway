package af.gov.ReactiveCrudAndFlyway.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
@Builder
public class Student {
    
    @Id
   private Long id;
   @NotNull
   private String stu_name;
   @NotNull
   private String lastname;


}
