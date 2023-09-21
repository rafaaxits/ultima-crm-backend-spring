package ultima.com.backend.crm.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ultima.com.backend.crm.dtos.ClienteDTO;
import ultima.com.backend.crm.models.Cliente;
import ultima.com.backend.crm.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/getClient/{id}")
    public ResponseEntity<ClienteDTO> getClientById(@PathVariable int id){
        return ResponseEntity.ok(clienteService.findClientById(id));
    }

    @GetMapping("/getAllClients")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok(clienteService.getAllClientes().get());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/addClient")
    public ResponseEntity<String> addCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        clienteService.addCliente(clienteDTO);
        return ResponseEntity.ok("Cliente foi criado com sucesso");
    }
}
