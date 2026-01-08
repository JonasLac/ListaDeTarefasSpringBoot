package com.jonas.todo.mapper;


import com.jonas.todo.dto.TarefaCreateDTO;
import com.jonas.todo.dto.TarefaResponseDTO;
import com.jonas.todo.dto.TarefaUpdateDTO;
import com.jonas.todo.model.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "titulo", source = "dto.titulo")
    @Mapping(target = "descricao", source = "dto.descricao")
    @Mapping(target = "concluida", constant = "false")
    @Mapping(target = "dataCriacao", ignore = true)
    Tarefa toEntity(TarefaCreateDTO dto);

    TarefaResponseDTO toResponseDTO(Tarefa tarefa);

    void updateEntityFromDTO(TarefaUpdateDTO dto, @MappingTarget Tarefa tarefa);

}
