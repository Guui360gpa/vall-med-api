package med.voll.api.domain.consulta;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AgendaDeConsultas {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {

        var paciente = pacienteRepository.findById(dados.idPaciente())
                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado"));
        var medico = dados.idMedico() != null ?
                medicoRepository.findById(dados.idMedico())
                        .orElseThrow(() -> new NoSuchElementException("Médico não encontrado"))
                : escolherMedico(dados);

        var consulta = new Consulta(medico,paciente,dados.data());


        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.especialidade() == null) {
            throw new NoSuchElementException("Campo obrigatório se campo médico vazio");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(),dados.data());
    }
}
