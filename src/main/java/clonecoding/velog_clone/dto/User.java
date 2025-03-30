package clonecoding.velog_clone.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("User")
@Getter
@Setter
public class User {

    private int id;

    @NotBlank
    @Size(min = 6, max = 12, message = "아이디는 6 ~ 12자 사이로 해주세요.")
    private String username;

    @NotBlank
    @Size(min = 6, max = 15, message = "비밀번호는 6 ~ 15자 사이로 해주세요.")
    private String password;

    @Size(min = 15, max = 30, message = "이메일은 15 ~ 30자 사이로 해주세요.")
    private String email;

    @NotBlank
    @Size(min = 13, max = 13, message = "휴대폰 번호는 '-' 포함 13자로 해주세요.")
    private String phone;

    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public User() {

    }
}
