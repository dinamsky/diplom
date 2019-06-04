package com.restik.mydiplom.repositories;

import com.restik.mydiplom.entity.Reserve;
import com.restik.mydiplom.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface ReserveRepository extends CrudRepository<Reserve, Integer> {
}
