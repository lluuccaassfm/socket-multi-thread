import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Server implements Runnable{
    public Socket cliente;

    public Server(Socket cliente){
        this.cliente = cliente;
    }

    public static void main(String args[]) throws IOException{
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Servidor iniciado na porta 12345");

            while (true){
                Socket cliente = server.accept();
                Server newCliente = new Server(cliente);
                Thread thread = new Thread(newCliente);
                thread.start();
            }
    }

    @Override
    public void run() {
        System.out.println("Cliente conectado do IP "+this.cliente.getInetAddress().
                getHostAddress());
        try {
            Scanner entrada = new Scanner(this.cliente.getInputStream());
            while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
            }

            System.out.println("Cliente conectado do IP "+cliente.getInetAddress().
                    getHostAddress()+" finalizou conexão");
            entrada.close();
            this.cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
