// TODO: Adicionar a transferencia para as classes investimento e Poupança
package entidades;

public class ContaCorrente {
    private Double saldo = 0.0;
    private int numeroConta;
    private String usuario;
    private String senha;

    //Construtor
    public ContaCorrente(String usuario, int numeroConta, String senha) {
        this.usuario = usuario;
        this.numeroConta = numeroConta;
        this.senha = senha;

    }

    // gets
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getUsuario() {
        return usuario;
    }

    // Metodos:
    public void Depositar(double valorDeposito) {
        saldo += valorDeposito;
    }

    public void Sacar(double valorSaque) {
        if (saldo < valorSaque) {
            System.out.println("O valor do Saque é maior que o valor disponivel em conta, Por favor digite um valor valido");
            System.out.println("O valor de Saldo é: " + getSaldo());
        } else {
            saldo -= valorSaque;
            System.out.println("O valor de " + valorSaque + " foi retirado.");
            System.out.println("O valor do seu Saldo corresponde a: " + getSaldo());
        }
    }
}
