package br.com.dgg.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.dgg.todolist.entity.Todo;
import br.com.dgg.todolist.repository.TodoRepository;

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
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
        return repo.findAll(sort);
    }

    public List<Todo> findByPriority(Integer priority) {
        List<Todo> list = repo.findByPriority(priority);

        return list;
    }

    public List<Todo> update(Todo todo) {
        repo.save(todo);
        return findAll();
    }

    public List<Todo> delete(Long id) {
        repo.deleteById(id);
        return findAll();
    }
}
