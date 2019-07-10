package daos;


import models.YarnLabel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class YarnDAO implements DAOInterface {

    @Override
    public Object findById(int id) {
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
        return null;
    }

    @Override
    public Object update(Object dto) {
        return null;
    }

    @Override
    public Object create(Object dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
