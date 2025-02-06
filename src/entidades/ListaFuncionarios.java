package entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import constantes.ConstantesNumericas;
import utils.Formatadores;

public class ListaFuncionarios {
    private List<Funcionario> listaDeFuncionarios = new ArrayList<Funcionario>();

    public void removerFuncionario(int index) {
        listaDeFuncionarios.remove(index);
    }

    public void adicionarTodos(List<Funcionario> listaFuncionarios) {
        listaDeFuncionarios.addAll(listaFuncionarios);
    }

    public void exibirFuncionarios() {
        exibirFuncionariosDeUmaLista(listaDeFuncionarios);
        System.out.println("\n");
    }

    private void exibirFuncionariosDeUmaLista(List<Funcionario> lista) {
        for (Funcionario funcionario : lista)
            exibirFuncionarioUnico(funcionario);
    }

    private void exibirFuncionarioUnico(Funcionario funcionario) {
        System.out.println(funcionario.getNome() + " | " +
                Formatadores.formatarData(funcionario.getDataNascimento()) + " | " +
                Formatadores.formatarSalario(funcionario.getSalario()) + " | " +
                funcionario.getFuncao());
    }

    public void exibirQuantidadeSalariosMinimos() {
        for (Funcionario funcionario : listaDeFuncionarios)
            exibirQuantidadeSalariosMinimosFuncionario(funcionario);
    }

    private void exibirQuantidadeSalariosMinimosFuncionario(Funcionario funcionario) {
        float quantidadeSalariosMinimos = funcionario.getSalario()
                .divide(ConstantesNumericas.SALARIO_MINIMO, 2, RoundingMode.HALF_UP).floatValue();

        System.out.println(funcionario.getNome() + " | "
                + quantidadeSalariosMinimos
                + " salários mínimos");
    }

    public void exibirSomatorioSalarios() {
        BigDecimal totalSalarios = new BigDecimal(0.00);

        for (Funcionario funcionario : listaDeFuncionarios)
            totalSalarios = totalSalarios.add(funcionario.getSalario());

        System.out.println("\nSOMATÓRIO DE SALÁRIOS: " + Formatadores.formatarSalario(totalSalarios));
    }

    public void exibirFuncionarioMaisVelho() {
        Funcionario funcionarioComMaiorIdade = null;
        int maiorIdade = 0;

        for (Funcionario funcionario : listaDeFuncionarios)
            if (funcionario.getIdadeEmAnos() > maiorIdade) {
                maiorIdade = funcionario.getIdadeEmAnos();
                funcionarioComMaiorIdade = funcionario;
            }

        System.out.println("\nFUNCIONÁRIO MAIS VELHO: " + funcionarioComMaiorIdade.getNome() + " | "
                + funcionarioComMaiorIdade.getIdadeEmAnos() + " anos\n");
    }

    public void exibirFuncionariosEmOrdemAlfabetica() {
        List<Funcionario> listaDeFuncionariosAuxiliar = listaDeFuncionarios;
        Collections.sort(listaDeFuncionariosAuxiliar, Comparator.comparing(Funcionario::getNome));

        exibirFuncionariosDeUmaLista(listaDeFuncionariosAuxiliar);

        System.out.println("\n");
    }

    // A taxa deve ser um valor decimal onde, por exemplo, 0.1 representa um aumento
    // de 10%
    public void atualizarSalarios(double taxaAtualizacao) {
        for (Funcionario funcionario : listaDeFuncionarios)
            funcionario.setSalario(funcionario.getSalario().multiply(new BigDecimal(1 + taxaAtualizacao)));
    }

    public void exibirFuncionariosQueNasceramEmDeterminadoMes(int mes) {
        if (mes < 1 || mes > 12)
            throw new Error("O mês deve ser um valor entre 1 e 12");

        var aniversariantes = new ArrayList<Funcionario>(0);

        for (Funcionario funcionario : listaDeFuncionarios)
            if (funcionario.getDataNascimento().getMonthValue() == mes)
                aniversariantes.add(funcionario);

        if (aniversariantes.size() > 0) {
            System.out.println("Funcionários aniversariantes do mês " + mes + ":\n");
            exibirFuncionariosDeUmaLista(aniversariantes);
        } else
            System.out.println("\nNão há funcionários aniversariantes do mês " + mes + ".\n");
    }
}
