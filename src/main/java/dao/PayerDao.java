package dao;

import config.Database;
import model.Payer;

import java.sql.*;

public class PayerDao extends GenericDao<Payer>{
    public PayerDao(Database db) {
        super(db);
    }

    @Override
    protected String getTableName(){
        return "payer";
    }

    @Override
    protected Payer map(ResultSet rs) throws SQLException {
        Payer payer = new Payer();
        payer.setId(rs.getInt("id"));
        payer.setName(rs.getString("name"));
        return payer;
    }

    @Override
    public void save(Payer payer) throws SQLException{
        String query = "INSERT INTO payer(name)"
                + "values (?)";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, payer.getName());
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                payer.setId(keys.getInt(1));
            }
        }

    }

    @Override
    public void update(Payer payer) throws SQLException {
        String query = "UPDATE payer SET name = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, payer.getName());
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();
        }
    }
    

}
