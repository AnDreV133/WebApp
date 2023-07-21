package SQL;

import logs.LogHandler;

import java.sql.*;
import java.util.ArrayList;


public class SQLHandler {
   static private Statement stmt;
   static private Connection connection;

   static private final LogHandler logHandler = new LogHandler();

   static {
      String url = "jdbc:mysql://localhost:3306/UsersNotionsDB";
      String username = "root";
      String password = "root";

      try {
         connection = DriverManager.getConnection(url, username, password);
         stmt = connection.createStatement();
      } catch (SQLException e) {
         logHandler.error("connection database.", e);
      }


      try {
         stmt.execute(""); // создание таблицы сделаааааааааааааать
      } catch (SQLException e) {
         logHandler.error("create database.", e);
      }
   }

   public UsersTableRow getUserByID(String id) {
      try {
         ResultSet rs = stmt.executeQuery(
             "SELECT * FROM users_db.users_table WHERE id = '%s'"
                 .formatted(id));

         return new UsersTableRow(
             rs.getString("id"),
             rs.getString("login"),
             rs.getString("password"),
             rs.getString("text"));

      } catch (SQLException e) {
         logHandler.error("method getUserByID.", e);
      }

      return null;
   }

   public ArrayList<UsersTableRow> getTable() {
      try {
         ArrayList<UsersTableRow> table = new ArrayList<>();
         ResultSet rs = stmt.executeQuery("SELECT * FROM users_db.users_table");

         while (rs.next()) {
            UsersTableRow ur = new UsersTableRow(
                rs.getString("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("text"));

            table.add(ur);
         }

         return table;

      } catch (SQLException e) {
         logHandler.error("method getTable.", e);
      }

      return null;
   }

   public boolean isFieldInTable(String column, String askedElem) {
      try {
         ResultSet rs = stmt.executeQuery(
             "SELECT %s FROM users_db.users_table WHERE %s = '%s' LIMIT 1;"
                 .formatted(column, column, askedElem));

         if (rs.isFirst())
            return true;

      } catch (SQLException e) {
         logHandler.error("method isFieldInTable.", e);
      }

      return false;
   }

   public boolean isUserInTable(String username, String password) {
      try {
         ResultSet rs = stmt.executeQuery(
             "SELECT * FROM users_db.users_table WHERE username = '%s' and password = '%s' LIMIT 1;"
                 .formatted(username, password));

         if (rs.isFirst())
            return true;

      } catch (SQLException e) {
         logHandler.error("method isFieldInTable.", e);
      }

      return false;
   }

   public void insertNewUser(String id, String login, String password) {
      try {
         stmt.execute(
             "INSERT INTO users_db.users_table VALUES ('%s', '%s', '%s', NULL);"
                 .formatted(id, login, password));

      } catch (SQLException e) {
         logHandler.error("method insertNewUser.", e);
      }
   }
}
