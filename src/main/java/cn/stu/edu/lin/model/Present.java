package cn.stu.edu.lin.model;

public class Present {
    private Integer id;

    private String presentname;

    private String integral;

    private String price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPresentname() {
        return presentname;
    }

    public void setPresentname(String presentname) {
        this.presentname = presentname == null ? null : presentname.trim();
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral == null ? null : integral.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }
}