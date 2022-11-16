package com.iifast.foodorderapp.Models;

public class CartModel {
    int orderImage;
    String cart_id, id,name,price,quantity, order_num;

    public CartModel(int orderImage,String name, String price, String quantity,String order_num) {

        this.orderImage=orderImage;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.order_num = order_num;
    }

    public String getOrder_num() {
        return order_num;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
