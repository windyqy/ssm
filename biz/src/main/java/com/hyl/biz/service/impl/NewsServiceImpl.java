package com.hyl.biz.service.impl;

import com.lx.mapper.NewsMapper;
import com.lx.pojo.News;
import com.lx.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    public int add(News news) {
        return newsMapper.addnews(news);
    }
    public void delete(News news){
        newsMapper.deletenews(news);
    }
    public int update(News news){
        return newsMapper.updatenews(news);
    }
    public List<News> listone(News news){
        return newsMapper.newsone(news);
    }
}
