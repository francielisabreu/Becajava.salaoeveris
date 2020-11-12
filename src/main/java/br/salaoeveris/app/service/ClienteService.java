package br.salaoeveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.repository.ClienteRepository;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository _repository;

	public BaseResponse incluir(ClienteRequest request) {
		BaseResponse base = new BaseResponse();
		Cliente cliente = new Cliente();
		base.statusCode = 400;

		if (request.getNome() == null || request.getNome() == " ") {
			base.message = "O campo cpf precisa ser preenchido";
			return base;
		}

		if (request.getCpf() == null || request.getCpf() == " ") {
			base.message = "O campo cpf precisa ser preenchido";
			return base;
		}
		if (request.getEndereco() == null || request.getEndereco() == " ") {
			base.message = "O campo cpf precisa ser preenchido";
			return base;
		}
		if (request.getTelefone() == null || request.getTelefone() == " ") {
			base.message = "O campo cpf precisa ser preenchido";
			return base;
		}

		cliente.setNome(request.getNome());
		cliente.setCpf(request.getCpf());
		cliente.setTelefone(request.getTelefone());
		cliente.setEndereco(request.getEndereco());
		_repository.save(cliente);

		base.statusCode = 201;
		base.message = "Cliente incluido com sucesso";
		return base;

	}

	public ClienteResponse obter(Long id) {

		ClienteResponse response = new ClienteResponse();

		Optional<Cliente> cliente = _repository.findById(id);

		if (cliente.isEmpty()) {

			response.statusCode = 400;
			response.message = "cliente não foi encontrado";
			return response;
		}

		response.setNome(cliente.get().getNome());
		response.setId(cliente.get().getId());
		response.setEndereco(cliente.get().getEndereco());
		response.setTelefone(cliente.get().getTelefone());
		response.statusCode = 200;
		response.message = "cliente obtido!";

		return response;

	}
}
