package grp.wudi.j2ee.service.impl;

import grp.wudi.j2ee.dao.HouseDao;
import grp.wudi.j2ee.entity.House;
import grp.wudi.j2ee.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public House getHouseById(int id) {
        return houseDao.findById(id);
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
}
