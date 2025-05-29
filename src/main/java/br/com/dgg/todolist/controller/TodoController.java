package br.com.dgg.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dgg.todolist.entity.Todo;
import br.com.dgg.todolist.service.TodoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public List<Todo> create(@RequestBody @Valid Todo todo) {
        return service.create(todo);
    }

    @GetMapping
    public List<Todo> findAll() {
        return service.findAll();
    }

    @GetMapping("/name")
    public List<Todo> findByName(String name) {
        return service.findByName(name);
    }

    @GetMapping("/priority")
    public List<Todo> findByPriority(@RequestParam Integer priority) {
        return service.findByPriority(priority);
    }

    @PutMapping("/{id}/update-name")
    public Todo updateName(@PathVariable Long id, @RequestParam String name) {
        return service.updateName(id, name);
    }

    @PutMapping("/{id}/update-desc")
    public Todo updateDescription(@PathVariable Long id, @RequestParam String description) {
        return service.updateDescription(id, description);
    }

    @PutMapping("/{id}/update-priority")
    public Todo updatePriority(@PathVariable Long id, @RequestParam Integer priority) {
        return service.updatePriority(id, priority);
    }

    @PutMapping("/{id}/update-accomplished")
    public Todo updateAccomplished(@PathVariable Long id, @RequestParam boolean accomplished) {
        return service.updateAccomplished(id, accomplished);
    }

    @DeleteMapping("{id}")
    public List<Todo> delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
