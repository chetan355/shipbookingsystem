package com.algo.onlineshipbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algo.onlineshipbooking.model.Ship;

@Repository
public interface ShipDao extends JpaRepository<Ship, Long>{

	@Query("select s from Ship s where s.source =:source AND s.destination=:destination")
	public Ship getShipBySourceAndDestination(@Param("source") String source,@Param("destination") String destination);
}