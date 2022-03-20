package com.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Category;
import com.org.entity.Product;
import com.org.entity.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo prepo;
	
	public Product addProduct(Product product)
	{
		Product p=prepo.save(product);
		return p;
	}
	
	public List<String> getAllProducts()
	{
		return prepo.findProduct();
	}
	
	public List<String> ProductById(int pid)
	{
		return prepo.findPid(pid);
	}
	
	public Product updateProduct(int pid, Product product)
	{
		Product p=prepo.getById(pid);
		p.setColor(product.getColor());
		p.setPname(product.getPname());
		p.setPrice(product.getPrice());
		p.setCategory(product.getCategory());
		prepo.save(p);
		return p;
	}
	
	public void deleteProduct(int pid)
	{
		prepo.deleteById(pid);
	}
}