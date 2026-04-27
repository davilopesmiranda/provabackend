package com.argos.provabackend.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

public record PostResponseDTO(
        @Schema(example = "1") Long id,
        @Schema(example = "Meu primeiro post") String title,
        @Schema(example = "Este é o conteúdo da postagem") String content,
        @Schema(example = "seu@email.com") String userEmail
) {}
