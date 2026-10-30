package med.voll.api.domain.consulta;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendaDeConsultas {

    private final ConsultaRepository consultaRepository;

    public void agendar(DadosAgendamentoConsulta dados) {

    }
}
