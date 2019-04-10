package cn.uppp.imooc.blog.dao;

import cn.uppp.imooc.blog.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> list();

    User getById(Integer id);

    int saveOrUpdate(User user);

    int remove(Integer id);
}
