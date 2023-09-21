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
    public ClienteDTO findClientById(int id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isEmpty()) {
            throw new ResourceNotFoundException("Cliente não existe");
        }
        ModelMapper mapper = new ModelMapper();
        ClienteDTO clienteDTO = mapper.map(clienteOptional.get(), ClienteDTO.class);
        return clienteDTO;
    }

    public Optional<List<Cliente>> getAllClientes (){
        return Optional.of(clienteRepository.findAll());
    }

    public void addCliente(ClienteDTO clienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteRepository.save(cliente);
    }
}
