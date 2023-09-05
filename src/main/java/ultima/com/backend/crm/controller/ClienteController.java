package ultima.com.backend.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ultima.com.backend.crm.model.Cliente;
import ultima.com.backend.crm.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/getClient/{id}")
    public ResponseEntity<Optional<Cliente>> getClientById(@PathVariable int id){
        System.out.println("Getting client with id: " + id);
        Optional<Cliente> clienteOptional = clienteService.findClientById(id);
        System.out.println("Getting client: " + clienteOptional.get());
        return ResponseEntity.ok(clienteOptional);
    }

    @GetMapping("/getAllClients")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok(clienteService.getAllClientes().get());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }
}
