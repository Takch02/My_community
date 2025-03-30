package clonecoding.velog_clone.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Alias("Post")
@Setter
@Getter
public class Post {

    private int id;           // 글 ID

    @NotBlank(message = "제목을 입력해주세요")
    private String title;      // 글 제목

    @NotBlank(message = "부제목을 입력해주세요")
    private String subtitle;

    @NotBlank(message = "내용을 입력해주세요")
    @Size(min = 20, message = "최소 20자 이상 적어주세요")
    private String content;    // 글 내용

    private String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime created_at;  // 글 작성 시간
    private int userid;      // 작성자 정보 (User)

    // 기본 생성자
    public Post() {}

    // 모든 필드를 포함한 생성자
    public Post(int id, String title, String content, LocalDateTime created_at, int userid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.userid = userid;
    }
}
