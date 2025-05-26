package br.com.dgg.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dgg.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
