package ultima.com.backend.crm.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ultima.com.backend.crm.dtos.ClienteDTO;
import ultima.com.backend.crm.exceptions.ResourceNotFoundException;
import ultima.com.backend.crm.models.Cliente;
import ultima.com.backend.crm.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente findClientById(int id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isEmpty()) {
            throw new ResourceNotFoundException("Client do not exist");
        }
        return clienteOptional.get();
    }

    public Optional<List<Cliente>> getAllClientes (){
        return Optional.of(clienteRepository.findAll());
    }

    public void addCliente(ClienteDTO cliente) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente clienteEntity = modelMapper.map(cliente, Cliente.class);
        this.clienteRepository.save(clienteEntity);
    }
}
