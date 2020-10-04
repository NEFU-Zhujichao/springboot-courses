package com.example.springbootjpaexample.example07.repository;

import com.example.springbootjpaexample.example07.entity.Address07;
import com.example.springbootjpaexample.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Address07Repository extends BaseRepository<Address07,Integer> {
    @Query("from Address07 a where a.user.id=:id")
    List<Address07> list(@Param("id") int id);

    @Query("from Address07 a where a.detail=:detail")
    Page<Address07> list(@Param("detail") String detail, Pageable pageable);
}
