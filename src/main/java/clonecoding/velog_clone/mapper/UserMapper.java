package clonecoding.velog_clone.mapper;

import clonecoding.velog_clone.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User selectUser(String username);
}
