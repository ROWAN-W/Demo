package com.example.demo.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.strategy.SingleInstantiatorStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/runs")
public class RunController {

   // @Autowired not recommended anymore, it makes dependencies tricky to mock and replace for tests
    private final RunRepository runRepository;
    //@Autowired recommended, but it's implicit here cuz here's just a simple constructor
    RunController(RunRepository runRepository){
        this.runRepository = runRepository;
    }

    @GetMapping
    List<Run> findAll() {
        return runRepository.findAll();
    }
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        return runRepository.findById(id);
    }





}
