package com.restik.mydiplom.repositories;

import com.restik.mydiplom.entity.Reserve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReserveRepository extends CrudRepository<Reserve, Integer> {

    //  @Query("SELECT c FROM Tables c WHERE c.tableNum = :num")
      @Query("SELECT TOP 1 tableId FROM tables WHERE restaurantId = :restaurantId AND visitorsVolume = :visitorsVolume AND tableId NOT IN (SELECT distinct (tableId) FROM reserve WHERE dateReserve = :dateReserve BETWEEN reserveStart(hour,-3,@time1) and reserveStart(hour,3,@time1))")
      Reserve findFreeTable(@Param("restaurantId") Integer restaurantId, @Param("visitorsVolume") Integer visitorsVolume, @Param("dateReserve") LocalDateTime dateReserve);

}
