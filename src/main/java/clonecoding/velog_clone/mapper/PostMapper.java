package clonecoding.velog_clone.mapper;

import clonecoding.velog_clone.dto.post.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

    void insertPost(Post post);
    Post selectPostById(int id);
    void updatePost(Post post);
    void deletePost(Post post);
}
