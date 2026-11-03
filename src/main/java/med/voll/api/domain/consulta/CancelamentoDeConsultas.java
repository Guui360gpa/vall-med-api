package med.voll.api.domain.consulta;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.validacoes.cancelamento.IValidacaoConcelamentoConsulta;
import med.voll.api.domain.consulta.validacoes.ValidacaoConsultaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CancelamentoDeConsultas {

    private final ConsultaRepository consultaRepository;
    private final List<IValidacaoConcelamentoConsulta> validadores;

    public void cancelar(DadosCancelamentoConsulta dados) {

        if (!consultaRepository.existsById(dados.idConsulta())){
            throw new ValidacaoConsultaException("Essa consulta não existe");
        }

        validadores.forEach(v -> v.validar(dados));

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.setAtiva(false);
        consulta.setMotivo(dados.motivo());
    }
}
