package com.argos.provabackend.domain.user.repositories;

import com.argos.provabackend.domain.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
