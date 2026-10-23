package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "Campo obrigátorio") String logradouro,
        @NotBlank(message = "Campo obrigátorio") String bairro,
        @NotBlank(message = "Campo obrigátorio") @Pattern(regexp = "^\\d{8}") String cep,
        @NotBlank(message = "Campo obrigátorio") String cidade,
        @NotBlank(message = "Campo obrigátorio") String uf,
        String complemento,
        String numero
) {
}
