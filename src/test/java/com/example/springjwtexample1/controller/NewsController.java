package com.example.springjwtexample1.controller;

import com.example.springjwtexample1.Utils.FakeUtils;
import com.example.springjwtexample1.model.News;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @RequestMapping(method = RequestMethod.GET)
    public List<News> news() {
        return FakeUtils.getAllNews();
    }
}
