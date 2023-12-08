package jdbc.dao;

import jdbc.DbConnection;
import jdbc.models.Personne;
import jdbc.models.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                "INSERT INTO personne(version,nom,prenom,role) VALUES(?,?,?,?)",
                // Demande Explicitement au SGBD de retourner l'information de la clé générée
                Statement.RETURN_GENERATED_KEYS)) {
            // Des méthodes sont prévues dans PreparedStatement pour placer les valeurs en évitant l'injection SQL
            ps.setInt(1,personne.getVersion());
            ps.setString(2, personne.getNom());
            ps.setString(3, personne.getPrenom());
            ps.setString(4, personne.getRole().name());
            ps.execute();
            // ResultSet permet de récupérer le retour d'une requête SQL
            ResultSet rs = ps.getGeneratedKeys(); // Récupère l'id auto généré (via AUTO_INCREMENT)
            if(rs.next()) { // Je me place sur la premiere ligne de la réponse à ma requête (s'il y en a bien une)
                personne.setId(rs.getLong(1)); // Je récupère la valeur de la première colonne dans un type long
            }
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    @Override
    public Personne findById(long id) {
        Personne personne = null;
        try (PreparedStatement ps = DbConnection.getInstance().prepareStatement(
                "SELECT * FROM Personne WHERE id = ?"
        )) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            personne = mapResultToPersonne(rs);
        } catch (SQLException| ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
        return personne;
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

    public Personne mapResultToPersonne(ResultSet rs) {
        try {
            return rs == null
                    ? null
                    : new Personne(
                    rs.getLong("id"),
                    rs.getInt("version"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    Role.valueOf(rs.getString("role"))
            );
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public static void main(String[] args) {
        IPersonneDao personneDao = new PersonneDao();
        personneDao.createTable();
        Personne yanis = new Personne(0,0,"ADEKALOM","Yanis", Role.CLIENT);
        personneDao.create(yanis);
        System.out.println("yanis.getId() = " + yanis.getId());
    }
}
