package br.salaoeveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.salaoeveris.app.response.ClienteResponse;
import br.salaoeveris.app.service.ClienteService;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	final ClienteService _service;

	@Autowired
	public ClienteController(ClienteService service) {

		_service = service;
	}

	@PostMapping
	 public ResponseEntity inserir (@RequestBody ClienteRequest request) {
		
		try {
			ClienteResponse  response = _service.inserir(request);
			return ResponseEntity.status(response.statusCode).body(response);
	}  		catch (Exception e)  {
			return ResponseEntity.status(500).body("Erro genérico");
		
		}
	}
	
}

