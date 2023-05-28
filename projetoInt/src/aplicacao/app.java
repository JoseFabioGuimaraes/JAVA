package aplicacao;

import java.util.Scanner;
import entidades.ContaCorrente;
import entidades.ContaTransferencia;
import entidades.Credito;

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

        // o que o usuario quer acessar (case)
        // TODO: 27/05/2023 : criar um array com algumas contas setadas. (Não sei se vai dar tempo.)
        ContaCorrente minhaConta = new ContaCorrente(Usuario,numConta,senha);
        ContaTransferencia transferencia = new ContaTransferencia(minhaConta.getUsuario(), minhaConta.getNumeroConta(), minhaConta.getUsuario());
        Credito credito = new Credito(minhaConta.getUsuario(), minhaConta.getNumeroConta(), minhaConta.getUsuario());
        System.out.println("Seu saldo é de: " + minhaConta.getSaldo());

        //TODO: Criar um acesso diferente para as funções Conta corrente e suas herenças, Poupança  e Investimento
        while (true){
            System.out.print("Qual ação gostaria de fazer: \n 1- Ações para Conta Corrente \n 2- Tranferência \n 3- Opções de Credito \n 6- Sair \n");
            int escolha = Integer.parseInt(scanner.nextLine());
            switch (escolha){
                case 1:
                    System.out.println("Digite qual Ação deseja fazer: \n 1- Depositar \n 2-Consultar Saldo \n 3- Sacar");
                    int escolhaConta = Integer.parseInt(scanner.nextLine());
                    if(escolhaConta == 1) {
                        System.out.println("Digite o valor que deseja Depositar: ");
                        Double valorDeposito = Double.parseDouble(scanner.nextLine());
                        minhaConta.Depositar(valorDeposito);
                    } else if (escolhaConta == 2) {
                        System.out.println("Seu saldo é: "+ minhaConta.getSaldo());
                    } else if (escolhaConta == 3) {
                        System.out.println("Digite o valor que deseja sacar:");
                        Double valorSacar = Double.parseDouble(scanner.nextLine());
                        minhaConta.Sacar(valorSacar);
                    } else{
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
                        int numeroContaTED = Integer.parseInt(scanner.nextLine());
                        transferencia.TransferenciaTed(valorTransfTed, numeroContaTED);
                    } else if (escolhaTransfer == 2) {
                        System.out.println("Você escolheu a opção PIX (Envio imediato). \n Digite o valor que deseja enviar: ");
                        Double valorTransfPix = Double.parseDouble(scanner.nextLine());
                        System.out.println("Digite a chave pix (Celular,CPF/CNPJ,Email): ");
                        String chavePix = scanner.nextLine();
                        transferencia.TranferenciaPix(valorTransfPix, chavePix);
                        System.out.println("Tranferência enviada");
                    } else {System.out.println("Digite um valor valido");}
                    break;
                case 3:
                    if(credito.getCreditoLiberado()<100) {
                        System.out.println("Você selecionou a opção Credito. Vi aqui que Você não tem credito liberado, Deseja fazer uma analise? \n É rapidinho :D\n Digite 1 para SIM e 2 para NÃO");
                        int escolhaAnaliseCredito = Integer.parseInt(scanner.nextLine());
                        if(escolhaAnaliseCredito == 1){
                            System.out.println("Que bom que você se interessou, me informa rapidinho quanto você ganha por mês para analisarmos. \n É rapido, eu juro :P");
                            double valorAnalise = Double.parseDouble(scanner.nextLine());
                            credito.creditoLiberado(valorAnalise);
                        } else{
                            System.out.println("OK :(. Estamos aqui sempre que quiser");
                            break;

                        }
                    }else{
                        System.out.println("Seu credito disponivel é: R$"+ credito.getCreditoLiberado());
                        if(credito.getFaturDoMes()< 0) {
                            System.out.println("Sua fatura esta zerada.");
                        }else{
                            System.out.println("Sua fatura está: "+ credito.getFaturDoMes()+"\n Deseja pagar agora? \n 1 -Sim \n 2 - Não");
                            int escolhaPagar = Integer.parseInt(scanner.nextLine());
                            if(escolhaPagar == 1){
                                credito.PagarFatura(142.00);

                            }


                        }

                    }

                    break;
                case 6:
                    System.out.print("Agradecemos a preferência! \n Fechando Banco,até mais!");
                    return;
                default:
                    System.out.println("Escolha inválida. Digite uma das opções validas.");
                    break;

            }

        }


    }

}
