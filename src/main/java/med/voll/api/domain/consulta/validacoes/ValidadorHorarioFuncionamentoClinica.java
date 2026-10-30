package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamentoClinica {
    
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        boolean isDomingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        boolean depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (isDomingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
            throw new ValidacaoConsultaException("Consulta fora do horário de funcionamento da clínica");
        }
    } 
}
