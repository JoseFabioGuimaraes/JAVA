package entidades;

public class Credito{
    private Double creditoLiberado;
    public Double faturaDoMes;
    private ContaCorrente conta;

    public Credito(ContaCorrente conta){
        this.conta= conta;

    }


    public Double getCreditoLiberado() {
        return creditoLiberado;
    }

    public void setCreditoLiberado(Double creditoLiberado) {
       this.creditoLiberado = creditoLiberado;
    }

    public Double getfaturaDoMes() {
        return faturaDoMes;
    }

    public void setfaturaDoMes(Double faturDoMes) {
        this.faturaDoMes = faturDoMes;
    }


    public void creditoLiberado(Double valorAnalise) {
        if (valorAnalise < 100.00) {
            System.out.println("O valor foi analisado e não conseguimos liberar credito para você :(.\n Tente novamente mais tarde");
        } else {
            System.out.println("Uau, o valor foi analisado e conseguimos liberar um valor de credito para você: ");
            if (valorAnalise >= 100 && valorAnalise < 300.00) {
                setCreditoLiberado(250.00);
                setfaturaDoMes(142.00);
                System.out.println("Você conseguiu R$" + getCreditoLiberado() + " de credito, no qual pode ser usado como credito e Cheque especial");
            } else if (valorAnalise >= 300.00 && valorAnalise < 500.00) {
                setCreditoLiberado(450.00);
                setfaturaDoMes(345.45);
                System.out.println("Você conseguiu R$" + getCreditoLiberado() + " de credito, no qual pode ser usado como credito e Cheque especial");
            } else {
                setCreditoLiberado(650.00);
                setfaturaDoMes(567.89);
                System.out.println("Você conseguiu R$" + getCreditoLiberado() + " de credito, no qual pode ser usado como credito e Cheque especial");
            }
        }
    }
    public void pagarFatura(){
        if(conta.getSaldo()>= getfaturaDoMes()){
        setfaturaDoMes(getfaturaDoMes()- conta.getSaldo());
        System.out.println("Fatura paga com sucesso, Obrigado :)");
        } else{
            System.out.println("Saldo Invalido. Deposite e tente novamente.");
        }
    }

    }



