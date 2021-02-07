package com.user.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.dao.UserDao;
import com.user.entity.Address;
import com.user.entity.NameCount;
import com.user.entity.SysCity;
import com.user.entity.UserEntity;
import com.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public PageInfo<List<Map<String,Object>>> SelectAll(String name,String sex,int pageSize,int pageNum) {
        Page page = PageHelper.startPage(pageNum, pageSize);
        PageInfo<List<Map<String,Object>>> eventEventPageInfo = page.doSelectPageInfo(() -> userDao.search(name,sex));
        page.close();
        return eventEventPageInfo;
    }

    @Override
    public int del(int id) {
        return userDao.delById(id);
    }

    @Override
    public int SelectTotals() {
        return userDao.SelectTotals();
    }

    @Override
    public int update( UserEntity user) {
        return userDao.update(user);
    }

    @Override
    public int add(UserEntity userEntity) {
        return userDao.insert(userEntity);
    }

    @Override
    public UserEntity selectById(int id) {
       UserEntity userEntity = userDao.selectById(id);
       int sid = Integer.parseInt(userEntity.getAddress());
       String province = userDao.getProvince(sid);
       String city = userDao.getCity(sid);
       String region = userDao.getRegion(sid);
       String [] addressName = {province,city,region};
       userEntity.setAddressName(addressName);
         return userEntity;
    }

    @Override
    public List<SysCity> selectProvince() {
        return userDao.selectAllProvince();
    }

    @Override
    public List<SysCity> selectCityById(int id) {
        return userDao.selectCityById( id);
    }

    @Override
    public List<Address> getAddress() {
        return userDao.getAddress();
    }

    @Override
    public List<NameCount> getName() {
        return userDao.getName();
    }
}
