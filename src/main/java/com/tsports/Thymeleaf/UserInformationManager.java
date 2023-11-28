package com.tsports.Thymeleaf;

import java.util.HashMap;
import java.util.Map;

public class UserInformationManager {
    private Map<String, UserInfo> userMap;

    public UserInformationManager() {
        userMap = new HashMap<>();
        userMap.put("sojib.19991018@gmail.com", new UserInfo("sojib.19991018@gmail.com", "1234","x","z"));
        userMap.put("user2@example.com", new UserInfo("user2@example.com", "1234","x","y"));
    }

    public boolean isValidUser(String email, String password) {
        UserInfo userInfo = userMap.get(email);
        return userInfo != null && userInfo.getPassword().equals(password);
    }
}