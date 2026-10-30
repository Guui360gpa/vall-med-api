package med.voll.api.domain.consulta.validacoes;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

@RequiredArgsConstructor
public class ValidadorPacienteAtivo {

    private final PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = pacienteRepository.findAtivoById(dados.idPaciente());

        if (!pacienteEstaAtivo){
            throw new ValidacaoConsultaException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
