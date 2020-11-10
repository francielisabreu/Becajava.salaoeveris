package br.salaoeveris.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.salaoeveris.app.service.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoController {

	final ServicoService _service;

	public ServicoController(ServicoService service) {
		_service = service;

	}
}