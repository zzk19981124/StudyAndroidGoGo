package com.example.mystudygogo;

import com.example.mystudygogo.bean.Job;
import com.example.mystudygogo.bean.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/8/17
 */
public class ObjectUnitTest {

    @Test
    public void testObject(){
        User u1 = new User("ak","123",false,18);

        Gson gson = new Gson();

        String json = gson.toJson(u1);
        System.out.println("序列化： "+json);

        User u2 = gson.fromJson(json,User.class);
        System.out.println("反序列化"+u2.getUserName()+" - "+u2.getPassWord());
    }

    @Test
    public void testNestedObject(){
        User u1 = new User("ak11111","admin",false,23);
        Job j1 = new Job("工人",1000);
        u1.setJob(j1);

        Gson gson = new Gson();

        String json = gson.toJson(u1);
        System.out.println(json);

        User u2 = gson.fromJson(json,User.class);
        System.out.println(u2.getJob()+"-"+u2.getPassWord());
    }

    @Test
    public void test1Object(){
        User[] users1 = new User[3];
        users1[0] = new User("ak1","123",false,22);
        users1[1] = new User("admin","admin",false,11);

        Gson gson = new Gson();
        String json = gson.toJson(users1);
        System.out.println(json);

        User[] users2 = gson.fromJson(json,User[].class);
        for (User user:users2){
            System.out.println(user);
        }

    }
    @Test
    public void testListObject(){
        List<User> list1 = new ArrayList<>();
        list1.add(new User("ak1","123",false,22));
        list1.add(new User("admin","admin",false,11));
        list1.add(null);

        Gson gson = new Gson();

        String json = gson.toJson(list1);
        System.out.println(json);

        System.out.println();

        //反序列化
        Type type = new TypeToken<List<User>>(){
        }.getType();
        List<User> list2 = gson.fromJson(json,type);
        for (User list:list2){
            System.out.println(list);
        }
    }
}
