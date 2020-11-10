package br.salaoeveris.app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.repository.ClienteRepository;
import br.salaoeveris.app.repository.ServicoRepository;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;

@Service
public class ClienteService {

	final ClienteRepository _repository;
	final ServicoRepository _servicoRepository;

	public ClienteService(ClienteRepository repository, ServicoRepository servicorepository) {
		_repository = repository;
		_servicoRepository = servicorepository;

	}
	//inserir cliente
	public ClienteResponse inserir(ClienteRequest clienteRequest) {
		   Cliente cliente = new Cliente();
	       ClienteResponse clienteResponse = new ClienteResponse();
		   clienteResponse.statusCode = 404;
		

		if (clienteRequest.getNome().isEmpty()) {			
			clienteResponse.message = "O Nome do cliente não foi preenchido.";
			return clienteResponse;
		}

		clienteResponse.setNome(clienteRequest.getNome());

		_repository.save(cliente);

		clienteResponse.statusCode = 201;
		clienteResponse.setNome(cliente.getNome());
		clienteResponse.setId(cliente.getId());

		return clienteResponse;
	}
	
	
	//obter por id
	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = _repository.findById(id);

		ClienteResponse response = new ClienteResponse();
		if (cliente.isEmpty()) {
			response.statusCode = 400;
			response.message = "Id não encontrado.";
			return response;
		}

		response.setNome(cliente.get().getNome());
		response.setId(cliente.get().getId());
		response.statusCode = 200;
		response.message = "Cliente obtido com sucesso.";
		return response;
	}
}
