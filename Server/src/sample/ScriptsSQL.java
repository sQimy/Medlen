package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
                statement.executeUpdate("insert into users values (" + ID + ",'" + last_name + "','" + first_name + "','" + telephone + "','" + addres + "'," + rating + ",'" + username1 + "','" + passwordS + "')");
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
                ResultSet resultSet = statement.executeQuery("select username from users where username='" + t + "'");
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
                ResultSet resultSet = statement.executeQuery("select password from users where username='" + log + "'");
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

    public static void addData(int ID, int cost, int total, String type) {
        try {
            String url = "jdbc:mysql://localhost/selfs";
            String username = "root";
            String password = "Danik0124";

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                statement.executeUpdate("insert into credit_history values (" + cost + "," + total + ",'не оплачен'," + ID + ",'" + type + "')");
                System.out.println("Заполнил в историю");
            }
        } catch (Exception ex) {
            System.out.println("Не заполнил в историю");

        }
    }

    public static Object[] dropData(int ID, int row) {
        try {
            String url = "jdbc:mysql://localhost/selfs";
            String username = "root";
            String password = "Danik0124";

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Object[] array = new Object[row * 4];
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from credit_history where users_ID=" + ID);
                int i = 0;
                while (resultSet.next()) {
                        int cost = resultSet.getInt(1);
                        int total = resultSet.getInt(2);
                        String status = resultSet.getString(3);
                        String type = resultSet.getString(5);
                        System.out.println("Это cost "+cost);
                        System.out.println("I = "+i);
                        array[i] = cost;
                        array[i + 1] = total;
                        array[i + 2] = status;
                        array[i + 3] = type;
                        System.out.println("Это я заполнил cost "+array[i]);
                        i+=4;
                }
                System.out.println("Вытащил кредитную историю");
                return array;
            }
        } catch (Exception ex) {
            System.out.println("Не вытащил кредитную историю");

        }
        return null;
    }

    public static int uznatidUser(String t) {
        try {
            String url = "jdbc:mysql://localhost/selfs";
            String username = "root";
            String password = "Danik0124";

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select ID from users where username='"+t+"'");
                while (resultSet.next()) {
                    int ID = resultSet.getInt(1);
                    return ID;
                }
                System.out.println("Выдал айди от логина");
            }
        } catch (Exception ex) {
            System.out.println("Не выдал айди от логина");

            System.out.println(ex);
        }
        return -1;
    }

    public static int uznatStroki(int id) {
        try {
            String url = "jdbc:mysql://localhost/selfs";
            String username = "root";
            String password = "Danik0124";

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select count(*) from credit_history where users_ID="+id);
                while (resultSet.next()) {
                    int ID = resultSet.getInt(1);
                    return ID;
                }
                System.out.println("Посчитал строки");
            }
        } catch (Exception ex) {
            System.out.println("Не посчитал строки");

            System.out.println(ex);
        }
        return -1;
    }
}
