package org.cycling.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.cycling.model.CyclistCategory;
import org.cycling.repositorys.CyclistCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.exceptions.InvalidQueryException;

/**
 * 
 * @author SathishParthasarathy
 * Jul 29, 20176:54:45 PM
 */
@RestController
@RequestMapping("/v1/cycling")
public class CyclistCategoryController {
	
	@Autowired
	private CyclistCategoryRepository cyclistCategoryRepository;
	
	@RequestMapping(path="/cyclistcategory", method=RequestMethod.GET)
	public Iterable<CyclistCategory> getAll(){
		Iterable<CyclistCategory> cyclistCategorys = cyclistCategoryRepository.findAll();
		return cyclistCategorys;
	}
	
	@RequestMapping(path="/cyclistcategory/category/{category}", method=RequestMethod.GET)
	public Iterable<CyclistCategory> getByCategory(@PathVariable("category") String category){
		Iterable<CyclistCategory> cyclistCategorys = cyclistCategoryRepository.getByCategory(category);
		return cyclistCategorys;
	}
	
	@RequestMapping(path="/cyclistcategory/lastname/{lastname}", method=RequestMethod.GET)
	public Iterable<CyclistCategory> getByLastName(@PathVariable("lastname") String lastname){
		Iterable<CyclistCategory> cyclistCategorys = null;
		try {
			cyclistCategorys = cyclistCategoryRepository.getByLastName(lastname);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			cyclistCategorys = cyclistCategoryRepository.getByLastNameAllowFilter(lastname);
		}
		return cyclistCategorys;
	}
}
