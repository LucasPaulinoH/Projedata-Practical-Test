package entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import tipos.Funcao;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, double salario, Funcao funcao) {
        super(nome, dataNascimento);
        this.salario = new BigDecimal(salario);
        this.funcao = funcao.getFuncao();
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
