package com.jonas.todo.controller;

import com.jonas.todo.mapper.TarefaMapper;
import com.jonas.todo.model.Tarefa;
import com.jonas.todo.service.TarefaService;
import com.jonas.todo.dto.TarefaCreateDTO;
import com.jonas.todo.dto.TarefaResponseDTO;
import com.jonas.todo.dto.TarefaUpdateDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;
    private final TarefaMapper mapper;


    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criar(@Valid @RequestBody TarefaCreateDTO dto) {
        Tarefa tarefa = tarefaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDTO(tarefa));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodas() {
        return ResponseEntity.ok(tarefaService.listarTodas());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid TarefaUpdateDTO dto) {

        Tarefa tarefa = tarefaService.atualizar(id, dto);

        return ResponseEntity.ok(toResponseDTO(tarefa));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private TarefaResponseDTO toResponseDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getConcluida(),
                tarefa.getDataCriacao()
        );
    }
}
