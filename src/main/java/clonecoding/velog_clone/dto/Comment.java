package clonecoding.velog_clone.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Comment {

    private int id;

    @NotBlank(message = "코멘트를 입력해주세요")
    private String content;

    private String username;

    private LocalDateTime created_at;  // 글 작성 시간
    private int userid;
    private int postid;
    private boolean deletable;
}
