package com.midouz.api.service;

import com.midouz.api.entity.Todo;
import com.midouz.api.model.exception.AppException;
import com.midouz.api.model.exception.ErrorCode;
import com.midouz.api.model.request.CreateTodoRequest;
import com.midouz.api.model.response.TodoResponse;
import com.midouz.api.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoResponse getTodoById(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.TODO_NOT_FOUND,"Todo not found"));
        return TodoResponse.from(todo);
    }

    public List<TodoResponse> getTodos(){
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(TodoResponse::from).toList();
    }

    public TodoResponse createTodo(CreateTodoRequest request){
        Todo todo = request.to();
        todoRepository.save(todo);
        return TodoResponse.from(todo);
    }
}
