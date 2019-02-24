package com.javanobrain.springbatch.demospringbatchcsv2db.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.javanobrain.springbatch.demospringbatchcsv2db.domain.User;

@Component
public class Processor implements ItemProcessor<User, User>{
	
	private static final Map<String, String> DEPT_NAMES = new HashMap<String, String>();
	
	public Processor() {
		DEPT_NAMES.put("001", "Technology");
		DEPT_NAMES.put("002", "Operations");
		DEPT_NAMES.put("003", "Marketing");
		DEPT_NAMES.put("004", "Accounting");
	}

	@Override
	public User process(User user) throws Exception {
		
		String deptCode = user.getDept();
		String dept = DEPT_NAMES.get(deptCode);
		user.setDept(dept);
		
		System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dept));
		
		return user;
	}
}
