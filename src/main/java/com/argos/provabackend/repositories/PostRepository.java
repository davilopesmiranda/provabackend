package com.argos.provabackend.repositories;

import com.argos.provabackend.domain.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
