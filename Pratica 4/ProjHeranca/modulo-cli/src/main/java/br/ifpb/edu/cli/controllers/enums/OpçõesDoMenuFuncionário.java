package br.ifpb.edu.cli.controllers.enums;

public enum OpçõesDoMenuFuncionário {
    CADASTRAR_PROFESSOR("Cadastrar Professor"),
    CADASTRAR_GERENTE("Cadastrar Gerente"),
    VOLTAR("Voltar"),
    SAIR("SAIR");

    private final String opçãoNome;

    OpçõesDoMenuFuncionário(String opçãoNome) {
        this.opçãoNome = opçãoNome;
    }

    @Override
    public String toString() {
        return opçãoNome;
    }
}
