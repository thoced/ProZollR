package Dao;

import Models.UpdateDBException;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
    public void Create() throws SQLException;
    public void Insert() throws SQLException;
    public void Update() throws SQLException, UpdateDBException;
    public void Delete() throws SQLException, UpdateDBException;
    public List<T> Select(String args) throws SQLException;

}
