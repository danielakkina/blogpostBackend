
package com.codehire.blog.service;

import com.codehire.blog.model.BlogPost;
import com.codehire.blog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPost createPost(BlogPost post) {
        return blogPostRepository.save(post);
    }

    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost getPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    public void deletePost(Long id) {
        blogPostRepository.deleteById(id);
    }

    public BlogPost updatePost(Long id, BlogPost updatedPost) {
        BlogPost existingPost = blogPostRepository.findById(id).orElse(null);
        if (existingPost != null) {
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setContent(updatedPost.getContent());
            existingPost.setAuthor(updatedPost.getAuthor());
            return blogPostRepository.save(existingPost);
        }
        return null;
    }

}
