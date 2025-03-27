package clonecoding.velog_clone.service;

import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.dto.Post;
import clonecoding.velog_clone.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    public void insertPost(Post post) {
        postMapper.insertPost(post);
    }

    public List<Post> getPostByName(String username) {
        return postMapper.selectPostById(username);
    }

    public List<Post> getAllPosts() {
        return postMapper.selectAllPost();
    }

    public Post selectPostByTitle(String title) {
        return postMapper.selectPostByTitle(title);
    }

    public void updatePost(Post post) {
        postMapper.updatePost(post);
    }

    public void deletePost(int id) {
        postMapper.deletePost(id);
    }
}
