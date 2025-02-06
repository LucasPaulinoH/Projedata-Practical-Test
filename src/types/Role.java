package types;

public enum Role {
    OPERATOR("Operador"),
    COORDINATOR("Coordenador"),
    DIRECTOR("Diretor"),
    RECEPCIONIST("Recepcionista"),
    ACCOUNTANT("Contador"),
    MANAGER("Gerente"),
    ELECTRICIAN("Eletricista");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
