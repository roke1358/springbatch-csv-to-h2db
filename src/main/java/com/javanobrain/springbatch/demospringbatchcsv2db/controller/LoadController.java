package com.javanobrain.springbatch.demospringbatchcsv2db.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.javanobrain.springbatch.demospringbatchcsv2db.domain.User;
import com.javanobrain.springbatch.demospringbatchcsv2db.domain.UserRepository;
import com.javanobrain.springbatch.demospringbatchcsv2db.exception.UserNotfoundException;



@RestController
@RequestMapping("/")
public class LoadController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/load")
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		Map<String, JobParameter> maps = new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters parameters = new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, parameters);

		System.out.println("JobExecution: " + jobExecution.getStatus());
		System.out.println("[DONE] " );
		
		return jobExecution.getStatus();
		
	}
	
	@GetMapping("/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }
	
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getId(@PathVariable("id") final Integer id) {
    	
    	User user = userRepository.findOne(id);
    	
    	if(!(user==null)) {
        	return new ResponseEntity<>(String.format("[%s]", user), HttpStatus.OK);
    	} else {
    		throw new UserNotfoundException(id);
    	}
    }
}
