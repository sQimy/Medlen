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
                int resultSet = statement.executeUpdate("insert into users values ("+ID+",'"+last_name+"','"+first_name+"','"+telephone+"','"+addres+"',"+rating+")");
                int resultSet1 = statement.executeUpdate("insert into regaut values ("+"'"+username1+"','"+passwordS+"',"+ID+")");
                System.out.println("Connection to Store DB succesfull!");
            }
        } catch (Exception ex) {
            System.out.println("Connection failed SignUp...");

            System.out.println(ex);
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
                ResultSet resultSet = statement.executeQuery("select max(users_ID) from regaut");
                while (resultSet.next()) {
                    int ID = resultSet.getInt(1);
                    System.out.printf("%s\n ", ID);
                    return ID;
                }
                System.out.println("Connection to Store DB succesfull!");
            }
        } catch (Exception ex) {
            System.out.println("Connection failed узнать ID...");

            System.out.println(ex);
        }
        return 0;
    }
}
