package clonecoding.velog_clone.dto.post;

import clonecoding.velog_clone.dto.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Post {

    private Long id;           // 글 ID
    private String title;      // 글 제목
    private String content;    // 글 내용
    private LocalDateTime createdAt;  // 글 작성 시간
    private User user;      // 작성자 정보 (UserDTO)

    // 기본 생성자
    public Post() {}

    // 모든 필드를 포함한 생성자
    public Post(Long id, String title, String content, LocalDateTime createdAt, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    }
}
