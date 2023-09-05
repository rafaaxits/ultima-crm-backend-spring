package ultima.com.backend.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ultima.com.backend.crm.model.Cliente;
import ultima.com.backend.crm.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    public Optional<Cliente> findClientById(int id) {
        return clienteRepository.findById(id);
    }

    public Optional<List<Cliente>> getAllClientes (){
        return Optional.of(clienteRepository.findAll());
    }
}
