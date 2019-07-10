package daos;
import models.YarnLabel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class YarnDAO implements DAOInterface<YarnLabel> {

    @Override
    public YarnLabel findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM yarn.label WHERE id="+ id);
            if (rs.next()) {
                return getLabel(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private YarnLabel getLabel(ResultSet rs) throws SQLException {
        YarnLabel label = new YarnLabel();
        label.setId(rs.getInt("id"));
        label.setPrimaryFiber(rs.getString("primaryFiber"));
        label.setSecondaryFiber(rs.getString("secondaryFiber"));
        label.setPly(YarnLabel.Ply.valueOf(rs.getString("ply")));
        label.setWeight(YarnLabel.Weight.valueOf(rs.getString("weight")));
        label.setColor(rs.getString("color"));
        return label;
    }

    @Override
    public List findALL() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM yarn");
            ArrayList<YarnLabel> labels = new ArrayList<>();
            while (rs.next()) {
                YarnLabel label = getLabel(rs);
                labels.add(label);
            }
            return labels;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    @Override
    public YarnLabel update(YarnLabel label) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE yarn.label SET primaryFiber=?, secondaryFiber=?, ply=?, weight=?, color=? WHERE id=" + label.getId());
                     if (updateTable(preparedStatement, label)) return label;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public YarnLabel create(YarnLabel label) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO yarn.label VALUES (NULL, ?, ?, ?, ?, ?)");
            if (updateTable(preparedStatement, label)) return label;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private boolean updateTable(PreparedStatement ps, YarnLabel label) throws SQLException {
        ps.setString(1, label.getPrimaryFiber());
        ps.setString(2, label.getSecondaryFiber());
        ps.setString(3, label.getPly().toString());
        ps.setString(4, label.getWeight().toString());
        ps.setString(5, label.getColor());
        return (ps.executeUpdate() == 1);
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM yarn.label WHERE id=" + id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
