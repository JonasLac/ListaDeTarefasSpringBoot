package com.jonas.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TarefaResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Boolean concluida;
    private LocalDateTime dataCriacao;

    public TarefaResponseDTO(Long id, @NotBlank String titulo, String descricao, @NotNull Boolean concluida, LocalDateTime dataCriacao) {
    }
}
