package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import constants.NumercialConstants;
import utils.Formatters;

public class EmployeesList {
    private List<Employee> employeesList = new ArrayList<Employee>();

    public void removeEmployee(int index) {
        employeesList.remove(index);
    }

    public void addAll(List<Employee> list) {
        employeesList.addAll(list);
    }

    public void showEmployees() {
        showEmployeesFromAList(employeesList);
        System.out.println("\n");
    }

    private void showEmployeesFromAList(List<Employee> list) {
        for (Employee iterableEmployee : list)
            showSingleEmployee(iterableEmployee);
    }

    private void showSingleEmployee(Employee employee) {
        System.out.println(employee.getName() + " | " +
                Formatters.formatDate(employee.getBirthdate()) + " | " +
                Formatters.formatWage(employee.getWage()) + " | " +
                employee.getRole());
    }

    public void showMinimumWageQuantity() {
        for (Employee iterableEmployee : employeesList)
            showMinimumWageQuantityFromAEmployee(iterableEmployee);
    }

    private void showMinimumWageQuantityFromAEmployee(Employee employee) {
        float minimumWageQuantity = employee.getWage()
                .divide(NumercialConstants.MININUM_WAGE, 2, RoundingMode.HALF_UP).floatValue();

        System.out.println(employee.getName() + " | "
                + minimumWageQuantity
                + " salários mínimos");
    }

    public void showTotalWageSum() {
        BigDecimal totalWageSum = new BigDecimal(0.00);

        for (Employee iterableEmployee : employeesList)
            totalWageSum = totalWageSum.add(iterableEmployee.getWage());

        System.out.println(Formatters.formatWage(totalWageSum) + "\n");
    }

    public void showOldestEmployee() {
        Employee oldestEmployee = null;
        int biggerAge = 0;

        for (Employee iterableEmployee : employeesList)
            if (iterableEmployee.getAgeInYears() > biggerAge) {
                biggerAge = iterableEmployee.getAgeInYears();

                oldestEmployee = iterableEmployee;
            }

        System.out.println(oldestEmployee.getName() + " | "
                + oldestEmployee.getAgeInYears() + " anos\n");
    }

    public void showEmployeesInAlphabeticOrder() {
        List<Employee> auxiliarList = employeesList;
        Collections.sort(auxiliarList, Comparator.comparing(Employee::getName));

        showEmployeesFromAList(auxiliarList);

        System.out.println("\n");
    }

    private Map<String, List<Employee>> groupEmployeesByRole() {
        return employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getRole));
    }

     // STEP 3.5
    public void showEmployeesGroupedByRole() {
        Map<String, List<Employee>> groupedEmployees = groupEmployeesByRole();

        for (Map.Entry<String, List<Employee>> entry : groupedEmployees.entrySet()) {
            System.out.println("FUNÇÃO: " + entry.getKey().toUpperCase());
            showEmployeesFromAList(entry.getValue());
            System.out.println("\n");
        }
    }

    // updateRate should be a decimal value. Ex.: 0.1 represents 10%
    public void updateWages(double updateRate) {
        for (Employee iterableEmployee : employeesList)
            iterableEmployee.setWage(iterableEmployee.getWage().multiply(new BigDecimal(1 + updateRate)));
    }

    public void showEmployeesThatBornInACertainMonth(int month) {
        if (month < 1 || month > 12)
            throw new Error("Month must be a value between 1 and 12.");

        var birthdayPeople = new ArrayList<Employee>(0);

        for (Employee iterableEmployee : employeesList)
            if (iterableEmployee.getBirthdate().getMonthValue() == month)
                birthdayPeople.add(iterableEmployee);

        if (birthdayPeople.size() > 0) {
            System.out.println("Funcionários aniversariantes do mês " + month + ":\n");
            showEmployeesFromAList(birthdayPeople);
        } else
            System.out.println("\nNão há funcionários aniversariantes do mês " + month + ".\n");
    }
}
