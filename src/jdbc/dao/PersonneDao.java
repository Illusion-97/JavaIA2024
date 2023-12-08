package jdbc.dao;

import jdbc.DbConnection;
import jdbc.models.Personne;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonneDao implements IPersonneDao {
    @Override
    public void createTable() {
        // Statement représente une requête envoyée au SGBD
        try (Statement statement = DbConnection.getInstance().createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS personne(id INT(10) NOT NULL AUTO_INCREMENT, version INT(10), nom VARCHAR(20), prenom VARCHAR(20), role VARCHAR(15), PRIMARY KEY ( id )) ";
            statement.execute(sql);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean create(Personne personne) {
        return false;
    }

    @Override
    public Personne findById(long id) {
        return null;
    }

    @Override
    public List<Personne> findAll() {
        return null;
    }

    @Override
    public boolean update(Personne personne) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    public static void main(String[] args) {
        IPersonneDao personneDao = new PersonneDao();
        personneDao.createTable();
    }
}
