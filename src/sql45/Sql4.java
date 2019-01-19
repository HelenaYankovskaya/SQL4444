package sql45;

import java.sql.*;

public class Sql4 {
    public static void main(String[] args) {   //Задание 4 в РТ-3

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        String dbURL = "jdbc:mysql://localhost:3306/ListExpenses";
        String username="root";
        String password="123456";
        Connection myConnection;
        try {
             myConnection = DriverManager.getConnection(dbURL,username, password);
        Statement statement = myConnection.createStatement();

            String update = "Insert into expenses values(5,'2011-5-12',2,'150000.00')";
            statement.executeUpdate(update);

        String query ="Select expenses.num, paydate,value, name from expenses,receivers where receiver=receivers.num";
            statement.executeQuery(query);
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                System.out.println(result.getString(1)+" "+result.getString(2)+" " +result.getString(3)+" "+ result.getString(4));
            }
myConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        }


