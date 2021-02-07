package com.user.dao;
import com.user.entity.Address;
import com.user.entity.NameCount;
import com.user.entity.SysCity;
import com.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserDao {
    List<UserEntity> search(@Param("name") String name,@Param("sex") String sex);
    int insert(@Param("userEntity") UserEntity userEntity);
    int delById(@Param("id") int id);
    int update(@Param("userEntity") UserEntity userEntity);
    int SelectTotals();
    UserEntity selectById(@Param("id") int id);
    List<SysCity> selectAllProvince();
    List<SysCity> selectCityById(@Param("id") int id);
    String getProvince(@Param("id") int id);
    String getCity(@Param("id") int id);
    String getRegion(@Param("id") int id);
    List<Address> getAddress();
    List<NameCount>getName();
}
