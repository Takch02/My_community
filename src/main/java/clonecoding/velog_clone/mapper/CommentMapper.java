package clonecoding.velog_clone.mapper;

import clonecoding.velog_clone.dto.Comment;
import clonecoding.velog_clone.dto.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    void insertComment(Comment comment);
    List<Comment> selectCommentByPostid(int postid);
    int updateComment(Comment comment);
    void deleteComment(int id);
}
