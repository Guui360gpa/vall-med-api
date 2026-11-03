package med.voll.api.domain.consulta.validacoes.cancelamento;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api.domain.consulta.validacoes.ValidacaoConsultaException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ValidadorCancelamentoMinimo implements IValidacaoConcelamentoConsulta{

    private final ConsultaRepository consultaRepository;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora,consulta.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoConsultaException("Consulta somente pode ser cancelada com antecedência de 24 horas");
        }
    }
}
