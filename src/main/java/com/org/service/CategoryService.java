package com.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Category;
import com.org.entity.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	CategoryRepo crepo;
	
	public Category addCategory(Category category)
	{
		return crepo.save(category);		
	}
	
	public List<String> getAllCategory()
	{
		return crepo.findCategory();
	}
	
	public List<String> CategoryByCid(int cid)
	{
		return crepo.findCid(cid);
	}
}