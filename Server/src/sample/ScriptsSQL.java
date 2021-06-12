package sample;

import java.sql.*;

public class ScriptsSQL {
    public static void SignUp(int ID, String last_name, String first_name, String telephone, String addres, int rating, String username1, String passwordS) {
        try {
            String url = "jdbc:mysql://localhost/selfs";
            String username = "root";
            String password = "Danik0124";

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                statement.executeUpdate("insert into users values ("+ID+",'"+last_name+"','"+first_name+"','"+telephone+"','"+addres+"',"+rating+",'"+username1+"','"+passwordS+"')");
                System.out.println("Зарегал в бд");
            }
        } catch (Exception ex) {
            System.out.println("Не зарегал в бд");

        }
    }

    public static int uznatID() {
        try {
            String url = "jdbc:mysql://localhost/selfs";
            String username = "root";
            String password = "Danik0124";

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select max(ID) from users");
                while (resultSet.next()) {
                    int ID = resultSet.getInt(1);
                    System.out.println("Выдал максимальный айдишник");
                    return ID;
                }
            }
        } catch (Exception ex) {
            System.out.println("Не выдал максимальный айдишник");
        }
        return 0;
    }
    public static int uznatUsername(String t) {
        try {
            String url = "jdbc:mysql://localhost/selfs";
            String username = "root";
            String password = "Danik0124";

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select username from users where username='"+t+"'");
                while (resultSet.next()) {
                    String user = resultSet.getString(1);
                    return 1;
                }
                System.out.println("Проверил удачно на логин");
            }
        } catch (Exception ex) {
            System.out.println("Такого логина нет");

            System.out.println(ex);
        }
        return 0;
    }
    public static String uznatPassword(String log) {
        try {
            String url = "jdbc:mysql://localhost/selfs";
            String username = "root";
            String password = "Danik0124";

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select password from users where username='"+log+"'");
                while (resultSet.next()) {
                    String newpas = resultSet.getString(1);
                    return newpas;
                }
                System.out.println("Проверил удачно пароль");
            }
        } catch (Exception ex) {
            System.out.println("Пароль не верный");

        }
        return "Что то пошло не так на проверке пароля";
    }

}
