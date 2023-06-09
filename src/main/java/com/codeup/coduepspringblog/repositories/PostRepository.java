package com.codeup.coduepspringblog.repositories;

import com.codeup.coduepspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByTitle(String postToBeDeleted);
}
