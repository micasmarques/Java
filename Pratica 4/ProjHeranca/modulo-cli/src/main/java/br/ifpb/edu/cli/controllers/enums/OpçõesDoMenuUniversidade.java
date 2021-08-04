package br.ifpb.edu.cli.controllers.enums;

public enum OpçõesDoMenuUniversidade {
    RENOMEAR_UNIVERSIDADE("Alterar Nome da Universidade"),
    DADOS_UNIVERSIDADE("Exibir Dados da Universidade"),
    CADASTRAR_FUNCIONARIO("Cadastrar Funcionário"),
    REMOVER_FUNCIONARIO("Remover Funcionário"),
    LISTAR_FUNCIONARIOS("Listar Todos os Funcionários"),
    EDITAR_FUNCIONARIO("Editar Funcionário"),
    EXIBIR_FUNCIONARIO("Exibir Dados de um Funcionário"),
    SAIR("SAIR");

    private final String opçãoNome;

    OpçõesDoMenuUniversidade(String opçãoNome) {
        this.opçãoNome = opçãoNome;
    }

    @Override
    public String toString() {
        return opçãoNome;
    }
}
