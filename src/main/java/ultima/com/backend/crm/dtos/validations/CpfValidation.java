package ultima.com.backend.crm.dtos.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidation implements ConstraintValidator<Cpf, String> {

    private final int[] PESO_CPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        String cpfSomentDigitos = cpf.replaceAll("\\D", "");
        if((cpfSomentDigitos==null) || (cpfSomentDigitos.length() != 11) || cpfSomentDigitos.equals("00000000000")
                || cpfSomentDigitos.equals("11111111111") || cpfSomentDigitos.equals("22222222222")
                || cpfSomentDigitos.equals("33333333333") || cpfSomentDigitos.equals("44444444444")
                || cpfSomentDigitos.equals("55555555555") || cpfSomentDigitos.equals("66666666666")
                || cpfSomentDigitos.equals("77777777777") || cpfSomentDigitos.equals("88888888888")
                || cpfSomentDigitos.equals("99999999999")) {
            return false;
        }
        Integer digito1 = calcularDigito(cpfSomentDigitos.substring(0,9), PESO_CPF);
        Integer digito2 = calcularDigito(cpfSomentDigitos.substring(0,9) + digito1, PESO_CPF);

        return cpfSomentDigitos.equals(cpfSomentDigitos.substring(0,9) + digito1.toString() + digito2.toString());
    }

    private int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() -1, digito; indice >= 0; indice--){
            digito = Integer.parseInt(str.substring(indice, indice+1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }
}
