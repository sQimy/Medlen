package sample;

import java.io.*;
import java.net.Socket;

public class Connect {

        static Socket socket;
        Console console = System.console();


    public static Socket SocketConnect() throws IOException {
            String hostname = "localhost";
            int port = 555;
            if(socket == null) {
                socket = new Socket(hostname, port);
                System.out.println("Новый сокет"+socket.isConnected());
            }
            return socket;

    }

    public static void otpravit(String date) throws IOException {
        Socket s = SocketConnect();
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        output.writeUTF(date);
    }
    public static int poluchit() throws IOException {
        Socket s = SocketConnect();
        DataInputStream input = new DataInputStream(s.getInputStream());
        int date = input.readInt();
        return date;
    }

    public static String poluchitStr() throws IOException {
        Socket s = SocketConnect();
        DataInputStream input = new DataInputStream(s.getInputStream());
        String date = input.readUTF();
        return date;
    }

    public static User Pack(User pack) throws  IOException{
        ObjectOutputStream objOutputStream = null;
        Socket s = SocketConnect();
        objOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objOutputStream.writeObject(pack);
        DataInputStream input = new DataInputStream(s.getInputStream());
        return pack;
    }


    }
