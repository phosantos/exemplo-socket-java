import java.net.Socket;
import java.util.Scanner;

/**
 * Cliente
 */
public class Cliente {
  static Socket socket;

  public Cliente() {
    try {
      socket = new Socket("127.0.0.1", 9600);
    } catch (Exception e) {
      System.out.println("Erro na resolução do host " + e);
    }
  }

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    new Cliente();
    while (true) {
      String message = entrada.nextLine();
      Conexao.send(socket, message);
      String resp = Conexao.recieve(socket);
      System.out.println(resp);
    }

    // entrada.close();
    // socket.close();
  }

}