package com.example.demo.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

   // @Autowired not recommended anymore, it makes dependencies tricky to mock and replace for tests
    private final JdbcClientRunRepository runRepository;
    //@Autowired recommended, but it's implicit here cuz here's just a simple constructor
    RunController(JdbcClientRunRepository runRepository){
        this.runRepository = runRepository;
    }

    @GetMapping
    List<Run> findAll() {
        return runRepository.findAll();
    }


    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()){
            throw new RunNotFoundException();
        }
        return run.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void Create(@Valid @RequestBody Run run){
        runRepository.create(run);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run,id);
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }

}
