package com.jonas.todo.service;

import com.jonas.todo.exception.TarefaNaoEncontradaException;
import com.jonas.todo.model.Tarefa;
import com.jonas.todo.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public Tarefa criar(Tarefa tarefa) {
        tarefa.setId(null);
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

    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setTitulo(tarefaAtualizada.getTitulo());
                    tarefa.setDescricao(tarefaAtualizada.getDescricao());
                    tarefa.setConcluida(tarefaAtualizada.getConcluida());
                    return tarefaRepository.save(tarefa);
                })
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }

    public void deletar(Long id) {
        if (tarefaRepository.existsById(id)) {
            throw new TarefaNaoEncontradaException(id);
        }
        tarefaRepository.deleteById(id);
    }

}
