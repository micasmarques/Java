package br.com.micael.banco;

import br.com.guilherme.conta.contacorrente.ContaCorrente;

// JUnit
import org.junit.Test;

// Hamcrest

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BancoTest
{
    // Contas para teste
    static final ContaCorrente contaCorrenteUm = new ContaCorrente("Conta Um", "12345678910", "123", 1500);
    static final ContaCorrente contaCorrenteDois = new ContaCorrente("Conta Dois", "12345678915", "123", 800);
    static final ContaCorrente contaCorrenteTrês = new ContaCorrente("Conta Tres", "12345678920", "123", 300);

    // Conta Clone
    static final ContaCorrente cloneContaCorrenteTrês = new ContaCorrente("Conta Tres", "12345678920", "123", 300);

    // Banco de teste
    private Banco banco = new Banco();

    @Test
    public void testDeveAdicionarContaCorrente() {
        // Dado que... (foram adicionadas 2 contas)
        banco.adicionaConta( contaCorrenteUm );
        banco.adicionaConta( contaCorrenteDois );

        // então... (certifique-se de que a lista de contas do banco contém as duas contas adicionadas)
        assertThat( banco.getListaDeContasCorrente(), containsInAnyOrder( contaCorrenteUm, contaCorrenteDois) );
        assertThat( banco.quantidadeDeContas(), equalTo( 2 ));
    }

    @Test
    public void testNaoDeveAdicionarContaCorrenteIgual() {
        // Dado que... (foram adicionadas 2 contas e 1 conta "clone")
        banco.adicionaConta( contaCorrenteDois );
        banco.adicionaConta( contaCorrenteTrês );
        banco.adicionaConta( cloneContaCorrenteTrês );


        // então... (certifique-se de que o clone NÃO foi adicionado, apenas os dois "originais" )
        assertThat( banco.getListaDeContasCorrente(), not( containsInAnyOrder( cloneContaCorrenteTrês )));
        assertThat( banco.quantidadeDeContas(), equalTo( 2 ));
    }

    @Test
    public void testDeveRemoverContaCorrente() {
        // Dado que... (existam 3 contas)
        banco.adicionaConta( contaCorrenteUm );
        banco.adicionaConta( contaCorrenteDois );
        banco.adicionaConta( contaCorrenteTrês );

        // quando... (remover uma conta)
        banco.removeConta( contaCorrenteDois.getNúmero() );

        // então... (certifique-se de que a lista de contas do banco não contém mais a conta removida)
        assertThat( banco.getListaDeContasCorrente(), not( containsInAnyOrder( contaCorrenteDois ) ) );
    }
}