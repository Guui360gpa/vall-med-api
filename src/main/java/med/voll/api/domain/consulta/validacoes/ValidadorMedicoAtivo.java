package med.voll.api.domain.consulta.validacoes;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;

@RequiredArgsConstructor
public class ValidadorMedicoAtivo {

    private final MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoConsultaException("Consulta não pode ser agendada com médico excluído");
        }
    }
}
