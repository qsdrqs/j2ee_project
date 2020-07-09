package grp.wudi.j2ee.service;

import com.github.pagehelper.PageInfo;
import grp.wudi.j2ee.Controller.HouseController;
import grp.wudi.j2ee.entity.House;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
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

        System.out.println(houseService.getHouseById(1));
    }
    
    @Test
    public void findByUserIdTest(){

        System.out.println(houseService.getHouseByUserId(1));
    }



    @Test
    public  void findByKeyword(){
        House house = new House();
        house.setAddress("tong");

        house.setHighestPrice(55000);
        house.setLowestPrice(0);
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
        house.setUserId(2);
        house.setHousePicture("hello");
        house.setAddress("Xian Jiaotong University");
        house.setUnitPrice(55000);
        house.setArea(200000);
        house.setStatus(1);
        house.setFloor(2);
        house.setDescription("University");
        house.setHasLift(1);
        house.setType(0);

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
        house.setHasLift(1);
        house.setType(1);

        houseService.update(house);

    }


    @Test
    public void deleteHouseTest() {
        houseService.delete(2);
    }

    @Test
    public void run1() {
        PageInfo<House> list = houseService.findBykeywordsPages(1, "tong", 1, 1000, 10000, 50, 120, 1);
        System.out.println(list);
        for (House house : list.getList()) {
            System.out.println(house);
        }

    }
    @Test
    public void run3(){
        HouseController houseController = new HouseController();
        String result = houseController.findAllBypagess(1,"tong",1,0,0,0,0,0);
        System.out.println(result);

    }

    @Test
    public void downloadImgTest() throws IOException {


        String path = "../src/main/webapp/img/avatar.png";
//        Image[] array = new Image[10];
//        Image image = ImageIO.read(new File(path));
//        array[0] = image;

        ImageIcon imglogo = new ImageIcon(ClassLoader.getSystemResource(path));


        System.out.println(imglogo);
    }


}
