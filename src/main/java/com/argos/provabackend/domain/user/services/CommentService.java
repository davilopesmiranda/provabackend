package com.argos.provabackend.domain.user.services;

import com.argos.provabackend.DTOs.CommentRequestDTO;
import com.argos.provabackend.DTOs.CommentResponseDTO;
import com.argos.provabackend.domain.user.Comment;
import com.argos.provabackend.domain.user.Post;
import com.argos.provabackend.repositories.CommentRepository;
import com.argos.provabackend.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public CommentResponseDTO create(Long postId, CommentRequestDTO dto, String userEmail) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        Comment comment = new Comment();
        comment.setContent(dto.content());
        comment.setUserEmail(userEmail);
        comment.setPost(post);

        Comment saved = commentRepository.save(comment);

        return new CommentResponseDTO(saved.getId(), saved.getContent(), saved.getUserEmail(), post.getId());
    }

    public List<CommentResponseDTO> listByPost(Long postId) {
        return commentRepository.findByPostId(postId)
                .stream()
                .map(c -> new CommentResponseDTO(c.getId(), c.getContent(), c.getUserEmail(), c.getPost().getId()))
                .toList();
    }
}

