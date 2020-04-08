import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {

        try {
            Socket cliente = new Socket("127.0.0.5", 12345);
            System.out.println(" Sou o cliente 2");
            System.out.println("O cliente 2 se conectou ao servidor!");

            try (Scanner teclado = new Scanner(System.in);
                 PrintStream saida = new PrintStream(cliente.getOutputStream())) {

                while (teclado.hasNextLine()) {
                    String line = teclado.nextLine();
                    if(line.equals("exit")){
                        cliente.close();
                        break;
                    }else{
                        saida.println(line);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Erro: "+e);
        }
    }
}
