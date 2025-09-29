package DAO;

import config.Database;
import model.Bill;

import java.sql.*;

public class BillDao extends GenericDao<Bill>{
    public BillDao(Database db) {
        super(db);
    }

    @Override
    protected String getTableName(){
        return "bill";
    }

    @Override
    protected Bill map(ResultSet rs) throws SQLException {
        Bill bill = new Bill();
        bill.setId(rs.getInt("id"));
        bill.setTitle(rs.getString("title"));
        bill.setDescription(rs.getString("description"));
        bill.setAmount(rs.getBigDecimal("amount"));
        return bill;
    }

    @Override
    public void save(Bill bill) throws SQLException{
        String query = "INSERT INTO bill(title, description, amount)"
                        + "values (?,?,?)";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, bill.getTitle());
            stmt.setString(2, bill.getDescription());
            stmt.setBigDecimal(3, bill.getAmount());
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                bill.setId(keys.getInt(1));
            }
        }

    }

    @Override
    public void update(Bill bill) throws SQLException {
        String query = "UPDATE bill SET title = ?, description = ?, amount = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, bill.getTitle());
            stmt.setString(2, bill.getDescription());
            stmt.setBigDecimal(3, bill.getAmount());
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();
        }
    }
}
