package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.mybatis.entity.City;
import com.example.demo.mybatis.service.CityService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTests {

	@Autowired
	private CityService cityService;
	@Test
	public void testCityService(){
		List<City> cityList = cityService.getAll();
	    for (City city : cityList) {
			System.out.println("Id "+city.getId()+" Name "+city.getName()+" State "+city.getState());
		}
	}
}
