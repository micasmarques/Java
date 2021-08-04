package br.com.micael.conta;

import br.com.micael.conta.exceptions.*;

// Apache Utils | Funções úteis
import org.apache.commons.lang3.*;

// Java Utils
import java.util.*;

public abstract class Conta {
    protected Locale local = new Locale("pt", "BR");

    private int número;
    private Date dataDeCadastro;

    protected static final String TITULAR_SEM_NOME = "---Sem Nome---";
    protected static final String TITULAR_SEM_CPF = "---Sem CPF---";
    protected static final String SENHA_DEFAULT = "123456";
    protected static final double SALDO_INICIAL_DEFAULT = 10;

    private String titular;
    private String CPF;
    private String senha;
    private double saldo;

    public int getNúmero() {
        return número;
    }

    protected void setNúmero(int número) {
        this.número = número;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    protected void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (StringUtils.isNotBlank(titular)) {
            this.titular = titular;
        }
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        if (!CPF.equals(TITULAR_SEM_CPF)) {
            String CPFTemp = Objects.requireNonNullElse(StringUtils.defaultIfBlank(CPF, TITULAR_SEM_CPF), TITULAR_SEM_CPF);
            if (CPFValido(CPFTemp)) {
                this.CPF =  CPFTemp.substring(0, 3) + "." +
                        CPFTemp.substring(3, 6) + "." +
                        CPFTemp.substring(6, 9) + "-" +
                        CPFTemp.substring(9, 11);
            } else {
                throw new CPFInvalidoException();
            }
        } else {
            this.CPF = CPF;
        }
    }

    private boolean CPFValido(String CPF) {
        return (CPF.length() == 11) && (CPF.replaceAll(String.valueOf(CPF.charAt(0)), "").length() > 0);
    }

    public String getSenha() {
        return senha;
    }

    protected void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            throw new QuantiaNegativaException();
        }
    }

}
