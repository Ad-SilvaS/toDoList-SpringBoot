package br.com.dgg.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.dgg.todolist.entity.Todo;
import br.com.dgg.todolist.repository.TodoRepository;
import br.com.dgg.todolist.service.exception.ResourceNotFoundException;

@Service
public class TodoService {
    private TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public List<Todo> create(Todo todo) {
        repo.save(todo);
        return findAll();
    }

    public List<Todo> findAll() {
        Sort sort = Sort.by("priority").ascending().and(Sort.by("name").ascending());
        return repo.findAll(sort);
    }

    public List<Todo> findByName(String name) {
        List<Todo> list = repo.findByNameContainingIgnoreCase(name);

        if (list.isEmpty()) {
            throw new ResourceNotFoundException(name);
        }

        return list;
    }

    public List<Todo> findByPriority(Integer priority) {
        List<Todo> list = repo.findByPriority(priority);

        if (list.isEmpty()) {
            throw new ResourceNotFoundException(priority);
        }

        return list;
    }

    public Todo updateName(Long id, String name) {
        Todo todoName = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        todoName.setName(name);

        return repo.save(todoName);
    }

    public Todo updateDescription(Long id, String desc) {
        Todo todoDesc = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        todoDesc.setDescription(desc);

        return repo.save(todoDesc);
    }

    public Todo updatePriority(Long id, Integer priority) {
        Todo todoPriority = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        todoPriority.setPriority(priority);

        return repo.save(todoPriority);
    }

    public Todo updateAccomplished(Long id, boolean accomplished) {
        Todo todoAccomplished = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        todoAccomplished.setAccomplished(accomplished);

        return repo.save(todoAccomplished);
    }

    public List<Todo> delete(Long id) {
        repo.deleteById(id);
        return findAll();
    }
}
