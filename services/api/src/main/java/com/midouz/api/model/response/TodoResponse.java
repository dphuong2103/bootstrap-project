package com.midouz.api.model.response;

import com.midouz.api.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
public class TodoResponse {
    private Long id;
    private String name;
    private Instant createdTime;
    private Instant updatedTime;

    public static TodoResponse from(Todo todo){
        return TodoResponse.builder()
                .id(todo.getId())
                .name(todo.getName())
                .createdTime(todo.getCreatedTime())
                .updatedTime(todo.getUpdatedTime()).build();
    }
}
