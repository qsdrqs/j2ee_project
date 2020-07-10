package grp.wudi.j2ee.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import grp.wudi.j2ee.dao.HouseDao;
import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDao houseDao;

    @Override
    public List<House> findAll() {
        return houseDao.findAll();
    }

    @Override
    public List<House> getHouseByKeyword(House house) {
        return houseDao.findByKeyword(house);
    }

    @Override
    public String getPicture(House house) {
        return house.getHousePicture();
    }

    @Override
    public String getStatus(House house) {
        return house.getStatusStr();
    }

    @Override
    public House getHouseById(int id) {
        return houseDao.findById(id);
    }
    
    @Override
	public List<House> getHouseByUserId(int uid) {
		return houseDao.findByUserId(uid);
	}

    @Override
    public int add(House house) {
        return houseDao.addHouse(house);
    }

    @Override
    public int update(House house) {
        return houseDao.updateHouse(house);
    }

    @Override
    public int delete(int id) {
        return houseDao.deleteHouse(id);
    }

	@Override
	public PageInfo<House> getHouseByUserId(int uid, int p) {
		PageHelper.startPage(p, 5);
		List<House> houses = houseDao.findByUserId(uid);
        return new PageInfo<House>(houses, 5);
    }

    @Override
    public PageInfo<House> findAll(int p) {
        System.out.println("业务层正在执行分页查询所有房源信息...");
        PageHelper.startPage(p, 5);
        List<House> houses = houseDao.findAll();
        return new PageInfo<House>(houses, 5);

    }

    @Override
    public PageInfo<House> findBykeywordsPages(int p, String address, int type,
                                               int minPrice, int maxPrice,
                                               int minArea, int maxArea,
                                               int hasLift) {
        House house = new House();
        house.setAddress(address);
        house.setType(type);
        house.setLowestPrice(minPrice);
        house.setHighestPrice(maxPrice);
        house.setMinArea(minArea);
        house.setMaxArea(maxArea);
        house.setHasLift(hasLift);
        PageHelper.startPage(p, 2);
        List<House> houses = houseDao.findByKeyword(house);
        return new PageInfo<House>(houses, 3);
    }


    @Override
    public String downloadImg(int houseId) {
//        String name = houseDao.getImgName(houseId);
//        String path = HouseService.class.getResource("/").getPath();
        House house = houseDao.findById(houseId);
        String path = house.getHousePicture();
        return path;

    }

    @Override
    public int addHouseFront(House house) {
        return houseDao.addHouseFront(house);
    }







    @Override
    public Integer getAgentId(int hid) {
        return houseDao.getAgent(hid);

    }

    @Override
    public List<House> allocation() {
        List<House> houses = new ArrayList<House>();
        for (House house : houseDao.findByStatus()) {
            if (null == getAgentId(house.getHouseId()))
                houses.add(house);
        }
        return houses;
    }

    @Override
    public PageInfo<House> allocation(int p) {
        PageHelper.startPage(p, 5);
        List<House> houses = allocation();
        return new PageInfo<House>(houses, 5);
    }

    @Override
    public int allow(House house) {
        return houseDao.allocation(house);
    }
}
