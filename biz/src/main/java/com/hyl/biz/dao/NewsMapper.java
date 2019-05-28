package com.hyl.biz.dao;

import com.hyl.biz.model.News;

import java.util.List;

public interface NewsMapper {
    public int addnews(News news);

    public void deletenews(News news);

    public int updatenews(News news);

    public List<News> newsone(News news);
}
