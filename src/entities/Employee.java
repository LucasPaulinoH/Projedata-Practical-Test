package entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import types.Role;

// STEP 2
public class Employee extends Person {
    private BigDecimal wage;
    private String role;

    public Employee(String name, LocalDate birthdate, double wage, Role role) {
        super(name, birthdate);
        this.wage = new BigDecimal(wage);
        this.role = role.getRole();
    }

    public BigDecimal getWage() {
        return wage;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
