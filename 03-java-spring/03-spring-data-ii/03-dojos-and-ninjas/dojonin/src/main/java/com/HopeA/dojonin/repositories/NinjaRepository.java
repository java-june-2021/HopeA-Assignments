package com.HopeA.dojonin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HopeA.dojonin.models.Dojo;
import com.HopeA.dojonin.models.Ninja;

@Repository

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findByDojo(Dojo dojo);

}
