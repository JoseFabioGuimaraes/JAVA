package entidades;

public class investimentos {
    private double saldoI;

    //GET E SET
    public double getSaldoI() {return saldoI;}

    public void setSaldoI(double saldoI) {this.saldoI = saldoI;}

    //METODOS:
    public void rendimentoI(){
        double rendimentoIn = saldoI*0.1;
        setSaldoI(getSaldoI() + rendimentoIn);
        System.out.println("O seu rendimento de: R$ "+rendimentoIn+" foi adicionado ao seu saldo");
    }

    public void DepositarI (double valorDI){
        setSaldoI(getSaldoI()+valorDI);
        System.out.println("O valor de R$ "+valorDI+" foi depositado com sucesso. Obrigado");
        System.out.println("Seu saldo atual é de: R$"+getSaldoI());
    }

    public void sacarI(double valorSI){
        if(getSaldoI() >= valorSI){
            setSaldoI(getSaldoI() - valorSI);
            System.out.println("O valor de R$ "+valorSI+" foi sacado com sucesso");
        }else {
            System.out.println("Adicione um valor valido para continuar a operação");
        }
    }

    // metodos transferencias:
    public void transferirSaldoCC(ContaCorrente contaCorrente, double valorTransferenciaCC){
        System.out.println(getSaldoI());
        if(getSaldoI() >= valorTransferenciaCC){
            setSaldoI(saldoI - valorTransferenciaCC);
            contaCorrente.Depositar(valorTransferenciaCC);
            System.out.println("O valor de R$"+valorTransferenciaCC+" foi enviado para sua Conta Corrente com sucesso");
        }else{
            System.out.println("O valor informado é menor do que seu saldo, informe um valor valido");
        }
    }
    // metodo para enviar o saldo da conta Poupança para a conta investimentos
    public void transferirSaldoIN(contaPoupanca poupanca, double valorTransferenciaP){
        if(getSaldoI() >= valorTransferenciaP){
            setSaldoI(saldoI - valorTransferenciaP);
            poupanca.depositar(valorTransferenciaP);
            System.out.println("O valor de R$"+valorTransferenciaP+" foi enviado para sua Conta Corrente com sucesso");
        }else{
            System.out.println("O valor informado é menor do que seu saldo, informe um valor valido");
        }
    }
}
