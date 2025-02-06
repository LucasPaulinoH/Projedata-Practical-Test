import java.time.LocalDate;
import java.util.Arrays;

import entidades.Funcionario;
import entidades.ListaFuncionarios;
import tipos.Funcao;

public class App {
    public static void main(String[] args) throws Exception {
        var listaFuncionarios = new ListaFuncionarios();

        listaFuncionarios
                .adicionarTodos(Arrays.asList(
                        new Funcionario("Maria", LocalDate.parse("2000-10-18"), 2009.44, Funcao.OPERADOR),
                        new Funcionario("João", LocalDate.parse("1990-05-12"), 2284.38, Funcao.OPERADOR),
                        new Funcionario("Caio", LocalDate.parse("1961-05-02"), 9836.14, Funcao.COORDENADOR),
                        new Funcionario("Miguel", LocalDate.parse("1988-10-14"), 19119.88, Funcao.DIRETOR),
                        new Funcionario("Alice", LocalDate.parse("1995-01-05"), 2234.68, Funcao.RECEPCIONISTA),
                        new Funcionario("Heitor", LocalDate.parse("1999-11-19"), 1582.72, Funcao.OPERADOR),
                        new Funcionario("Arthur", LocalDate.parse("1993-03-31"), 4071.84, Funcao.CONTADOR),
                        new Funcionario("Laura", LocalDate.parse("1994-07-08"), 3017.45, Funcao.GERENTE),
                        new Funcionario("Heloísa", LocalDate.parse("2003-05-24"), 1606.85, Funcao.ELETRICISTA),
                        new Funcionario("Helena", LocalDate.parse("1996-09-02"), 2799.93, Funcao.GERENTE)));

        listaFuncionarios.exibirFuncionariosQueNasceramEmDeterminadoMes(10);
        listaFuncionarios.exibirFuncionariosQueNasceramEmDeterminadoMes(12);
    }
}
