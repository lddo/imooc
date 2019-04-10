package cn.uppp.imooc.blog.service;

import cn.uppp.imooc.blog.entity.User;

import java.util.List;

public interface UserService {
    List<User> list();

    User getById(Integer id);

    int saveOrUpdate(User user);

    int remove(Integer id);
}
