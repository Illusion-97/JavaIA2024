package jdbc.dao;

import jdbc.models.Personne;

import java.util.List;

public interface IPersonneDao {
    void createTable();

    boolean create(Personne personne);

    Personne findById(long id);

    List<Personne> findAll();

    boolean update(Personne personne);

    boolean delete(long id);
}
