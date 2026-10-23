package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroPaciente(
        @NotBlank(message = "Campo obrigatório") String nome,
        @NotBlank(message = "Campo obrigatório") @Email String email,
        @NotBlank(message = "Campo obrigatório") String telefone,
        @NotBlank(message = "Campo obrigatório") @CPF String cpf,
        @NotNull(message = "Campo obrigatório") @Valid DadosEndereco endereco
) {
}
