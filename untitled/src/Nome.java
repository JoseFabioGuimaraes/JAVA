import javax.swing.JOptionPane;
public class Nome {
    public static void main (String[] args){
        String nome = JOptionPane.showInputDialog("Digite seu nome: ");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade: "));
        JOptionPane.showMessageDialog(null,"Parabéns " + nome + " pelos seus "+ idade + " anos");

    }
}
