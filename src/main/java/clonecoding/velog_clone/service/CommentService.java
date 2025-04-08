package clonecoding.velog_clone.service;

import clonecoding.velog_clone.dto.Comment;
import clonecoding.velog_clone.dto.Post;
import clonecoding.velog_clone.mapper.CommentMapper;
import clonecoding.velog_clone.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    public void insertComment(Comment comment) {
        commentMapper.insertComment(comment);
    }

    public List<Comment> getPostByName(int postid) {
        return commentMapper.selectCommentByPostid(postid);
    }

    public int updateComment(Comment comment) {
        return commentMapper.updateComment(comment);
    }

    public void deleteComment(int id) {

        commentMapper.deleteComment(id);
    }
}
