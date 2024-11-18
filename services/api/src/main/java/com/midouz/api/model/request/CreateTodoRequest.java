package com.midouz.api.model.request;

import com.midouz.api.entity.Todo;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoRequest {
    @NotBlank(message = "TODO_NAME_EMPTY")
    private String name;

    public Todo to(){
        return Todo.builder()
                .name(this.getName())
                .build();
    }
}
