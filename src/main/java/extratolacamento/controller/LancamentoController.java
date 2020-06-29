package extratolacamento.controller;

import extratolacamento.domain.LancamentoResumido;
import extratolacamento.service.ExtratoService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class LancamentoController {

    @Autowired
    private ExtratoService service;

    @GetMapping(value = "/v1/extratos/lancamentos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<LancamentoResumido>> get() throws IOException, ParseException {
        //return ResponseEntity.ok(service.getExtrato());
        List<LancamentoResumido> extratos = service.getLancamentos();

        return extratos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(extratos);

    }
}
