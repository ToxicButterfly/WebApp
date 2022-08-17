package org.example.Dao;

import org.example.entity.Class1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoClass {

    private final Connection connection;

    public DaoClass() throws ClassNotFoundException {
        this.connection = JdbcConnection.getConnection();
    }

    //saving info into corresponding tables by line
    public void save(Class1 class1, int classnum) {

        String sql = "INSERT INTO Class"
                + classnum + " (accounting, saldoinactiv, saldoinpassiv, debit, credit, saldooutactiv, saldooutpassiv) "
                + "VALUES(?,?,?,?,?,?,?)";

        try (PreparedStatement statement =
                     this.connection.prepareStatement(
                             sql,
                             Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, class1.getFirstLine());
            statement.setString(2, class1.getSaldoInActiv());
            statement.setString(3, class1.getSaldoInPassiv());
            statement.setString(4, class1.getDebit());
            statement.setString(5, class1.getCredit());
            statement.setString(6, class1.getSaldoOutActiv());
            statement.setString(7, class1.getSaldoOutPassiv());

            int numberOfInsertedRows = statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //getting info from selected Table
    public List<Class1> getClass(String classnum) throws SQLException {
        List<Class1> list = new ArrayList<>();
        String sql = "SELECT accounting, saldoinactiv, saldoinpassiv, debit, credit, saldooutactiv, saldooutpassiv FROM Class"+classnum;
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            String first = resultSet.getString("accounting");
            String second = resultSet.getString("saldoinactiv");
            String third = resultSet.getString("saldoinpassiv");
            String fourth = resultSet.getString("debit");
            String fifth = resultSet.getString("credit");
            String sixth = resultSet.getString("saldooutactiv");
            String seventh = resultSet.getString("saldooutpassiv");
            Class1 class1 = new Class1(first, second,third,fourth, fifth, sixth, seventh);
            list.add(class1);
        }
        return list;


    }
}
