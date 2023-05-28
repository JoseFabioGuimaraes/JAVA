package entidades;

public class contaPoupanca {


    double saldoPoupanca;

    //GET E SET
    public double getSaldoPoupanca() {return saldoPoupanca;}
    public void setSaldoPoupanca(double saldoPoupanca) {this.saldoPoupanca = saldoPoupanca;}


    public void depositar(double valorDP){
        valorDP += saldoPoupanca;
        System.out.println("O Valor de R$ "+valorDP+" foi depositado na sua Conta poupança.");
    }

    //METODOS:
    public void sacar (double valorSP){
        if (saldoPoupanca>= valorSP){
            saldoPoupanca -= valorSP;
            System.out.println("O valor de R$ "+valorSP+" foi sacado com sucesso");
        } else{
            System.out.println("Digite um valor valido para continuar essa operação.");
        }
    }
    // rendimento
    public void redimentoP(){
        saldoPoupanca += saldoPoupanca * 0.02;
    }
    // metodo para enviar o saldo da conta Poupança para a conta Corrente
    public void transferirSaldoCC(ContaCorrente contaCorrente, double valorTransferenciaP){
        if(saldoPoupanca >= valorTransferenciaP){
            saldoPoupanca -= valorTransferenciaP;
            contaCorrente.Depositar(valorTransferenciaP);
            System.out.println("O valor de R$"+valorTransferenciaP+" foi enviado para sua Conta Corrente com sucesso");
        }else{
            System.out.println("O valor informado é menor do que seu saldo, informe um valor valido");
        }
    }
    // metodo para enviar o saldo da conta Poupança para a conta investimentos
    public void transferirSaldoIN(investimentos investimentos ,double valorTransferenciaP){
        if(saldoPoupanca >= valorTransferenciaP){
            saldoPoupanca -= valorTransferenciaP;
            investimentos.DepositarI(valorTransferenciaP);
            System.out.println("O valor de R$"+valorTransferenciaP+" foi enviado para sua Conta de  Investimentos com sucesso");
        }else{
            System.out.println("O valor informado é menor do que seu saldo, informe um valor valido");
        }
    }

}

