package org.cycling.model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 * 
 * @author SathishParthasarathy
 * Jul 29, 20176:54:31 PM
 */
@Table(value="cyclist_category")
public class CyclistCategory implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(value="id")
	private UUID id;
	
	@PrimaryKeyColumn(value="category", ordinal =1, type=PrimaryKeyType.PARTITIONED)
	private String category;

	@PrimaryKeyColumn(value="points", ordinal=1, type=PrimaryKeyType.CLUSTERED)
	private int points;
	
	@Column(value="lastname")
	private String lastname;
	
	public CyclistCategory(UUID id, String category, int points, String lastname){
		this.id = id;
		this.category = category;
		this.points = points;
		this.lastname = lastname;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder("id = " + id.toString());
		strBuilder.append("category = " + category);
		strBuilder.append("Points = "  + points);
		strBuilder.append("LastName = " + lastname);
		return strBuilder.toString();
	}
	
	
}
