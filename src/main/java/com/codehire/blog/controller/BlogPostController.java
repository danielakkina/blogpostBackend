
package com.codehire.blog.controller;

import com.codehire.blog.model.BlogPost;
import com.codehire.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/posts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping
    public BlogPost createPost(@RequestBody BlogPost post) {
        return blogPostService.createPost(post);
    }

    @GetMapping
    public List<BlogPost> getAllPosts() {
        return blogPostService.getAllPosts();
    }

    @GetMapping("/{id}")
    public BlogPost getPostById(@PathVariable Long id) {
        return blogPostService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        blogPostService.deletePost(id);
    }

    @PutMapping("/{id}")
    public BlogPost updatePost(@PathVariable Long id, @RequestBody BlogPost post) {
        return blogPostService.updatePost(id, post);
    }

}

