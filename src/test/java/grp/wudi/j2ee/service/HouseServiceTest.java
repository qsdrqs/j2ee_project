package grp.wudi.j2ee.service;

import grp.wudi.j2ee.entity.House;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class HouseServiceTest {

    @Autowired
    private HouseService houseService;


    @Test
    public void findAllTest() {
        List<House> list = houseService.findAll();
        for (House house:list) {
            System.out.println(house);
        }
    }



    @Test
    public void findByIdTest(){

        System.out.println(houseService.getHouseById(2));
    }
    
    @Test
    public void findByUserIdTest(){

        System.out.println(houseService.getHouseByUserId(1));
    }



    @Test
    public  void findByKeyword(){
        House house = new House();
        house.setHighestPrice(60000);
        house.setLowestPrice(20000);
        house.setMinArea(150000);
        house.setMaxArea(2000000);
        List<House> list = houseService.getHouseByKeyword(house);
        for (House house1:list) {
            System.out.println(house1);
        }

    }



    @Test
    public void addHouseTest() {
        House house = new House();
        house.setUserId(1);
        house.setHousePicture("hello");
        house.setAddress("Xian Jiaotong University");
        house.setUnitPrice(55000);
        house.setArea(200000);
        house.setStatus(1);
        house.setFloor(2);
        house.setDescription("University");
        house.setHasLift(true);
        house.setType(1);

        houseService.add(house);

    }



    @Test
    public void updateHouseTest(){
        House house = new House();
        house.setHouseId(2);
        house.setUserId(1);
        house.setHousePicture("world");
        house.setAddress("Xian Jiaotong University");
        house.setUnitPrice(50000);
        house.setArea(1000000);
        house.setStatus(1);
        house.setFloor(3);
        house.setDescription("University");
        house.setHasLift(true);
        house.setType(1);

        houseService.update(house);

    }




    @Test
    public void deleteHouseTest(){
        houseService.delete(1);
    }


}
