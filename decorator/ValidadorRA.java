// Interface ValidadorRA
interface ValidadorRA {
    boolean validar(String ra);
}

// Classe BaseValidadorRA
class BaseValidadorRA implements ValidadorRA {
    @Override
    public boolean validar(String ra) {
        return ra != null; // Validação básica: Garantir que a string não seja nula
    }
}

// Classe Abstrata ValidadorRADecorador
abstract class ValidadorRADecorador implements ValidadorRA {
    protected ValidadorRA validadorEnvolvido;

    public ValidadorRADecorador(ValidadorRA validador) {
        this.validadorEnvolvido = validador;
    }

    @Override
    public boolean validar(String ra) {
        return validadorEnvolvido.validar(ra);
    }
}

// Decorador ValidadorComecaComA
class ValidadorComecaComA extends ValidadorRADecorador {
    public ValidadorComecaComA(ValidadorRA validador) {
        super(validador);
    }

    @Override
    public boolean validar(String ra) {
        return super.validar(ra) && ra.startsWith("a");
    }
}

// Decorador ValidadorTamanho
class ValidadorTamanho extends ValidadorRADecorador {
    public ValidadorTamanho(ValidadorRA validador) {
        super(validador);
    }

    @Override
    public boolean validar(String ra) {
        return super.validar(ra) && ra.length() == 8;
    }
}

// Classe Principal para Testar
public class Principal {
    public static void main(String[] args) {
        // String de entrada para validar
        String ra = "a1234567";

        // Criação do validador
        ValidadorRA validador = new ValidadorTamanho(new ValidadorComecaComA(new BaseValidadorRA()));

        // Validar o RA e exibir o resultado
        if (validador.validar(ra)) {
            System.out.println("RA é válido!");
        } else {
            System.out.println("RA é inválido.");
        }
    }
}
