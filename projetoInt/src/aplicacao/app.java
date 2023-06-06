package aplicacao;

import java.util.Scanner;
import entidades.ContaCorrente;
import entidades.ContaTransferencia;
import entidades.Credito;
import entidades.contaPoupanca;
import entidades.investimentos;
import javax.sound.midi.Soundbank;

public class app {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu Nome:");
        String Usuario = scanner.nextLine();
        System.out.println("Digite o numero da sua conta: ");
        int numConta = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();
        // Double saldo = 0.0;


        ContaCorrente minhaConta = new ContaCorrente(Usuario, numConta, senha);
        ContaTransferencia transferencia = new ContaTransferencia(minhaConta);
        Credito credito = new Credito(minhaConta);
        contaPoupanca poupanca = new contaPoupanca();
        investimentos investimentos = new investimentos();
        System.out.println("Seu saldo é de: " + minhaConta.getSaldo());

        while (true) {
            System.out.println("Qual tipo de conta gostaria de acessar: \n 1- Conta corrente \n 2- Conta Poupança \n 3- Conta Investimentos\n 0- Sair");
            int escolhaTipoConta = Integer.parseInt(scanner.nextLine());
            if (escolhaTipoConta== 0 ){System.out.println("Encerrando programa..."); break;}
            switch (escolhaTipoConta) {
                case 1:
                    System.out.print("Qual ação gostaria de fazer: \n 1- Ações para Conta Corrente \n 2- Tranferência \n 3- Opções de Credito \n 4- Sair \n");
                    int escolha = Integer.parseInt(scanner.nextLine());
                    switch (escolha) {
                        case 1:
                            System.out.println("Digite qual Ação deseja fazer: \n 1- Depositar \n 2-Consultar Saldo \n 3- Sacar");
                            int escolhaConta = Integer.parseInt(scanner.nextLine());
                            if (escolhaConta == 1) {
                                System.out.println("Digite o valor que deseja Depositar: ");
                                Double valorDeposito = Double.parseDouble(scanner.nextLine());
                                minhaConta.Depositar(valorDeposito);
                            } else if (escolhaConta == 2) {
                                System.out.println("Seu saldo é: " + minhaConta.getSaldo());
                            } else if (escolhaConta == 3) {
                                System.out.println("Digite o valor que deseja sacar:");
                                Double valorSacar = Double.parseDouble(scanner.nextLine());
                                minhaConta.Sacar(valorSacar);
                            } else {
                                System.out.println("Digite um valor valido!");
                            }
                            break;
                            case 2:
                                System.out.println("Você deseja fazer qual tipo de transferência: \n 1- TED \n 2- PIX");
                                int escolhaTransfer = Integer.parseInt(scanner.nextLine());
                                if (escolhaTransfer == 1) {
                                    System.out.println("Digite o valor que será Transferido: ");
                                    Double valorTransfTed = Double.parseDouble(scanner.nextLine());
                                    System.out.println("Digite o numero da conta que Deseja enviar: ");
                                    int contaTED = Integer.parseInt(scanner.nextLine());
                                    transferencia.transferenciaTED(valorTransfTed, contaTED);
                                } else if (escolhaTransfer == 2) {
                                    System.out.println("Você escolheu a opção PIX (Envio imediato). \n Digite o valor que deseja enviar: ");
                                    Double valorTransfPix = Double.parseDouble(scanner.nextLine());
                                    System.out.println("Digite a chave pix (Celular,CPF/CNPJ,Email): ");
                                    String chavePix = scanner.nextLine();
                                    transferencia.transferenciaPIX(valorTransfPix, chavePix);
                                    System.out.println("Tranferência enviada");
                                } else {
                                    System.out.println("Digite um valor valido");
                                }
                                break;
                            case 3:
                                if (credito.getCreditoLiberado() == null) {
                                    System.out.println("Você selecionou a opção Credito. Vi aqui que Você não tem credito liberado, Deseja fazer uma analise? \n É rapidinho :D\n Digite 1 para SIM e 2 para NÃO");
                                    int escolhaAnaliseCredito = Integer.parseInt(scanner.nextLine());
                                    if (escolhaAnaliseCredito == 1) {
                                        System.out.println("Que bom que você se interessou, me informa rapidinho quanto você ganha por mês para analisarmos. \n É rapido, eu juro :P");
                                        System.out.println("Digite o limite sua base salarial: ");
                                        double valorAnalise = Double.parseDouble(scanner.nextLine());
                                        credito.creditoLiberado(valorAnalise);
                                    } else {
                                        System.out.println("OK :(. Estamos aqui sempre que quiser");
                                        break;
                                    }
                                } else {
                                    System.out.println("Seu credito disponivel é: R$" + credito.getCreditoLiberado());
                                    if (credito.getfaturaDoMes() < 0) {
                                        System.out.println("Sua fatura esta zerada.");
                                    } else {
                                        System.out.println("Sua fatura está: " + credito.getfaturaDoMes() + "\n Deseja pagar agora? \n 1 -Sim \n 2 - Não");
                                        int escolhaPagar = Integer.parseInt(scanner.nextLine());
                                        if (escolhaPagar == 1) {
                                            credito.pagarFatura();
                                        } else {
                                            System.out.println("Tudo bem, podemos tentar depois");
                                        }
                                    }
                                }
                                break;
                            case 4:
                                System.out.print("Agradecemos a preferência! \n Voltando ao menu de Escolha de contas");
                                break;
                            default:
                                System.out.println("Escolha inválida. Digite uma das opções validas.");
                                break;

                    }
                    break;
                case 2:
                    System.out.println("O que você deseja fazer: \n 1- Verificar o saldo da sua conta \n 2- Depositar \n 3- Sacar \n 4- Ver o seu rendimento \n 5- Transferir para Conta Corrente/Investimento \n 6- Voltar ao menu");
                    int escolhaPoupanca = Integer.parseInt(scanner.nextLine());
                    switch (escolhaPoupanca) {
                        case 1:
                            System.out.println("Seu saldo é de: R$"+ poupanca.getSaldoPoupanca());
                            break;
                        case 2:
                            System.out.println("Quanto gostaria de depositar: ");
                            double valorDP = Double.parseDouble(scanner.nextLine());
                            poupanca.depositar(valorDP);
                            break;
                        case 3:
                            System.out.println("Digite o valor que deseja sacar:");
                            double valorSP = Double.parseDouble(scanner.nextLine());
                            poupanca.sacar(valorSP);
                            break;
                        case 4:
                            poupanca.redimentoP();
                            break;
                        case 5:
                            System.out.println("Para qual Conta deseja transferir: \n1 - Conta Corrente \n2 - Conta Investimento");
                            int escolhaContaTransfeP = Integer.parseInt(scanner.nextLine());
                            if (escolhaContaTransfeP == 1){
                                System.out.println("Digite o valor que deseja transferir para sua Conta Corrente: ");
                                double valorTransferenciaCC = Double.parseDouble(scanner.nextLine());
                                poupanca.transferirSaldoCC(minhaConta,valorTransferenciaCC);
                            }else if (escolhaContaTransfeP == 2){
                                System.out.println("Digite o valor que deseja transferir para sua Conta Investimentos: ");
                                double valorTransferenciaIN = Double.parseDouble(scanner.nextLine());
                                poupanca.transferirSaldoIN(investimentos,valorTransferenciaIN);
                        }else{
                                System.out.println("Digite um valor valido");
                            }
                            break;

                        case 6:
                            System.out.println("Voltando ao menu de Contas.");
                            break;
                        default:
                            System.out.println("Escolha inválida. Digite uma das opções validas.");
                            break;

                    }
                    break;
                case 3:
                    System.out.println("O que você deseja fazer: \n 1- Verificar o saldo da sua conta \n 2- Depositar \n 3- Sacar \n 4- Ver o seu rendimento \n 5- Transferir para Conta Corrente/Poupança \n 6- Voltar ao menu");
                    int escolhaInvestimento = Integer.parseInt(scanner.nextLine());
                    switch (escolhaInvestimento){
                        case 1:
                            System.out.println("Seu saldo é de: R$"+ investimentos.getSaldoI());
                            break;
                        case 2:
                            System.out.println("Quanto gostaria de depositar: ");
                            double valorDP = Double.parseDouble(scanner.nextLine());
                            investimentos.DepositarI(valorDP);
                            break;
                        case 3:
                            System.out.println("Digite o valor que deseja sacar:");
                            double valorSP = Double.parseDouble(scanner.nextLine());
                            investimentos.sacarI(valorSP);
                            break;
                        case 4:
                            investimentos.rendimentoI();
                            break;
                        case 5:
                            System.out.println("Para qual Conta deseja transferir: \n1 - Conta Corrente \n2 - Conta Poupança");
                            int escolhaContaTransfeI = Integer.parseInt(scanner.nextLine());
                            if (escolhaContaTransfeI == 1){
                                System.out.println("Digite o valor que deseja transferir para sua Conta Corrente: ");
                                double valorTransferenciaCC = Double.parseDouble(scanner.nextLine());
                                poupanca.transferirSaldoCC(minhaConta,valorTransferenciaCC);
                            }else if (escolhaContaTransfeI == 2){
                                System.out.println("Digite o valor que deseja transferir para sua Conta Poupança: ");
                                double valorTransferenciaIN = Double.parseDouble(scanner.nextLine());
                                poupanca.transferirSaldoIN(investimentos,valorTransferenciaIN);
                            }else{
                                System.out.println("Digite um valor valido");
                            }
                            break;
                        case 6:
                            System.out.println("Voltando ao menu de Contas.");
                            break;
                        default:
                            System.out.println("Escolha inválida. Digite uma das opções validas.");
                            break;
                    }
                         break;
                    default:
                    System.out.println("Escolha invalida"); continue;
            }


        }

    }
}
