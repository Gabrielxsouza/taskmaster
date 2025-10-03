package br.ifsp.taskmaster.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateDto {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 2, message = "O título deve ter no mínimo 2 caracteres")
    String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 10, message = "A descrição deve ter no mínimo 10 caracteres")
    String descricao;

    @NotBlank(message = "A categoria é obrigatória")
    String categoria;

    @FutureOrPresent(message = "A data limite não pode estar no passado.")
    @NotNull(message = "A data limite é obrigatória")
    LocalDate dataLimite;

}
