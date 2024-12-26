package mypackage;

public class CartItem {
    //商品ID
    private String itemID;
    //商品价格
    private Double price;
    //购买数量
    private Integer num;
    //【代码一】带三个参数的构造函数

    public CartItem(String itemID, Double price, Integer num) {
        this.itemID = itemID;
        this.price = price;
        this.num = num;
    }

    //【代码二】重写toString()

    @Override
    public String toString() {
        return "CartItem{" +
                "itemID='" + itemID + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }

    //【代码三】为全部的私有成员变量定义getter和setter

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
