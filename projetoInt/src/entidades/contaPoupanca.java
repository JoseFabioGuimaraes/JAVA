package entidades;

public class contaPoupanca {


    private double saldoPoupanca;

    //GET E SET
    public double getSaldoPoupanca() {return saldoPoupanca;}
    public void setSaldoPoupanca(double saldoPoupanca) {this.saldoPoupanca = saldoPoupanca;}


    public void depositar(double valorDP){
        setSaldoPoupanca(getSaldoPoupanca() + valorDP);
        System.out.println("O Valor de R$ "+valorDP+" foi depositado na sua Conta poupança.");
    }

    //METODOS:
    public void sacar (double valorSP){
        if (getSaldoPoupanca()>= valorSP){
            setSaldoPoupanca(getSaldoPoupanca() + valorSP);
            System.out.println("O valor de R$ "+valorSP+" foi sacado com sucesso");
        } else{
            System.out.println("Digite um valor valido para continuar essa operação.");
        }
    }
    // rendimento
    public void redimentoP(){
        double rendimento = saldoPoupanca* 0.02;
        setSaldoPoupanca(getSaldoPoupanca() +rendimento);
        System.out.println("O rendimento de R$ "+rendimento+" foi adicionado ao seu saldo");
        System.out.println("Seu saldo atual é de: R$ " +getSaldoPoupanca());
    }

    // metodo para enviar o saldo da conta Poupança para a conta Corrente
    public void transferirSaldoCC(ContaCorrente contaCorrente, double valorTransferenciaP){
        if(getSaldoPoupanca() >= valorTransferenciaP){
            setSaldoPoupanca(saldoPoupanca - valorTransferenciaP);
            contaCorrente.Depositar(valorTransferenciaP);
            System.out.println("O valor de R$"+valorTransferenciaP+" foi enviado para sua Conta Corrente com sucesso");
        }else{
            System.out.println("O valor informado é menor do que seu saldo, informe um valor valido");
        }
    }
    // metodo para enviar o saldo da conta Poupança para a conta investimentos
    public void transferirSaldoIN(investimentos investimentos, double valorTransferenciaIN){
        if(getSaldoPoupanca() >= valorTransferenciaIN){
            setSaldoPoupanca(saldoPoupanca - valorTransferenciaIN);
            investimentos.DepositarI(valorTransferenciaIN);
            System.out.println("O valor de R$"+valorTransferenciaIN+" foi enviado para sua Conta Corrente com sucesso");
        }else{
            System.out.println("O valor informado é menor do que seu saldo, informe um valor valido");
        }
    }

}

