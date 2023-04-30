import java.util.Scanner;
public class beecrowndTestes {
    public static void main (String [] args){
        Scanner leitor = new Scanner(System.in);
        int penultimo = 0;
        int ultimo = 1;
        int N= Integer.parseInt(leitor.nextLine());
        if (N ==1 ){
            System.out.print("0");
        } else if (N>=2) {
            System.out.print("0 1");
        }
        for(int k =3; k<=N; k++){
         int temp = ultimo;
         ultimo = penultimo+ultimo;
         penultimo = temp;
         System.out.print(" "+ultimo);
     }
     System.out.println();
        leitor.close();
 }
}
