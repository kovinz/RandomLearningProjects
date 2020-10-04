package com.company.DAO;

import com.company.DAO.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlDAO implements DAO {

  private String url = "jdbc:mysql://localhost:3306/stores?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  private String user = "root";
  private String password = "qwe123";

  private Connection con;
  private Statement stmt;
  private ResultSet rs;


  public MySqlDAO() throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException e) {
      System.out.println(e);
    } catch (SQLException e) {
      throw e;
    }
  }

  @Override
  public void insert(String tableToInsert, List<String> values) throws Exception {
    try {
      this.stmt = con.createStatement();
      String v = "";

      for (String s : values)
        v += s + ",";

      v = v.substring(0, v.length() - 1);
      stmt.executeUpdate("INSERT INTO" + tableToInsert + "VALUES" + "(" + v + ")");
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  @Override
  public void update(String table, String id, List<String> values) throws Exception {
    String request = "";

    try {
      ResultSetMetaData rsmd = con.createStatement().executeQuery("SELECT * FROM " + table).getMetaData();

      request = "UPDATE " + table + " SET ";

      for (int i = 2; i <= rsmd.getColumnCount(); i++)
        request += rsmd.getColumnName(i) + " = " + values.get(i - 2) + ", ";

      request = request.substring(0, request.length() - 2);
      request += " WHERE " + rsmd.getColumnName(1) + " = " + id;

      con.prepareStatement(request).execute();
    } catch (Exception e) {
      System.out.println(request);
      throw e;
    }
  }

  @Override
  public List<List<String>> select(String table) {
    ArrayList<List<String>> ans = new ArrayList<List<String>>();
    String request = "SELECT * from " + table;
    Statement st;
    this.rs = null;

    try {
      st = con.createStatement();
      rs = st.executeQuery(request);
      int temp = 0;

      while (rs.next()) {
        ArrayList<String> list = new ArrayList<String>();
        if (table.equals("product")) temp = 2;
        else if (table.equals("store")) temp = 3;
        else if (table.equals("presence")) temp = 5;

        for (int i = 1; i <= temp; i++)
          list.add(rs.getString(i));

        ans.add(list);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return ans;
  }

}

