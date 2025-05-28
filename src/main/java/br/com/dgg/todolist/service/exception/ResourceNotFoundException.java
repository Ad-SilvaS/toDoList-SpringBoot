package br.com.dgg.todolist.service.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String name) {
        super("Not Found! No results for: " + name);
    }

    public ResourceNotFoundException(Integer priority) {
        super("Not Found! No results for: Priority " + priority);
    }

    public ResourceNotFoundException(Long id) {
        super("Not Found! No results for id: " + id);
    }
}
