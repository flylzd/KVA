package com.lemon.kva.constant;


public class Urls {

    private static String SERVER_IP = "112.74.77.59:8080";

    private static String PROJECT_NAME = "/MyApp";   //测试环境

    public static String SERVER_URL = "http://" + SERVER_IP + PROJECT_NAME;

    public static String URL_REGISTER = SERVER_URL + "/user/register";

}
