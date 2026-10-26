package med.voll.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank(message = "Campo obrigatório") String login,
        @NotBlank(message = "Campo obrigatório") String senha
) {
}
