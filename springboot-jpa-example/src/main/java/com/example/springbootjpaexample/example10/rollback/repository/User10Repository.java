package com.example.springbootjpaexample.example10.rollback.repository;

import com.example.springbootjpaexample.example10.rollback.entity.User10;
import com.example.springbootjpaexample.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User10Repository extends BaseRepository<User10,Integer> {
}
