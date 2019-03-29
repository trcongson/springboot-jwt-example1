package com.example.springjwtexample1.Utils;

import com.example.springjwtexample1.model.News;

import java.util.ArrayList;
import java.util.List;

public class FakeUtils {
    public static List<News> getAllNews(){
        List<News> newsList = new ArrayList<News>();
        newsList.add(new News("T1","Deha","Storm"));
        newsList.add(new News("T2","CMC","Earth"));
        newsList.add(new News("T1","FPT","Ember"));
        return newsList;
    }
}
