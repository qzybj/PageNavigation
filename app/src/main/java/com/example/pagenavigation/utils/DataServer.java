package com.example.pagenavigation.utils;

import com.example.pagenavigation.bean.PNItem;

import java.util.ArrayList;
import java.util.List;

public class DataServer {

    public static List<PNItem> getSampleData() {
        List<PNItem> list = new ArrayList<PNItem>();
        for (int i = 0; i < 50; i++) {
            list.add(new PNItem("name"+i,i));
        }
        return list;
    }
}
