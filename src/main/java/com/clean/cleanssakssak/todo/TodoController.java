package com.clean.cleanssakssak.todo;

import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.todo.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/todo")
public class TodoController {
    private final TodoService service;

    @Operation(summary = "todo 일정 수정" ,description = "일정 내용 수정\n0: 수정 실패, 1: 수정 성공")
    @Parameters(value = {
            @Parameter(name = "userId", description = "todo를 수정하고 싶은 유저의 PK"),
            @Parameter(name = "todoId", description = "해당 todo의 PK"),
            @Parameter(name = "cleaning", description = "수정된 부분이 포함된 내용"),
            @Parameter(name = "doDay", description = "수정된 날짜"),
    })
    @PatchMapping
    public ResVo patchTodo(@RequestBody TodoUpDto dto){
        return service.patchTodo(dto);
    }

    @Operation(summary = "todo 일정 삭제", description = "일정을 삭제\n0: 수정 실패, 1: 수정 성공")
    @Parameters(value = {
            @Parameter(name = "userId", description = "todo를 삭제하고 싶은 유저의 PK"),
            @Parameter(name = "todoId", description = "해당 todo의 PK")
    })
    @DeleteMapping
    public ResVo delTodo(@RequestBody TodoDelDto dto){
        return service.delTodo(dto);
    }

    @Operation(summary = "todo 체크 기능", description = "todo 체크 누르기/취소\n0: 수정 실패, 1: 수정 성공")
    @Parameters(value = {
            @Parameter(name = "userId", description = "todo를 삭제하고 싶은 유저의 PK"),
            @Parameter(name = "todoId", description = "해당 todo의 PK")
    })
    @PostMapping()
    public ResVo toggleCheck(TodoToggleCheckDto dto){
        return service.toggleCheck(dto);
    }
}