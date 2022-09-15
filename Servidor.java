import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
  static ServerSocket serverSocket;
  static Socket client_socket;

  public Servidor() {
    try {
      serverSocket = new ServerSocket(9600);
      System.out.println("Server socket init...");
    } catch (Exception e) {
      System.out.println("Erro na criação do server socket..." + e);
    }
  }

  static boolean connect() {
    boolean connected;
    try {
      client_socket = serverSocket.accept();
      System.out.println("client connected on " + client_socket);
      connected = true;
    } catch (Exception e) {
      connected = false;
    }
    return connected;
  }

  public static void main(String[] args) {
    new Servidor();
    if (connect()) {

      while (true) {
        String msgRecebida = Conexao.recieve(client_socket);
        System.out.println(msgRecebida);
        String resposta = "Mensagem recebida pelo server: " + msgRecebida;
        Conexao.send(client_socket, resposta);
      }
    }

    try {
      client_socket.close();
      serverSocket.close();
    } catch (Exception e) {
      // TODO: handle exception
    }

  }

}
