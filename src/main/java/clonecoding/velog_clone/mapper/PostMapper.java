package clonecoding.velog_clone.mapper;

import clonecoding.velog_clone.dto.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    void insertPost(Post post);
    void updatePost(Post post);
    void deletePost(int id);
    List<Post> selectPostById(String username);
    List<Post> selectAllPost();
    Post selectPostByTitle(String title);
}
