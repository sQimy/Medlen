package sample;

import javafx.collections.ObservableList;

import javax.xml.crypto.Data;
import java.io.*;
import java.lang.reflect.Array;
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
            ObjectInputStream objInputStream = null;
            ObjectOutputStream objOutputStream = null;
            System.out.println("Local host is working on " + SERVER_PORT);
            while (true) {

                System.out.println("\nСчитываю...");
                objInputStream = new ObjectInputStream(socket.getInputStream());
                User user = (User) objInputStream.readObject();
                System.out.println(user.code());
                System.out.println("Прочитал: " + user.usernameS);

                switch (user.code()){
                    case ("1"):
                        System.out.println("Прочитал: " + user.UsernameS()+" " + user.passwordS+" "+ user.last_name+" "+ user.first_name +" "+ user.telephone +" "+ user.addres);
                        int checkUser=ScriptsSQL.uznatUsername(user.UsernameS());
                        clientout.writeInt(checkUser);
                        System.out.println("Отправил проверку юзера " + checkUser);
                        String go = "Go";
                        if( go.equals(clientinp.readUTF())) {
                            SignUp.Registration(user.usernameS, user.passwordS, user.last_name, user.first_name, user.telephone, user.addres);
                        }
                        break;
                    case ("2"):
                        int checkLogin=ScriptsSQL.uznatUsername(user.UsernameS());
                        clientout.writeInt(checkLogin);
                        String checkpass=ScriptsSQL.uznatPassword(user.usernameS);
                        clientout.writeUTF(checkpass);
                        String f = clientinp.readUTF();
                        if (f.equals("Yes")){
                            while(socket.isConnected()) {
                                System.out.println("Я еще подключен");
                                int id = ScriptsSQL.uznatidUser(user.UsernameS());
                                System.out.println("Ваш айди" + id);
                                String get = clientinp.readUTF();
                                if (get.equals("1")) {
                                    objInputStream = new ObjectInputStream(socket.getInputStream());
                                    Credit_Form userCredit = (Credit_Form) objInputStream.readObject();
                                    System.out.println(id + " " + userCredit.cost + " " + userCredit.total + " " + userCredit.type);
                                    ScriptsSQL.addData(id, userCredit.cost, userCredit.total, userCredit.type);
                                }
                                if (get.equals("2")){
                                    //Drop_Form UserCredit = ScriptsSQL.dropData(id);
                                    int row = ScriptsSQL.uznatStroki(id);
                                    System.out.println("Кол-во строк "+row);
                                    clientout.writeInt(row);
                                    Object[] array = ScriptsSQL.dropData(id,row);
                                    objOutputStream = new ObjectOutputStream(socket.getOutputStream());
                                    objOutputStream.writeObject(array);


                                    //objOutputStream.writeObject(list.toArray());
                                }
                            }
                        }else{System.out.println("Что ты задумал?");}
                        break;
                }

                /*System.out.println("Ответил.\n");
                clientout.writeUTF(String.format("Ответ: " + sentence));*/

            }
        } catch (IOException | ClassNotFoundException e) {
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

