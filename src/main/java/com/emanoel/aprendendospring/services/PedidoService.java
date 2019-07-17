package com.emanoel.aprendendospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanoel.aprendendospring.domain.Cliente;
import com.emanoel.aprendendospring.domain.Pedido;
import com.emanoel.aprendendospring.repositories.ClienteRepository;
import com.emanoel.aprendendospring.repositories.ItemPedidoRepository;
import com.emanoel.aprendendospring.repositories.PedidoRepository;
import com.emanoel.aprendendospring.services.Exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired //usar sem precisar instanciar
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+Pedido.class.getName()));
		
	}
}
