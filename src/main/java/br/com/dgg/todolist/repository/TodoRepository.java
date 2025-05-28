package br.com.dgg.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dgg.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    public List<Todo> findByPriority(Integer priority);
}
