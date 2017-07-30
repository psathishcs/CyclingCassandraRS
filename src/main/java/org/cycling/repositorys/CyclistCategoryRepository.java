package org.cycling.repositorys;

import org.cycling.model.CyclistCategory;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

public interface CyclistCategoryRepository extends CassandraRepository<CyclistCategory>{
	@Query("SELECT * FROM cyclist_category")
	public Iterable<CyclistCategory> getAll();
	
	@Query("SELECT * FROM cyclist_category WHERE category =?0")
	public Iterable<CyclistCategory> getByCategory(String category);
	
	@Query("SELECT * FROM cyclist_category WHERE lastname =?0")
	public Iterable<CyclistCategory> getByLastName(String lastname);
	
	@Query("SELECT * FROM cyclist_category WHERE lastname =?0 ALLOW FILTERING")
	public Iterable<CyclistCategory> getByLastNameAllowFilter(String lastname);
	 
	
}
