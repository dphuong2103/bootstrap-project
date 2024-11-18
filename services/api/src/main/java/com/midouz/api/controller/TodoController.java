package com.midouz.api.controller;

import com.midouz.api.constant.API;
import com.midouz.api.model.request.CreateBookRequest;
import com.midouz.api.model.request.CreateTodoRequest;
import com.midouz.api.model.response.ApiResponse;
import com.midouz.api.model.response.BookResponse;
import com.midouz.api.model.response.SuccessApiResponse;
import com.midouz.api.model.response.TodoResponse;
import com.midouz.api.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(API.API_V1_PREFIX+"todo")
@Slf4j
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<TodoResponse> create(@RequestBody @Valid CreateTodoRequest input){
        log.info("BookController::create - title: {}", input.getName());
        return new SuccessApiResponse<>(todoService.createTodo(input));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<TodoResponse> getById(@PathVariable Long id){
        log.info("BookController::getById - id: {}", id);
        return new SuccessApiResponse<>(todoService.getTodoById(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<TodoResponse>> getAll(){
        log.info("BookController::getAll");
        return new SuccessApiResponse<>(todoService.getTodos());
    }
}
