package clonecoding.velog_clone.service;

import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public User getUserByName(String username) {
        return userMapper.selectUser(username);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
