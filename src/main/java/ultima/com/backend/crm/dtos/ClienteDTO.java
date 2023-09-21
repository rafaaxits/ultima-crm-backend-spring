package ultima.com.backend.crm.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import ultima.com.backend.crm.dtos.validations.Cpf;

@Data
public class ClienteDTO {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String primeiroNome;
    @NotBlank
    private String nomesDoMeio;
    @NotBlank
    private String sobrenome;
    @Cpf
    private String cpf;
    @NotBlank
    private String dataDeNascimento;
    private int idadeAtual;
    private char genero;
    @Email
    private String email;
    private String telefone;
}
