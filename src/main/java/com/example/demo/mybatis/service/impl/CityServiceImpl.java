/**
 * 
 */
package com.example.demo.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mybatis.entity.City;
import com.example.demo.mybatis.mapper.CityMapper;
import com.example.demo.mybatis.service.CityService;
import com.github.pagehelper.PageHelper;

/**
 * @author yungby
 *
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityDao;
	
	@Override
	public List<City> getAll() {
		PageHelper.startPage(1,1);
		return cityDao.selectAll();
	}

}
