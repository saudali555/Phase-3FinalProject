package com.org.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders, Integer> {

	public List<Orders> findByDateoforder(String dateoforder);
	
}