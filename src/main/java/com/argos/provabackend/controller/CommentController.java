package com.argos.provabackend.controller;

import com.argos.provabackend.DTOs.CommentRequestDTO;
import com.argos.provabackend.DTOs.CommentResponseDTO;
import com.argos.provabackend.domain.user.services.CommentService;
import com.argos.provabackend.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDTO> create(
            @PathVariable Long postId,
            @RequestBody CommentRequestDTO dto,
            @AuthenticationPrincipal User user) {
        CommentResponseDTO response = commentService.create(postId, dto, user.getEmail());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDTO>> list(@PathVariable Long postId) {
        List<CommentResponseDTO> comments = commentService.listByPost(postId);
        return ResponseEntity.ok(comments);
    }
}
