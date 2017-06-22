package com.softeem.orderapp.constant;

/**
 * Created by Edward on 2017/6/20.
 */

public class ServerUrl {
    public static String IP = "218.197.97.78";
    public static String SERVER_PATH = "http://" + IP + ":9090/OrderServer";
    public static String GET_ALL_TYPE = SERVER_PATH + "/menuController/getAllType.action";

    public static String GET_ALL_MENU = SERVER_PATH + "/menuController/getAllMenu.action";

    public static String GET_MENU_BY_TYPE = SERVER_PATH + "/menuController/getMenuByType.action?typeId=";
    public static String GET_MENU_BY_ID = SERVER_PATH + "/menuController/getMenuByMenuId.action?menuId=";
    public static String SEARCH_BY_NAME = SERVER_PATH + "/menuController/searchByName.action?shortName=";

    public static String GET_TYPE_BY_MENU_ID = SERVER_PATH + "/menuController/getTypeByMenuId.action?menuId=";
}
