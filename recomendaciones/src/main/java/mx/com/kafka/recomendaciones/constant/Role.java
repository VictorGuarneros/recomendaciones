package mx.com.kafka.recomendaciones.constant;

public enum Role {
    ADMINISTRATOR("ADMINISTRATOR"), CLIENT("CLIENT");

    private final String roleValue;

    Role(String role) {
        roleValue = role;
    }

    @Override
    public String toString() {
        return roleValue;
    }
}
