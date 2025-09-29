package controller;

import dao.GenericDao;

import java.sql.SQLException;
import java.util.List;

public abstract class GenericController <T>{
    protected GenericDao<T> dao;

    public GenericController(GenericDao<T> dao) {
        this.dao = dao;
    }

    public void save(T t) throws SQLException {
        dao.save(t);
    }

    public void update(T t) throws SQLException {
        dao.update(t);
    }

    public void delete(int id) throws SQLException {
        dao.delete(id);
    }

    public T findById(int id) throws SQLException {
        return dao.findById(id);
    }

    public List<T> findAll() throws SQLException  {
        return dao.findAll();
    }
}
