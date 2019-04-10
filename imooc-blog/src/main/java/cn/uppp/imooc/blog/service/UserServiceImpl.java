package cn.uppp.imooc.blog.service;

import cn.uppp.imooc.blog.dao.UserRepository;
import cn.uppp.imooc.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> list(){
        return userRepository.list();
    }

    public User getById(Integer id){
        return userRepository.getById(id);
    }

    public int saveOrUpdate(User user){
        return userRepository.saveOrUpdate(user);
    }

    public int remove(Integer id){
        return userRepository.remove(id);
    }
}
