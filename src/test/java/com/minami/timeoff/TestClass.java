package com.minami.timeoff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        List<HashMap<String,Object>> list = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("1","zz");
        list.add(map);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("2","zz");
        list.add(map2);
        System.out.println(list);
        System.out.println(list.get(0).get("1"));
    }
}
