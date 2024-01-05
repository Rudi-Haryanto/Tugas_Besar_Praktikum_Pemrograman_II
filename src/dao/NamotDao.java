package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import model.Namot;

public class NamotDao {

    // Get Insert Nama motor Dao in Database
    public int insert(Namot namamobil) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("insert into namot (id, namamobil) value (?, ?)");
            statement.setString(1, namamobil.getId());
            statement.setString(2, namamobil.getNamamobil());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Get Update Nama motor Dao in Database
    public int update(Namot namamobil) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("update namot set namamobil = ? where id = ?");
            statement.setString(1, namamobil.getNamamobil());
            statement.setString(2, namamobil.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(Namot namamobil) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("delete from namot where id = ?");
            statement.setString(1, namamobil.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Namot> findAll() {
        List<Namot> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("select * from namot");) {
                // Retrieving the data
                while (resultSet.next()) {
                    Namot namamobil = new Namot();
                    namamobil.setId(resultSet.getString("id"));
                    namamobil.setNamamobil(resultSet.getString("namamobil"));
                    list.add(namamobil);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
