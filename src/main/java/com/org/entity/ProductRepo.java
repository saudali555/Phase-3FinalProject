package com.org.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	@Query(value="select product.pid,product.pname,product.color,product.price,category.cid,category.cname from product inner join category on product.cid=category.cid", nativeQuery=true)
	public List<String> findProduct();
	
	@Query(value=("select pid,pname,color,price from Product where pid= ?"), nativeQuery = true)
	public List<String> findPid(int pid);
}