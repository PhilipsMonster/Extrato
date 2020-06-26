package extratolacamento.controller;

import extratolacamento.domain.ExtratoView;
import extratolacamento.service.ExtratoService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ExtratoController {

    @Autowired
    private ExtratoService service;

    @GetMapping(value = "/extrato", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<ExtratoView>> get() throws IOException, ParseException {
        //return ResponseEntity.ok(service.getExtrato());
        List<ExtratoView> extratos = service.getExtrato();

        return extratos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(extratos);

    }
}
