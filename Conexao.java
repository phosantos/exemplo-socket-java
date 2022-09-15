import java.net.*;
import java.io.*;

public class Conexao {

  // public static void send(Socket socket, String message) {
  // OutputStream out;
  // try {
  // out = socket.getOutputStream();
  // out.write(message.getBytes());
  // } catch (Exception e) {
  // System.out.println("Error on send. " + e);
  // }
  // }

  // public static String recieve(Socket socket) {
  // InputStream input;
  // int bytesLenght;
  // byte bytesMessage[] = new byte[79];
  // String message = "";

  // try {
  // input = socket.getInputStream();
  // bytesLenght = input.read(bytesMessage);
  // if (bytesLenght > 0)
  // message = new String(bytesMessage);
  // } catch (Exception e) {
  // System.out.println("Error on recieve. " + e);
  // }

  // return message;
  // }

  public static void send(Socket socket, String message) {
    try {
      DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());
      ostream.writeUTF(message);
    } catch (Exception e) {
      System.out.println("Error on send message... " + e);
    }
  }

  public static String recieve(Socket socket) {
    String message;
    try {
      DataInputStream istream = new DataInputStream(socket.getInputStream());
      message = istream.readUTF();
    } catch (Exception e) {
      System.out.println("Error on recieve message... " + e);
      message = "";
    }

    return message;
  }

}
