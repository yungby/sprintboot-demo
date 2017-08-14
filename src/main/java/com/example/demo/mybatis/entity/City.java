/**
 * 
 */
package com.example.demo.mybatis.entity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yungby
 *
 */
@Table(name = "city")
public class City {

	@Id
	private String id;
	private String name;
	private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
