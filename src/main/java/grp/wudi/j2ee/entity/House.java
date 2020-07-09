package grp.wudi.j2ee.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class House {

    private int houseId;            //房子编号
    private int userId;             //用户ID
    private String housePicture;    //房子图片，存放链接
    private String address;         //房子的位置
    private int unitPrice;          //房子的单位价格
    private int area;               //房子的面积

    private int status;             //房子的状态：0表示审核中，1表示通过,2表示审核不通过，3表示已出售
    private String statusStr;

    private int floor;              //房子的楼层
    private String description;     //对房子的描述
    private int hasLift;        //房子是否有电梯
    private String hasLiftStr;
    private int type;               //房子种类:0表示卖，1表示租
    private String typeStr;


    private int agentId;           //与房源对应的经纪人ID

    /**
     * 设置价格区间
     */
    private int highestPrice;
    private int lowestPrice;


    /**
     * 设置面积区间
     */
    private int maxArea;
    private int minArea;
    private Date createTime;
    private String createTimeStr;
    private String houseHead;
    private Integer houseRoomnum;
    private Integer houseLivingroomnum;
    private Integer houseTotalfloor;
    private String houseDecoration;
    private String decorationdesc;
    private String sellingPoint;
    private String surroundings;
    private String traffic;

    public String getDecorationdesc() {
        return decorationdesc;
    }

    public void setDecorationdesc(String decorationdesc) {
        this.decorationdesc = decorationdesc;
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint;
    }

    public String getSurroundings() {
        return surroundings;
    }

    public void setSurroundings(String surroundings) {
        this.surroundings = surroundings;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public Integer getHouseRoomnum() {
        return houseRoomnum;
    }

    public void setHouseRoomnum(Integer houseRoomnum) {
        this.houseRoomnum = houseRoomnum;
    }

    public Integer getHouseLivingroomnum() {
        return houseLivingroomnum;
    }

    public void setHouseLivingroomnum(Integer houseLivingroomnum) {
        this.houseLivingroomnum = houseLivingroomnum;
    }

    public Integer getHouseTotalfloor() {
        return houseTotalfloor;
    }

    public void setHouseTotalfloor(Integer houseTotalfloor) {
        this.houseTotalfloor = houseTotalfloor;
    }

    public String getHouseDecoration() {
        return houseDecoration;
    }

    public void setHouseDecoration(String houseDecoration) {
        this.houseDecoration = houseDecoration;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        if (createTime != null) {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            createTimeStr = date.format(this.createTime);
            return createTimeStr;
        }
        return null;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getHouseHead() {
        return houseHead;
    }

    public void setHouseHead(String houseHead) {
        this.houseHead = houseHead;
    }

    public int getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(int maxArea) {
        this.maxArea = maxArea;
    }

    public int getMinArea() {
        return minArea;
    }

    public void setMinArea(int minArea) {
        this.minArea = minArea;
    }

    public int getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(int lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public int getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(int highestPrice) {
        this.highestPrice = highestPrice;
    }


    public String getStatusStr() {
        switch (status){
            case 0:
                return "审核中";
            case 1:
                return "审核通过";
            case 2:
                return "审核未通过";
            case 3:
                return "已出售";
        }
        return "错误";
    }
    
    public String getTypeStr() {
        switch (type){
            case 0:
                return "出售";
            case 1:
                return "出租";
        }
        return "错误";
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }


    public House() {
        this.createTime = new Date();
    }

    @Override
    public String toString() {
        return "House{" +
                "houseId=" + houseId +
                ", userId=" + userId +
                ", housePicture='" + housePicture + '\'' +
                ", address='" + address + '\'' +
                ", unitPrice=" + unitPrice +
                ", area=" + area +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", floor=" + floor +
                ", description='" + description + '\'' +
                ", hasLift=" + hasLift +
                ", hasLiftStr='" + hasLiftStr + '\'' +
                ", type=" + type +
                ", typeStr='" + typeStr + '\'' +
                ", agentId=" + agentId +
                ", highestPrice=" + highestPrice +
                ", lowestPrice=" + lowestPrice +
                ", maxArea=" + maxArea +
                ", minArea=" + minArea +
                ", createTime=" + createTime +
                ", createTimeStr='" + createTimeStr + '\'' +
                ", houseHead='" + houseHead + '\'' +
                ", houseRoomnum=" + houseRoomnum +
                ", houseLivingroomnum=" + houseLivingroomnum +
                ", houseTotalfloor=" + houseTotalfloor +
                ", houseDecoration='" + houseDecoration + '\'' +
                ", decorationdesc='" + decorationdesc + '\'' +
                ", sellingPoint='" + sellingPoint + '\'' +
                ", surroundings='" + surroundings + '\'' +
                ", traffic='" + traffic + '\'' +
                '}';
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHousePicture() {
        return housePicture;
    }

    public void setHousePicture(String housePicture) {
        this.housePicture = housePicture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHasLift() {
        return hasLift;
    }

    public void setHasLift(int hasLift) {
        this.hasLift = hasLift;
    }

    public String getHasLiftStr() {
        if(this.getHasLift()==0){
            return "无";
        }else {
            return "有";
        }
    }

    public void setHasLiftStr(String hasLiftStr) {
        this.hasLiftStr = hasLiftStr;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
}
