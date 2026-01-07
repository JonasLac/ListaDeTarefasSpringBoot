package com.jonas.todo.service;

import com.jonas.todo.exception.TarefaNaoEncontradaException;
import com.jonas.todo.model.Tarefa;
import com.jonas.todo.repository.TarefaRepository;
import com.jonas.todo.dto.TarefaCreateDTO;
import com.jonas.todo.dto.TarefaUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public Tarefa criar(TarefaCreateDTO dto) {
        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setConcluida(false);
        tarefa.setDataCriacao(LocalDateTime.now());

        return tarefaRepository.save(tarefa);
    }


    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa atualizar(Long id,TarefaUpdateDTO dto) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setTitulo(dto.getTitulo());
                    tarefa.setDescricao(dto.getDescricao());
                    tarefa.setConcluida(dto.getConcluida());
                    return tarefaRepository.save(tarefa);
                })
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }

    public void deletar(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new TarefaNaoEncontradaException(id);
        }
        tarefaRepository.deleteById(id);
    }

}
