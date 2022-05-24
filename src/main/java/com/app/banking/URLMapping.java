package com.app.banking;

public class URLMapping {
    public static final String API_PATH = "/api";
    public static final String ID = "/{id}";

    //cards
    public static final String CARDS = API_PATH +"/cards";
    public static final String MY_CARDS = "/my_cards/{id}";

    //deposits
    public static final String DEPOSITS = API_PATH + "/deposits";
    public static final String MY_DEPOSITS = "/my_deposits/{id}";

    //users
    public static final String USERS = API_PATH +"/users";

    //reports
    public static final String REPORTS = API_PATH +"/reports";

    //emails
    public static final String EMAIL = API_PATH + "/email";

}
