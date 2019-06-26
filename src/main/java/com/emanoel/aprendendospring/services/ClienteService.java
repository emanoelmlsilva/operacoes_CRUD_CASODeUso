package com.emanoel.aprendendospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanoel.aprendendospring.domain.Cliente;
import com.emanoel.aprendendospring.repositories.ClienteRepository;
import com.emanoel.aprendendospring.services.Exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired //usar sem precisar instanciar
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+Cliente.class.getName()));
		
	}
}
