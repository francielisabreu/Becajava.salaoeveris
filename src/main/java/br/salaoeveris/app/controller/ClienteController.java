package br.salaoeveris.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.salaoeveris.app.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	final ClienteService _service;

	public ClienteController(ClienteService service) {

		_service = service;
	}

	
}
