package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.domain.consulta.*;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    private final AgendaDeConsultas agendaDeConsultas;
    private final CancelamentoDeConsultas cancelamentoDeConsultas;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        var dto = agendaDeConsultas.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/cancelar")
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        cancelamentoDeConsultas.cancelar(dados);
        return ResponseEntity.ok(dados);
    }
}
