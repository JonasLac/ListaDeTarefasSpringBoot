package com.jonas.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaUpdateDTO {

    @NotBlank
    private String titulo;

    private String descricao;

    @NotNull
    private Boolean concluida;

}
