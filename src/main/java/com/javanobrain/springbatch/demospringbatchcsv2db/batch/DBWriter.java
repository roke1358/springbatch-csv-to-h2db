package com.javanobrain.springbatch.demospringbatchcsv2db.batch;

import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.javanobrain.springbatch.demospringbatchcsv2db.domain.User;
import com.javanobrain.springbatch.demospringbatchcsv2db.domain.UserRepository;

@Component
public class DBWriter implements ItemWriter<User> {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void write(List<? extends User> users) throws Exception {
		
		System.out.println("############# Saving Users into DB" + users);
		userRepository.save(users);
		
	}

}
