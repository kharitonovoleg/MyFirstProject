package com.oleg.dao;

import com.oleg.first.Event;

public interface EventDao extends ItemDao<Event> {

    Event getById(int id);

    void add(Event event);

    void update(Event event);

    void delete(int id);
}