package jdbc.dao;

import jdbc.DbConnection;
import jdbc.models.Personne;
import jdbc.models.Role;

import java.sql.PreparedStatement;
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
            e.printStackTrace(System.out);
        }
    }

    @Override
    public boolean create(Personne personne) {
        try (PreparedStatement ps = DbConnection.getInstance().prepareStatement(
                // Dans un PreparedStatement, les ? sont des emplacements pour des valeurs
                "INSERT INTO personne(version,nom,prenom,role) VALUES(?,?,?,?)")) {
            ps.setInt(1,personne.getVersion());
            ps.setString(2, personne.getNom());
            ps.setString(3, personne.getPrenom());
            ps.setString(4, personne.getRole().name());
            ps.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
            return false;
        }
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
        Personne yanis = new Personne("ADEKALOM","Yanis", Role.CLIENT);
        personneDao.create(yanis);
        System.out.println("yanis.getId() = " + yanis.getId());
    }
}
