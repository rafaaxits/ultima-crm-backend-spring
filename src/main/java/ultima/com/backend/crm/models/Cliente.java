package ultima.com.backend.crm.models;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nomecompleto")
    private String nomeCompleto;
    @Column(name = "primeironome")
    private String primeiroNome;
    @Column(name = "nomesdomeio")
    private String nomesDoMeio;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "datadenascimento")
    private String dataDeNascimento;
    @Column(name = "idadeatual")
    private int idadeAtual;
    @Column(name = "genero")
    private char genero;
    @Column(name = "email")
    private String email;
    @Column(name = "telefone")
    private String telefone;

    private String tratamentoGenereo() {
        if(getGenero() == 'M') {
            return "Sr.";
        } else if(getGenero() == 'F') {
            return "Sra.";
        } else {
            return "";
        }
    }

    @Override
    public String toString() {
        return tratamentoGenereo() + " " + getNomeCompleto() + ", com CPF " +
                getCpf() + ", data de nascimento " + getDataDeNascimento() +
                " com idade de " + getIdadeAtual() + ", e-mail " + getEmail() +
                " e telefone " + getTelefone();
    }
}
