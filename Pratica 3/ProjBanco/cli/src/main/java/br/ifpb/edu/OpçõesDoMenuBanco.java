package br.ifpb.edu;

public enum OpçõesDoMenuBanco {
    ALTERAR_NOME_DO_BANCO("Alterar Nome do Banco"),
    EXIBIR_DADOS_BANCO("Exibir Dados do Banco"),
    EXIBIR_DADOS_CONTA("Exibir Dados de uma Conta"),
    EXIBIR_CONTAS_CADASTRADAS("Exibir Contas Cadastradas"),
    CADASTRAR_CONTA_CORRENTE("Cadastrar Nova Conta Corrente"),
    EDITAR_CONTA_CORRENTE("Editar Conta Existente"),
    SAIR("SAIR");

    private final String nomeOpção;

    OpçõesDoMenuBanco(String nomeOpção) {
        this.nomeOpção = nomeOpção;
    }

    @Override
    public String toString() {
        return nomeOpção;
    }
}
