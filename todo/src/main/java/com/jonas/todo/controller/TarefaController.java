package com.jonas.todo.controller;

import com.jonas.todo.model.Tarefa;
import com.jonas.todo.service.TarefaService;
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

    @PostMapping
    public ResponseEntity<Tarefa> criar(@Valid @RequestBody Tarefa tarefa) {
        Tarefa criada = tarefaService.criar(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @GetMapping ResponseEntity<List<Tarefa>> listarTodas() {
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Tarefa tarefa) {
        Tarefa aturalizada = tarefaService.atualizar(id, tarefa);
        return ResponseEntity.ok(aturalizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
