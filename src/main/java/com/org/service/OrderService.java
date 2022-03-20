package com.org.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Admin;
import com.org.entity.OrderRepo;
import com.org.entity.Orders;

@Service
public class OrderService {

	@Autowired
	OrderRepo orepo;
	
	public List<Orders> getAllOrders()
	{
		return orepo.findAll();
	}
	
	public List<Orders> findByDate(String dateoforder)
	{
		return orepo.findByDateoforder(dateoforder);
	}
	
	public Orders update(int oid, Orders order)
	{
		Orders o=orepo.getById(oid);
		o.setDateoforder(order.getDateoforder());
		o.setPid(order.getPid());
		o.setUid(order.getUid());
		orepo.save(o);
		return o;
	}
}