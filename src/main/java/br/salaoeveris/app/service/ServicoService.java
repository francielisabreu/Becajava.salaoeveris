package br.salaoeveris.app.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import br.salaoeveris.app.repository.ClienteRepository;
import br.salaoeveris.app.repository.ServicoRepository;

@Service
public class ServicoService {

	final ServicoRepository _repository;
	final ClienteRepository _clienteRepository;

	public ServicoService(ServicoRepository repository, ClienteRepository clienteRepository) {
		_repository = repository;
		_clienteRepository = clienteRepository;

	}

}
