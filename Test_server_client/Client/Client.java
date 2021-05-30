package sample;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.UnknownHostException;

public class Client {

    public Client() {

    }

    public static void main(String[] args) throws UnknownHostException, IOException {

        Scanner in = new Scanner(System.in);
        String hostname = "172.20.10.3";
        int port = 555;
        Socket socket = new Socket(hostname, port);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        Console console = System.console();
        boolean stop = false;
        System.out.println("Connected to server.");
        System.out.println("Напишите 1, Если вы Иванов И.И.");
        System.out.println("Напишите 2, Если вы Смирнов С.С.");
        while (!stop) {
            System.out.printf("Введите число: ");
            String text = in.next();
            if (text.equals("stop")) {
                break;
            }
            output.writeUTF(text);
            text = input.readUTF();
            System.out.printf(text + "\n");
        }
        socket.close();
    }
}