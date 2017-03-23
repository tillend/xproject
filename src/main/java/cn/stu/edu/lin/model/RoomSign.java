package cn.stu.edu.lin.model;

public class RoomSign {
    private Integer id;

    private Integer roomnum;

    private String sign1;

    private String sign2;

    private String sign3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public String getSign1() {
        return sign1;
    }

    public void setSign1(String sign1) {
        this.sign1 = sign1 == null ? null : sign1.trim();
    }

    public String getSign2() {
        return sign2;
    }

    public void setSign2(String sign2) {
        this.sign2 = sign2 == null ? null : sign2.trim();
    }

    public String getSign3() {
        return sign3;
    }

    public void setSign3(String sign3) {
        this.sign3 = sign3 == null ? null : sign3.trim();
    }
}