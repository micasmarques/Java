class EntradaInvalidaException extends RuntimeException {
    public EntradaInvalidaException() {
        this("Entrada Inválida");
    }

    public EntradaInvalidaException(String msg) {
        super(msg);
    }
}

public class Somador {
    public static void main(String[] args) {

        int total = 0, numero;

        for (String arg : args) {
            try {
                numero = Integer.parseInt(arg);
                if (numero < 0) {
                    throw new EntradaInvalidaException();
                }
                total += numero;
            } catch (NumberFormatException nfe) {
                System.out.println("Erro: A entrada " + arg + " e invalida. Sera desprezada.");
            } catch (EntradaInvalidaException eia) {
                System.out.println("Erro: A entrada " + arg + " e invalida. Sera desprezada.");
            }
        }

        System.out.println("O resultado da soma: " + total);
    }
}

// javac Somador.java
// java Somador 45 10 2 20
// java Somador 45 -10 2 Maria 20