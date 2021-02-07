package com.user.service;

import com.github.pagehelper.PageInfo;
import com.user.entity.Address;
import com.user.entity.NameCount;
import com.user.entity.SysCity;
import com.user.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
     PageInfo<List<Map<String,Object>>> SelectAll(String name,String sex,int pageSize, int pageNum);
     int del(int id);
     int SelectTotals();
     int update(UserEntity user);
     int add(UserEntity userEntity);
     UserEntity selectById(int id);
     List<SysCity> selectProvince();
     List<SysCity> selectCityById(int id);
     List<Address> getAddress();
     List<NameCount>getName();
}
