package com.javanobrain.springbatch.demospringbatchcsv2db.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
