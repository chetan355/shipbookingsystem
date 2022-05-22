package com.algo.onlineshipbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algo.onlineshipbooking.dao.ShipDao;

@Service
public class ShipServices {

	@Autowired
	ShipDao dao;
	
	
}
