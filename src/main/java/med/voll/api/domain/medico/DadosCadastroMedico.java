package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank(message = "Campo obrigátorio") String nome,
        @NotBlank(message = "Campo obrigátorio") @Email String email,
        @NotBlank(message = "Campo obrigátorio") String telefone,
        @NotBlank(message = "Campo obrigátorio") @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull(message = "Campo obrigátorio") Especialidade especialidade,
        @NotNull(message = "Campo obrigátorio") @Valid DadosEndereco endereco
) {
}
