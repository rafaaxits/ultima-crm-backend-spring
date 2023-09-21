package ultima.com.backend.crm.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Cliente> getClientById(@PathVariable int id){
        return ResponseEntity.ok(clienteService.findClientById(id));
    }

    @GetMapping("/getAllClients")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok(clienteService.getAllClientes().get());
    }

    @PostMapping("/addClient")
    public ResponseEntity<String> addCliente(@RequestBody @Valid ClienteDTO cliente){
        clienteService.addCliente(cliente);
        return ResponseEntity.ok("Cliente adicionado com sucesso");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }
}
