package com.argos.provabackend.DTOs;

public record CommentResponseDTO(Long id, String content, String userEmail, Long postId) {}
