package clonecoding.velog_clone.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {

    @NotBlank()
    @Size(min = 6, max = 12, message = "아이디는 6 ~ 12자 사이로 해주세요.")
    private String username;

    @NotBlank()
    @Size(min = 6, max = 12, message = "비밀번호는 6 ~ 12자 사이로 해주세요.")
    private String password;

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public LoginForm() {}
}
