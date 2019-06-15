package com.restik.mydiplom.repositories;

import com.restik.mydiplom.entity.Reserve;
import com.restik.mydiplom.entity.Tables;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TableRepository extends CrudRepository<Tables, Integer> {

  //  @Query("SELECT c FROM Tables c WHERE c.tableNum = :num")
  //  Optional<Tables> findByCode(@Param("num") String tableNum);


//    SELECT t FROM tables t WHERE t.restaurant_restaurant_id  = 1
//    AND t.visitors_volume =  2 AND t.table_id NOT IN
//            (SELECT r FROM reserve r WHERE r.id =1  ) limit 1;

//      @Query("SELECT c FROM Tables c WHERE c.tableNum = :num")
//      @Query("SELECT TOP 1 tableId FROM tables WHERE restaurantId = :restaurantId AND visitorsVolume = :visitorsVolume AND tableId NOT IN (SELECT distinct (tableId) FROM reserve WHERE dateReserve = :dateReserve BETWEEN reserveStart(hour,-3,@time1) and reserveStart(hour,3,@time1))")


    @Query("SELECT tableId FROM Tables WHERE restaurantId = :restaurantId" +
            " AND visitorsVolume = :visitorsVolume " +
            "AND tableId NOT IN " +
            "(SELECT tableId FROM Reserve tableId WHERE id = 1)" +
           // " WHERE id = 1)" +
//              "WHERE reserveStart BETWEEN :dateReserveDeltaMinus AND :dateReserveDeltaPlus )" +
//              "WHERE id = 1 )" +
            "")


    Optional<Tables> findFreeTable(@Param("restaurantId") Integer restaurantId,
                                   @Param("visitorsVolume") Integer visitorsVolume
//                            @Param("dateReserveDeltaMinus") LocalDateTime dateReserveDeltaMinus,
//                            @Param("dateReserveDeltaPlus") LocalDateTime dateReserveDeltaPlus );
    );

}
