package com.oleg.dao;

import com.oleg.first.UserEvent;

public interface UserEventDao extends ItemDao<UserEvent> {

    UserEvent getById(int id);

    void add(UserEvent userEvent);

    void update(UserEvent userEvent);

    void delete(int id);

}