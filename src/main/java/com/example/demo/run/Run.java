package com.example.demo.run;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run(@Id
                  Integer id,
                  @NotEmpty
                  String title,
                  LocalDateTime startedOn,
                  LocalDateTime completedOn,
                  @Positive
                  Integer miles,
                  Location location
//                  if new row or existing row
//                  @Version
//                  Integer version
                 )
                 {
//
//    public Run(){
//        if(!completeOn().isAfter(startOn())){
//            throw new IllegalArgumentException("Completed On must be after Started On");
//        }
//    }
}
