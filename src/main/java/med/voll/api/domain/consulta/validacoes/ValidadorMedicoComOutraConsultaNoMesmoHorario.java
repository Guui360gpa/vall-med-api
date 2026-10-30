package med.voll.api.domain.consulta.validacoes;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

@RequiredArgsConstructor
public class ValidadorMedicoComOutraConsultaNoMesmoHorario {

    private final ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository.existsByMedicoIdAndData(dados.idMedico(),dados.data());

        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoConsultaException("Médico já possui outra consulta agendada no mesmo horário");
        }
    }
}
