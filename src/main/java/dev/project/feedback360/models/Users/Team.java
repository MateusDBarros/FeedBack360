package dev.project.feedback360.models.Users;

public enum Team {
    DEV ("Desenvolvedores"),
    COR ("Gerencia"),
    VEN ("Vendas"),
    RH ("Recursos Humanos");

    private String description;

    Team(String description) {
        this.description = description;
    }

}
