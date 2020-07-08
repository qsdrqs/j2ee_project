package grp.wudi.j2ee.dao;

import grp.wudi.j2ee.entity.House;

import java.util.List;

public interface HouseDao {
    //查找所有房源信息
    public List<House> findAll();

    //根据房源id查找房源信息
    public House findById(int id);

    //根据用户id查找房源信息
    public List<House> findByUserId(int uid);

    //根据关键字查找房源信息
    public List<House> findByKeyword(House house);

    //添加房源信息
    public int addHouse(House house);

    //更新房源信息
    public int updateHouse(House house);

    //删除房源信息
    public int deleteHouse(int id);

    //获取图片名字
    public String getImgName(int id);



}
