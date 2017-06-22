package com.softeem.orderapp.bean;

import java.io.Serializable;

public class MenuBean implements Serializable {
    private int menuId;
    private String menuName;
    private String menuIntroduce;
    private String menuAddress;
    private double menuPrice;
    private double menuCutprice;
    private double menuDiscount;
    private boolean menuIsDiscount;
    private boolean menuIsDecommend;
    private boolean menuIsOrder;
    private String menuPicUrl;
    private int menuOrderCount;
    private String menuCreateDate;
    private boolean menuStatus;
    private int sort_id;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIntroduce() {
        return menuIntroduce;
    }

    public void setMenuIntroduce(String menuIntroduce) {
        this.menuIntroduce = menuIntroduce;
    }

    public String getMenuAddress() {
        return menuAddress;
    }

    public void setMenuAddress(String menuAddress) {
        this.menuAddress = menuAddress;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(double menuPrice) {
        this.menuPrice = menuPrice;
    }

    public double getMenuCutprice() {
        return menuCutprice;
    }

    public void setMenuCutprice(double menuCutprice) {
        this.menuCutprice = menuCutprice;
    }

    public double getMenuDiscount() {
        return menuDiscount;
    }

    public void setMenuDiscount(double menuDiscount) {
        this.menuDiscount = menuDiscount;
    }

    public boolean isMenuIsDiscount() {
        return menuIsDiscount;
    }

    public void setMenuIsDiscount(boolean menuIsDiscount) {
        this.menuIsDiscount = menuIsDiscount;
    }

    public boolean isMenuIsDecommend() {
        return menuIsDecommend;
    }

    public void setMenuIsDecommend(boolean menuIsDecommend) {
        this.menuIsDecommend = menuIsDecommend;
    }

    public boolean isMenuIsOrder() {
        return menuIsOrder;
    }

    public void setMenuIsOrder(boolean menuIsOrder) {
        this.menuIsOrder = menuIsOrder;
    }

    public String getMenuPicUrl() {
        return menuPicUrl;
    }

    public void setMenuPicUrl(String menuPicUrl) {
        this.menuPicUrl = menuPicUrl;
    }

    public int getMenuOrderCount() {
        return menuOrderCount;
    }

    public void setMenuOrderCount(int menuOrderCount) {
        this.menuOrderCount = menuOrderCount;
    }

    public String getMenuCreateDate() {
        return menuCreateDate;
    }

    public void setMenuCreateDate(String menuCreateDate) {
        this.menuCreateDate = menuCreateDate;
    }

    public boolean isMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(boolean menuStatus) {
        this.menuStatus = menuStatus;
    }

    public int getSort_id() {
        return sort_id;
    }

    public void setSort_id(int sort_id) {
        this.sort_id = sort_id;
    }

    @Override
    public String toString() {
        return "MenuBean [menuId=" + menuId + ", menuName=" + menuName + ", menuIntroduce=" + menuIntroduce
                + ", menuAddress=" + menuAddress + ", menuPrice=" + menuPrice + ", menuCutprice=" + menuCutprice
                + ", menuDiscount=" + menuDiscount + ", menuIsDiscount=" + menuIsDiscount + ", menuIsDecommend="
                + menuIsDecommend + ", menuIsOrder=" + menuIsOrder + ", menuPicUrl=" + menuPicUrl + ", menuOrderCount="
                + menuOrderCount + ", menuCreateDate=" + menuCreateDate + ", menuStatus=" + menuStatus + ", sort_id="
                + sort_id + "]";
    }

}
