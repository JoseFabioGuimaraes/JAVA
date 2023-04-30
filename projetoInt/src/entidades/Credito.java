package entidades;

public class Credito extends ContaCorrente {
    Double CreditoLiberado = 0.0;
    Double FaturDoMes;

    public Double getCreditoLiberado() {
        return CreditoLiberado;
    }

    public void setCreditoLiberado(Double creditoLiberado) {
        CreditoLiberado = creditoLiberado;
    }

    public Double getFaturDoMes() {
        return FaturDoMes;
    }

    public void setFaturDoMes(Double faturDoMes) {
        FaturDoMes = faturDoMes;
    }

    public Credito(String usuario, int numeroConta, String senha) {
        super(usuario, numeroConta, senha);
    }

    public void creditoLiberado(Double valorAnalise) {
        if (valorAnalise < 100.00) {
            System.out.println("O valor foi analisado e não conseguimos liberar credito para você :(.\n Tente novamente mais tarde");
        } else {
            System.out.println("Uau, o valor foi analisado e conseguimos liberar um valor de credito para você: ");
            if (valorAnalise >= 100 && valorAnalise < 300.00) {
                CreditoLiberado = 250.00;
                System.out.println("Você conseguiu R$" + CreditoLiberado + " de credito, no qual pode ser usado como credito e Cheque especial");
            } else if (valorAnalise >= 300.00 && valorAnalise < 500.00) {
                CreditoLiberado = 450.00;
                System.out.println("Você conseguiu R$" + CreditoLiberado + " de credito, no qual pode ser usado como credito e Cheque especial");
            } else {
                CreditoLiberado = 650.00;
                System.out.println("Você conseguiu R$" + CreditoLiberado + " de credito, no qual pode ser usado como credito e Cheque especial");
            }
        }

    }

    public void FaturDoMes(Double valorPagarFatura) {
        if (CreditoLiberado == 250.00) {
             Double valorFatura = 173.00;
            System.out.println("O valor da fatura foi de R$" + valorFatura);
            if (getSaldo() < valorPagarFatura) {
                System.out.println("Valor indisponivel, saldo insuficiente");
            } else {
                setSaldo(getSaldo() - valorPagarFatura);
                Double novoValorFatura = FaturDoMes - valorPagarFatura;
                System.out.println("Fatura paga. \n Seu novo saldo é: R$" + getSaldo() + "E fatura está em: R$" + novoValorFatura);
            }
        } else if (CreditoLiberado == 450.00) {
            setFaturDoMes(353.74);
            System.out.println("O valor da fatura foi de R$" + FaturDoMes);
            if (getSaldo() < valorPagarFatura) {
                System.out.println("Valor indisponivel, saldo insuficiente");
            } else {
                setSaldo(getSaldo() - valorPagarFatura);
                Double novoValorFatura = FaturDoMes - valorPagarFatura;
                System.out.println("Fatura paga. \n Seu novo saldo é: R$" + getSaldo() + "E fatura está em: R$" + novoValorFatura);
            }
        } else {
            setFaturDoMes(523.44);
            System.out.println("O valor da fatura foi de R$" + FaturDoMes);
            if (getSaldo() < valorPagarFatura) {
                System.out.println("Valor indisponivel, saldo insuficiente");
            } else {
                setSaldo(getSaldo() - valorPagarFatura);
                Double novoValorFatura = FaturDoMes - valorPagarFatura;
                System.out.println("Fatura paga. \n Seu novo saldo é: R$" + getSaldo() + "E fatura está em: R$" + novoValorFatura);

            }
        }
    }
}


