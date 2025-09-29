package DAO;

import config.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao <T>{
    protected Database db;

    public GenericDao(Database db){
        this.db = db;
    }

    protected abstract T map(ResultSet rs) throws SQLException;

    protected abstract String getTableName();

    public void save(T t) throws  SQLException {
        throw new UnsupportedOperationException("implement 'update method' on child class");
    }

    public void update(T t) throws SQLException {
        throw new UnsupportedOperationException("implement 'update method' on child class");
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public T findById(int id) throws SQLException {
        String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return map(rs);
            }
        }
        return null;
    }

    public List<T> findAll() throws SQLException {
        List<T> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
        }
        return list;
    }


}
