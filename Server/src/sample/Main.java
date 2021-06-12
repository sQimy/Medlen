package sample;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Main extends Thread {
    final static int SERVER_PORT = 555;
    private Socket socket;

    public Main(Socket socket) {
        this.socket = socket;
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

                switch (sentence){
                    case ("1"):
                        String user = clientinp.readUTF();
                        String password = clientinp.readUTF();
                        String last_name = clientinp.readUTF();
                        String first_name = clientinp.readUTF();
                        String telephone = clientinp.readUTF();
                        String addres = clientinp.readUTF();
                        System.out.println("Прочитал: " + user+" " + password +" "+ last_name +" "+ first_name +" "+ telephone +" "+ addres);
                        int checkUser=ScriptsSQL.uznatUsername(user);
                        clientout.writeInt(checkUser);
                        System.out.println("Отправил проверку юзера " + checkUser);
                        String go = "Go";
                        if( go.equals(clientinp.readUTF())) {
                            SignUp.Registration(user, password, last_name, first_name, telephone, addres);
                        }
                        break;
                    case ("2"):
                        String login = clientinp.readUTF();
                        String pass = clientinp.readUTF();
                        int checkLogin=ScriptsSQL.uznatUsername(login);
                        clientout.writeInt(checkLogin);
                        String checkpass=ScriptsSQL.uznatPassword(login);
                        clientout.writeUTF(checkpass);
                        break;
                }

                /*System.out.println("Ответил.\n");
                clientout.writeUTF(String.format("Ответ: " + sentence));*/

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket;
        serverSocket = new ServerSocket(SERVER_PORT);
        while (true) {
            Socket clientsocket = serverSocket.accept();

            new Main(clientsocket).start();
            System.out.println("Client is connected");
        }
    }
}

