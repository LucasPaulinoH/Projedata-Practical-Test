import java.time.LocalDate;
import java.util.Arrays;

import entities.Employee;
import entities.EmployeesList;
import types.Role;
import utils.StringUtils;

// STEP 3
public class Main {
    public static void main(String[] args) throws Exception {
        var employeesList = new EmployeesList();

        // STEP 3.1
        employeesList
                .addAll(Arrays.asList(
                        new Employee("Maria", LocalDate.parse("2000-10-18"), 2009.44, Role.OPERATOR),
                        new Employee("João", LocalDate.parse("1990-05-12"), 2284.38, Role.OPERATOR),
                        new Employee("Caio", LocalDate.parse("1961-05-02"), 9836.14, Role.COORDINATOR),
                        new Employee("Miguel", LocalDate.parse("1988-10-14"), 19119.88, Role.DIRECTOR),
                        new Employee("Alice", LocalDate.parse("1995-01-05"), 2234.68, Role.RECEPCIONIST),
                        new Employee("Heitor", LocalDate.parse("1999-11-19"), 1582.72, Role.OPERATOR),
                        new Employee("Arthur", LocalDate.parse("1993-03-31"), 4071.84, Role.ACCOUNTANT),
                        new Employee("Laura", LocalDate.parse("1994-07-08"), 3017.45, Role.MANAGER),
                        new Employee("Heloísa", LocalDate.parse("2003-05-24"), 1606.85, Role.ELECTRICIAN),
                        new Employee("Helena", LocalDate.parse("1996-09-02"), 2799.93, Role.MANAGER)));

        StringUtils.printHeader("TODOS OS FUNCIONÁRIOS");
        employeesList.showEmployees();

        // STEP 3.2
        employeesList.removeEmployee(1);

        // STEP 3.3
        StringUtils.printHeader("TODOS OS FUNCIONÁRIOS (SEM JOÃO)");
        employeesList.showEmployees();

        // STEP 3.4
        StringUtils.printHeader("AUMENTANDO SALÁRIO EM 10%");
        employeesList.updateWages(0.1);
        employeesList.showEmployees();

        // STEP 3.6
        StringUtils.printHeader("FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO");
        employeesList.showEmployeesGroupedByRole();

        // STEP 3.8 (3.7, IT'S INCORRECTLY WRITTEN IN THE QUESTION DESCRIPTION)
        StringUtils.printHeader("FUNCIONÁRIOS QUE FAZEM ANIVERSÁRIO EM OUTUBRO (10) E DEZEMBRO (12)");
        employeesList.showEmployeesThatBornInACertainMonth(10);
        employeesList.showEmployeesThatBornInACertainMonth(12);

        // STEP 3.9
        StringUtils.printHeader("\nFUNCIONÁRIO MAIS VELHO");
        employeesList.showOldestEmployee();

        // STEP 3.10
        StringUtils.printHeader("\nFUNCIONÁRIOS EM ORDEM ALFABÉTICA");
        employeesList.showEmployeesInAlphabeticOrder();

        // STEP 3.11
        StringUtils.printHeader("\nSOMATÓRIO DE SALÁRIOS");
        employeesList.showTotalWageSum();

        // STEP 3.12
        StringUtils.printHeader("\nQUANTOS SALÁRIOS MÍNIMOS CADA FUNCIONÁRIO GANHA");
        employeesList.showMinimumWageQuantity();

    }
}
