import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {
    private String ra;
    private String nome;
    private Date nascimento;
    private String cpf;
    private ValidacaoCPFStrategy validacaoCPFStrategy; // Estratégia para validação de CPF

    public Aluno(String ra, String nome, Date nascimento, String cpf, ValidacaoCPFStrategy validacaoCPFStrategy) {
        this.ra = ra;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.validacaoCPFStrategy = validacaoCPFStrategy; // Define a estratégia de validação
    }

    // Método que valida o CPF utilizando a estratégia escolhida
    public boolean validarCPF() {
        return validacaoCPFStrategy.validar(this.cpf);
    }

    // Getters e Setters
    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ValidacaoCPFStrategy getValidacaoCPFStrategy() {
        return validacaoCPFStrategy;
    }

    public void setValidacaoCPFStrategy(ValidacaoCPFStrategy validacaoCPFStrategy) {
        this.validacaoCPFStrategy = validacaoCPFStrategy;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Aluno{" +
                "RA='" + ra + '\'' +
                ", Nome='" + nome + '\'' +
                ", Nascimento=" + sdf.format(nascimento) +
                ", CPF='" + cpf + '\'' +
                '}';
    }
}
