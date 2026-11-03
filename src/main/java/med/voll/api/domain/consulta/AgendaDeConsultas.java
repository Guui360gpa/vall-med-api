package med.voll.api.domain.consulta;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.validacoes.IValidacaoAgendamentoConsulta;
import med.voll.api.domain.consulta.validacoes.ValidacaoConsultaException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AgendaDeConsultas {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final List<IValidacaoAgendamentoConsulta> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {

        var paciente = pacienteRepository.findById(dados.idPaciente())
                .orElseThrow(() -> new ValidacaoConsultaException("Paciente não encontrado"));
        var medico = dados.idMedico() != null ?
                medicoRepository.findById(dados.idMedico())
                        .orElseThrow(() -> new ValidacaoConsultaException("Médico não encontrado"))
                : escolherMedico(dados);

        if (medico == null) {
            throw new ValidacaoConsultaException("Não existe médico disponível nessa data");
        }

        validadores.forEach(v -> v.validar(dados));

        var consulta = new Consulta(medico,paciente,dados.data());

        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.especialidade() == null) {
            throw new NoSuchElementException("Campo obrigatório se campo médico vazio");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(),dados.data());
    }
}
