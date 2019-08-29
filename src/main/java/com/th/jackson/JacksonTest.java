package com.th.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.Lists;
import com.th.mybatisTest.po.User;
import com.th.util.JsonUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by tianhui on 16/9/17.
 */
public class JacksonTest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static String userToJson(final User user) {
        String userJson = "";
        try {
            userJson = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return userJson;
    }

    private static String listToString(final User user1, final User user2) {
        String listJson = "";
        try {
            List<User> userList = Lists.newArrayList(user1, user2);
            listJson = objectMapper.writeValueAsString(userList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return listJson;
    }

    private static User jsonToUser(String userJson) {
        User user = null;
        try {
           user  = objectMapper.readValue(userJson, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    private static List<User> jsonToList(String listJson) {
        try {
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, User.class);

            @SuppressWarnings("unchecked")
            List<User> users = objectMapper.readValue(listJson, collectionType);
            return users;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        User user1 = new User("lily", 20, "f", "this is test1");
        User user2 = new User("lucy", 21, "f", "this is test2");
        String userJson = userToJson(user1);
        String listJson = listToString(user1, user2);
        System.out.println(userJson);
        System.out.println("===========1===========");
        System.out.println(listJson);
        System.out.println("===========2===========");

        User user3 = jsonToUser(userJson);
        System.out.println(user3);
        System.out.println("===========3===========");

        List<User> users = jsonToList(listJson);
        for(User user : users) {
            System.out.println(user);
        }
        System.out.println("===========4===========");

        System.out.println(JsonUtil.toJsonString(users));
        System.out.println("===========5===========");

        User user4 = JsonUtil.jsonToBean(userJson, User.class);
        System.out.println(user4);
        System.out.println("===========6===========");

        List<User> userList = JsonUtil.jsonToList(listJson, User.class);
        for(User user : userList) {
            System.out.println(user);
        }
    }
}
