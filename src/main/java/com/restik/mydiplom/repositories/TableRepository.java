package com.restik.mydiplom.repositories;

import com.restik.mydiplom.entity.Tables;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TableRepository extends CrudRepository<Tables, Integer> {

  //  @Query("SELECT c FROM Tables c WHERE c.tableNum = :num")
  //  Optional<Tables> findByCode(@Param("num") String tableNum);
}
