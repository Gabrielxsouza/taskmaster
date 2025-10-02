package br.ifsp.taskmaster.controller;

import org.springframework.web.bind.annotation.RestController;

import br.ifsp.taskmaster.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import br.ifsp.taskmaster.dto.TaskCreateDto;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.ifsp.taskmaster.dto.TaskDto;
import br.ifsp.taskmaster.dto.TaskUpdateDto;





@RestController
@RequestMapping("/tasks")
@Tag(name = "Task", description = "API para gerenciamento de task")
@Validated
public class TaskController {
    private final TaskService taskService;
  //  private final ModelMapper modelMapper = new ModelMapper();

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @Operation(summary = "Cria uma nova task")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskCreateDto createTask(@Valid @RequestBody TaskCreateDto taskCreateDto) {
        return taskService.createTask(taskCreateDto);
    }

    @Operation(summary = "Buscar todas as tasks")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TaskDto> getAllTasks(Pageable pageable) {
        return taskService.getAllTasks(pageable);
    }

    @Operation(summary = "atualizar uma task")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskUpdateDto updateTask(@PathVariable long id,@Valid @RequestBody TaskUpdateDto taskUpdateDto) {
        return taskService.updateTask(id, taskUpdateDto);
    }

    @Operation(summary = "deletar uma task")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
    }

    @Operation(summary = "buscar uma task por categoria")
    @GetMapping("/{categoria}")
    @ResponseStatus(HttpStatus.OK)
    public Page<TaskDto> getTaskByCategoria(@PathVariable String categoria) {
        return taskService.getTaskByCategoria(categoria);
    }
    
}
