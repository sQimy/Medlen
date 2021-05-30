package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/*public class Main {

    public static void main(String[] args) {

        int port = 555;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                new ServerThread(socket).start();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}*/


public class Server extends Thread {
    final static int SERVER_PORT = 555;
    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public static String Func1(String a) {
        if (a.equals("1")) {
            a = "Вы взяли кредит 15 тыс. рублей на 3 года!";
            return a;
        } else if (a.equals("2")) {
            a = "Вы взяли рассрочку 1 тыс. рублей на 12 месяцев!";
            return a;
        } else {
            a = "У вас пустая кредитная история!";
            return a;
        }
    }

    public void run() {
        System.out.println("Working or sleeping for 1 second");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DataInputStream clientinp;
        DataOutputStream clientout;
        try {
            clientinp = new DataInputStream(socket.getInputStream());
            clientout = new DataOutputStream(socket.getOutputStream());
            System.out.println("Local host is working on " + SERVER_PORT);
            while (true) {
                System.out.println("\nСчитываю...");
                String sentence = clientinp.readUTF();
                System.out.println("Прочитал: " + sentence);
                sentence = Func1(sentence);
                System.out.println("Ответил.\n");
                clientout.writeUTF(String.format("Ответ: " + sentence));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*do {
                text = reader.readLine();
                history = reader.readline();
                if (text == "1"){
                    System.out.println("Вы выбрали пункт: 1." + text);
                    Func1();
                }


                writer.println("Server_take: " + text);

            } while (!text.equals("bye"));
            System.out.println("Server close");
            socket.close();*/
        }
    }

    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket;
        serverSocket = new ServerSocket(SERVER_PORT);
        while (true) {
            Socket clientsocket = serverSocket.accept();

            new Server(clientsocket).start();
            System.out.println("Client is connected");
        }
    }
}

