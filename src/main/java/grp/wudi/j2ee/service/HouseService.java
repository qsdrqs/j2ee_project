package grp.wudi.j2ee.service;

import grp.wudi.j2ee.entity.House;
import java.util.List;

import com.github.pagehelper.PageInfo;

public interface HouseService {
    public List<House> findAll();
    public List<House> getHouseByKeyword(House house);
    public House getHouseById(int id);
    public List<House> getHouseByUserId(int uid);
    public PageInfo<House> getHouseByUserId(int uid,int p);
    public int add(House house);

    public int update(House house);

    public String getPicture(House house);

    public int delete(int id);

    public String getStatus(House house);

}
