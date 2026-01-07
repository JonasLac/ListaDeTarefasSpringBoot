package com.jonas.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaUpdateDTO {

    @NotBlank
    private String titulo;

    private String descricao;

    private Boolean concluida;

}
