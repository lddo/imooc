package cn.uppp.imooc.blog.dao;

import cn.uppp.imooc.blog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static Map<Integer, User> userMap = new ConcurrentHashMap<>();

    static {
        userMap.put(1, new User(1, "tom", "tom@uppp.com"));
        userMap.put(2, new User(2, "jack", "jack@uppp.com"));
        userMap.put(3, new User(3, "jerry", "jerry@uppp.com"));
    }

    @Override
    public List<User> list() {
        return userMap.values().parallelStream().collect(Collectors.toList());
    }

    @Override
    public User getById(Integer id) {
        return userMap.get(id);
    }

    @Override
    public int saveOrUpdate(User user) {
        if (user.getId() == null) {
            user.setId(userMap.size() + 1);
        }
        userMap.put(user.getId(), user);
        return 1;
    }

    @Override
    public int remove(Integer id) {
        if (getById(id) == null) {
            return 0;
        }
        userMap.remove(id);
        return 1;
    }
}
