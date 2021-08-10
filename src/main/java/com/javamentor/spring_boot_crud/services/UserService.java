package com.javamentor.spring_boot_crud.services;

import com.javamentor.spring_boot_crud.models.User;

import java.util.List;

public interface UserService {
    void add(User user);

    User get(long id);

    List<User> getAll();

    void update(long id, User user);

    void updatePassword(long id, String newPassword);

    void delete(long id);

    User getByName(String name);
}
