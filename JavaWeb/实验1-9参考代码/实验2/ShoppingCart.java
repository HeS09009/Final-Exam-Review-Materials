package mypackage;

import java.util.*;

public class ShoppingCart {

    private List<CartItem> items = new ArrayList();

    //计算购物车中商品总价
    public Double getTotalPrice() {
        Double totalPrice = 0.0;
        for (CartItem item : items) {
            //【代码四】
            totalPrice+=item.getNum()*item.getPrice();
        }
        return totalPrice;
    }

    //向购物车中添加商品
    public void add(CartItem newItem) {
        /**
         * 遍历所有的商品，如果商品id相同，就将数量进行相加。 如果全部不同，则需要把商品单独添加到购物车
         */
        for (CartItem item : items) {
            //比较id
            if (item.getItemID().equals(newItem.getItemID())/*【代码五】*/) {
                //修改item的数量
                item.setNum(item.getNum() + newItem.getNum());
                return;
            }
        }
        //【代码六】把商品单独添加到购物车
        items.add(newItem);
    }

    public void delete(String itemID) {
        /**
         * 使用迭代器从集合中删除商品。 使用 Iterator对象.remove()方法删除
         */
        Iterator<CartItem> it = items.iterator();//拿到迭代器
        while (it.hasNext()) {   //hasNext():是否存在下一个对象元素
            CartItem item = it.next();//拿到购物车中的商品
            //判断。如果商品id和传过来的id一样，则删除
            if (itemID.equals(item.getItemID())) {
                it.remove();
                //【代码七】跳出循环
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                '}';
    }

    public static void main(String[] args) {
        //测试
        ShoppingCart cart = new ShoppingCart();
        cart.add(new CartItem("C001",12.0,2));
        cart.add(new CartItem("C002",15.0,1));
        cart.add(new CartItem("C001",12.0,1));
        System.out.println(cart);
        System.out.println("商品总价："+cart.getTotalPrice());
        cart.delete("C001");
        System.out.println(cart);

    }
}
