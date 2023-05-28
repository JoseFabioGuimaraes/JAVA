package entidades;

public class investimentos {
    double saldoI;

    //GET E SET
    public double getSaldoI() {return saldoI;}

    public void setSaldoI(double saldoI) {this.saldoI = saldoI;}

    //METODOS:
    public void rendimentoI(){
        saldoI = saldoI * 0.10;
    }

    public void DepositarI (double valorDI){
        saldoI += valorDI;
        System.out.println("O valor de R$ "+valorDI+" foi depositado com sucesso. Obrigado");
    }

    public void sacarI(double valorSI){
        if(saldoI >= valorSI){
            saldoI -= valorSI;
            System.out.println("O valor de R$ "+valorSI+" foi sacado com sucesso");
        }else {
            System.out.println("Adicione um valor valido para continuar a operação");
        }
    }
    public void transferirSaldoI(ContaCorrente contaCorrente ,double valorTransferenciaI){
        if(saldoI >= valorTransferenciaI){
            saldoI -= valorTransferenciaI;
            contaCorrente.Depositar(valorTransferenciaI);
            System.out.println("O valor de R$"+valorTransferenciaI+" foi enviado para sua Conta Corrente com sucesso");
        }else{
            System.out.println("O valor informado é menor do que seu saldo, informe um valor valido");
        }
    }
}
