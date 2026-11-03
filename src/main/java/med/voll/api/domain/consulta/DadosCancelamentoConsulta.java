package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull(message = "Campo obrigatório") Long idConsulta,
        @NotBlank(message = "Campo obrigatório") String motivo
) {
}
