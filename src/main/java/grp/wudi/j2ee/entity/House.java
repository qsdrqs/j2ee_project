package grp.wudi.j2ee.entity;

public class House {

    private int houseId;//房子编号
    private int userId;//用户ID
    private String housePicture;//房子图片，存放链接
    private String address;//房子的位置
    private int unitPrice;//房子的单位价格
    private int area;//房子的面积
    private int status;//房子的状态：0表示审核中，1表示通过,2表示审核不通过，3表示已出售
    private int floor;//房子的楼层
    private String description;//对房子的描述
    private boolean hasLift;//房子是否有电梯
    private int type;//房子种类:0表示卖，1表示租

    public House(int houseId, int userId, String housePicture, String address, int unitPrice, int area, int status, int floor, String description, boolean hasLift, int type) {
        this.houseId = houseId;
        this.userId = userId;
        this.housePicture = housePicture;
        this.address = address;
        this.unitPrice = unitPrice;
        this.area = area;
        this.status = status;
        this.floor = floor;
        this.description = description;
        this.hasLift = hasLift;
        this.type = type;
    }

    public House() {}

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
                ", floor=" + floor +
                ", description='" + description + '\'' +
                ", hasLift=" + hasLift +
                ", type=" + type +
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

    public boolean isHasLift() {
        return hasLift;
    }

    public void setHasLift(boolean hasLift) {
        this.hasLift = hasLift;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
