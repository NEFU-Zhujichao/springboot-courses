package com.example.springbootjpaexample.example05.repository;

import com.example.springbootjpaexample.example05.entity.User05;
import com.example.springbootjpaexample.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User05Repository extends BaseRepository<User05,Integer> {
}
