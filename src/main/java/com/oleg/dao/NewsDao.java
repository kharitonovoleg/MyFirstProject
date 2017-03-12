package com.oleg.dao;

import com.oleg.first.News;

public interface NewsDao extends ItemDao<News> {

    News getById(int id);

    void add(News news);

    void update(News news);

    void delete(int id);
}
