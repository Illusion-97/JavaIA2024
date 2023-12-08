package jdbc.dao;

import jdbc.models.Personne;

import java.util.List;

public class PersonneDao implements IPersonneDao {
    @Override
    public void createTable() {

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
}
