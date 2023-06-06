package entidades;

public class ContaTransferencia {
    private ContaCorrente conta;

    public ContaTransferencia(ContaCorrente conta) {
        this.conta = conta;
    }

    public void transferenciaPIX(double valorTransferencia, String ChavePix) {
        if (valorTransferencia <= 0) {
            System.out.println("Digite um valor válido para a transferência PIX.");
            return;
        }

        if (conta.getSaldo() < valorTransferencia) {
            System.out.println("Saldo insuficiente para a transferência PIX.");
            System.out.println("Saldo disponível: " + conta.getSaldo());
            return;
        }

        conta.setSaldo(conta.getSaldo() - valorTransferencia);
        System.out.println("Transferência PIX de R$" + valorTransferencia + " realizada com sucesso para a chave: "+ ChavePix);
    }

    public void transferenciaTED(double valorTransferencia, int contaTED) {
        if (valorTransferencia <= 0) {
            System.out.println("Digite um valor válido para a transferência TED.");
            return;
        }

        if (conta.getSaldo() < valorTransferencia) {
            System.out.println("Saldo insuficiente para a transferência TED.");
            System.out.println("Saldo disponível: " + conta.getSaldo());
            return;
        }

        conta.setSaldo(conta.getSaldo() - valorTransferencia);
        System.out.println("Transferência TED de R$" + valorTransferencia + " realizada com sucesso.");
        System.out.println("A transferência será concluída em até 24 horas.");
    }
}