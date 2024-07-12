package com.example.demo.run;
import org.springframework.data.repository.ListCrudRepository;
//type and id type(the property marked by @Id)
public interface RunRepository extends  ListCrudRepository<Run, Integer>{

}
