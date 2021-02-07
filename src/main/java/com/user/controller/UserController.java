package com.user.controller;

import com.github.pagehelper.PageInfo;
import com.user.entity.*;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("/search")
    public Result ResultSelectAll(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "sex", required = false) String sex,
                                  @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        PageInfo<List<Map<String,Object>>> list = userService.SelectAll(name,sex,pageSize,pageNum);
      return Result.success(list);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable String id){
            UserEntity userEntity = userService.selectById(Integer.parseInt(id));
            return Result.success(userEntity);
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result del(@PathVariable String id){
        userService.del(Integer.parseInt(id));
        return Result.success();
    }

    /**
     * 修改
     *
     * @return
     */
    @PutMapping()
    public Result update(@RequestBody UserEntity user){
         userService.update(user);
         return Result.success();
    }
    /**
     * 增加数据
     *
     * @return
     */
    @PostMapping()
    public Result add(@RequestBody UserEntity user){
         userService.add(user);
       return Result.success();
    }

    /**
     * 查询所有的省级信息
     * @return
     */
    @GetMapping("/province")
    public Result getProvince(){
      List<SysCity> list = userService.selectProvince();
        return Result.success(list);
    }

    @GetMapping("/city/{id}")
    public Result getCity(@PathVariable String id){
        List<SysCity> list = userService.selectCityById(Integer.parseInt(id));
        return Result.success(list);
    }
    @GetMapping("/region/{id}")
    public Result getRegion(@PathVariable String id){
        List<SysCity> list = userService.selectCityById(Integer.parseInt(id));
        return Result.success(list);
    }

    /**
     * 获取饼图地址信息
     * @return
     */
    @GetMapping("/address")
    public Result getAddress(){
        List<Address> list = userService.getAddress();
        return Result.success(list);
    }
    @GetMapping("/name")
    public Result getName(){
        List<NameCount> list = userService.getName();
        return Result.success(list);
    }
}
