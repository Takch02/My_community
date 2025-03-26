package clonecoding.velog_clone;

import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VelogCloneApplicationTests {


    @Autowired
    private UserService userService;

    @Test
    void test_01(){

        User user = new User("chan", "tagtag1010", "tag22kr@naver.com", "010-3937-5008");
        //userService.insertUser(user);

        //User user_01 = userService.getUserByName(user.getUsername());

        User user_02 = userService.getUserByName(user.getUsername());
        userService.deleteUser(user_02.getId());
    }

}
