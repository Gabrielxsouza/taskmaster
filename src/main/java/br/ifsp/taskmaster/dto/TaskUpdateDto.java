package br.ifsp.taskmaster.dto;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateDto {
    private Optional<String> titulo = Optional.empty();
    private Optional<String> descricao = Optional.empty();
    private Optional<String> categoria = Optional.empty();
    private Optional<LocalDate> dataLimite = Optional.empty();
}
