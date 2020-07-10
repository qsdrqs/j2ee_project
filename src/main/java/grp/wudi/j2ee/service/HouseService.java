package grp.wudi.j2ee.service;

import com.github.pagehelper.PageInfo;
import grp.wudi.j2ee.entity.House;

import java.util.List;

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
    //分页

    PageInfo<House> findAll(int p);

    PageInfo<House> findBykeywordsPages(int p, String address, int type, int minPrice, int maxPrice, int minArea, int maxArea, int hasLift);

    //获取图片路径
    public String downloadImg(int houseId);

    public int addHouseFront(House house);

    public Integer getAgentId(int hid);

    List<House> allocation();

    PageInfo<House> allocation(int p);

    public int allow(House house);

}
