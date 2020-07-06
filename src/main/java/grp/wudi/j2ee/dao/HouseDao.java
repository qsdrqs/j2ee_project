package grp.wudi.j2ee.dao;

import grp.wudi.j2ee.entity.House;

import java.util.List;

public interface HouseDao {
    public List<House> findAll();

    public House findById(int id);
    
    public List<House> findByUserId(int uid);

    public List<House> findByKeyword(House house);

    public int addHouse(House house);

    public int updateHouse(House house);

    public int deleteHouse(int id);




}
