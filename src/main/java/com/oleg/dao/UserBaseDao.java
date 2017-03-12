package com.oleg.dao;

import com.oleg.first.UserBase;

public interface UserBaseDao extends ItemDao<UserBase> {

    UserBase getById(int id);

    void add(UserBase userBase);

    void update(UserBase userBase);

    void delete(int id);
}
