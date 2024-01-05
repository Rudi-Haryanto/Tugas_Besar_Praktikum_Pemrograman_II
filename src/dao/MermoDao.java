package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import model.Mermo;

public class MermoDao {
    // Get Insert Merekmobil Dao in Database
    public int insert(Mermo merekmobil) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("insert into mermo (id, merekmobil) value (?, ?)");
            statement.setString(1, merekmobil.getId());
            statement.setString(2, merekmobil.getMerekmobil());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Update Merekmobil Dao in Database
    public int update(Mermo merekmobil) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("update mermo set merekmobil = ? where id = ?");
            statement.setString(1, merekmobil.getMerekmobil());
            statement.setString(2, merekmobil.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Delete Merekmobil dao in database
    public int delete(Mermo merekmobil) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("delete from mermo where id = ?");
            statement.setString(1, merekmobil.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Mermo> findAll() {
        List<Mermo> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("select * from mermo");) {
                // Retrieving the data
                while (resultSet.next()) {
                    Mermo merekmobil = new Mermo();
                    merekmobil.setId(resultSet.getString("id"));
                    merekmobil.setMerekmobil(resultSet.getString("merekmobil"));
                    list.add(merekmobil);
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
