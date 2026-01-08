package com.jonas.todo.mapper;

import com.jonas.todo.dto.TarefaCreateDTO;
import com.jonas.todo.dto.TarefaResponseDTO;
import com.jonas.todo.dto.TarefaUpdateDTO;
import com.jonas.todo.model.Tarefa;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-08T19:59:08-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class TarefaMapperImpl implements TarefaMapper {

    @Override
    public Tarefa toEntity(TarefaCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo( dto.getTitulo() );
        tarefa.setDescricao( dto.getDescricao() );

        tarefa.setConcluida( false );

        return tarefa;
    }

    @Override
    public TarefaResponseDTO toResponseDTO(Tarefa tarefa) {
        if ( tarefa == null ) {
            return null;
        }

        TarefaResponseDTO tarefaResponseDTO = new TarefaResponseDTO();

        return tarefaResponseDTO;
    }

    @Override
    public void updateEntityFromDTO(TarefaUpdateDTO dto, Tarefa tarefa) {
        if ( dto == null ) {
            return;
        }

        tarefa.setTitulo( dto.getTitulo() );
        tarefa.setDescricao( dto.getDescricao() );
        tarefa.setConcluida( dto.getConcluida() );
    }
}
