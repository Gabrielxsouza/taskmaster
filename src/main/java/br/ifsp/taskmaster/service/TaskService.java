package br.ifsp.taskmaster.service;

import br.ifsp.taskmaster.repository.TaskRepository;


import br.ifsp.taskmaster.dto.TaskCreateDto;
import br.ifsp.taskmaster.dto.TaskDto;
import br.ifsp.taskmaster.model.Task;
import br.ifsp.taskmaster.dto.TaskUpdateDto;

import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import br.ifsp.taskmaster.exception.ResourceNotFoundException;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskCreateDto createTask(TaskCreateDto taskCreateDto) {
        Task task = new Task(taskCreateDto.getTitulo(), taskCreateDto.getDescricao(), taskCreateDto.getCategoria(), taskCreateDto.getDataLimite());
        taskRepository.save(task);

        Task saved = taskRepository.save(task);
        return modelMapper.map(saved, TaskCreateDto.class);
    }

    public Page<TaskDto> getAllTasks(Pageable pageable) {
        Page<Task> tasks = taskRepository.findAll(pageable);

        
        return tasks.map(task -> modelMapper.map(task, TaskDto.class));
    }

    public TaskUpdateDto updateTask(long id, TaskUpdateDto taskUpdateDto) {
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhuma task com o id: " + id + " foi encontrada.")); 

        taskUpdateDto.getTitulo().ifPresent(existingTask::setTitulo);
        taskUpdateDto.getDescricao().ifPresent(existingTask::setDescricao);
        taskUpdateDto.getCategoria().ifPresent(existingTask::setCategoria);
        taskUpdateDto.getDataLimite().ifPresent(existingTask::setDataLimite);
        
        Task savedTask = taskRepository.save(existingTask);
        return modelMapper.map(savedTask, TaskUpdateDto.class);
    }

    public void deleteTask(long id) {
        if(!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Nenhuma task com o id: " + id + " foi encontrada."); 
        }
        taskRepository.deleteById(id);
    }

    public Page<TaskDto> getTaskByCategoria(String categoria) {
        Page<Task> tasks = taskRepository.findByCategoria(categoria, Pageable.unpaged());
        return tasks.map(task -> modelMapper.map(task, TaskDto.class));
    }

}
