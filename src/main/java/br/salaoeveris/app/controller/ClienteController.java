package br.salaoeveris.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;
import br.salaoeveris.app.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService _service;

	@PostMapping()
	public ResponseEntity incluir (@RequestBody ClienteRequest request) {

		try {
			BaseResponse response = _service.incluir(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro inesperado");
		}
	}
	
	
	@GetMapping(path = "/{id}")
	
	public ResponseEntity obter (@PathVariable Long id) {
		
		ClienteResponse response = _service.obter(id);
	    return ResponseEntity.status(response.statusCode).body(response);
	}
}
