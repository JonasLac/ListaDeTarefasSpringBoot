package com.jonas.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaCreateDTO {

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    private String descricao;

}
