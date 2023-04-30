package entidades;

public class ContaTransferencia extends ContaCorrente {

    public ContaTransferencia(String usuario, int numeroConta, String senha) {
        super(usuario, numeroConta, senha);
    }

    public void TransferenciaTed(Double valorTranfer, int contaTransferidaTed) {
        if (getSaldo() < valorTranfer) {
            System.out.println("Digite um valor valido para continuar a transferência");
            System.out.println("Seu saldo é de: "+ getSaldo());
        } else if (valorTranfer <= 0.0) {
            System.out.println("Digite um valor valido");
        }else {
            setSaldo(getSaldo() - valorTranfer);
            System.out.println("Valor de : R$" + valorTranfer + " enviado para: " + contaTransferidaTed +
                    "\n O valor será enviado em até 24H");
        }
    }

    public void TranferenciaPix(Double valorTranfer, String contaTransferidaPix) {
        if (getSaldo() < valorTranfer) {
            System.out.println("Valor maior que o saldo, digite um valor menor ou igual");
        } else if (valorTranfer <= 0.0) {
            System.out.println("Digite um valor valido");

        } else {
            setSaldo(getSaldo() - valorTranfer);
            System.out.println("Valor de : R$" + valorTranfer + " enviado para: " + contaTransferidaPix +
                    "\n Agradecemos :)");

        }
    }
}
