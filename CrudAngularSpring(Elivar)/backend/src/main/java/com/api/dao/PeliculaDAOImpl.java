package com.api.dao;

import com.api.model.Pelicula;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeliculaDAOImpl implements PeliculaDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Pelicula pelicula) {
        sessionFactory.getCurrentSession().save(pelicula);
        return pelicula.getId();
    }

    @Override
    public Pelicula get(long id) {
        return null;
    }

    @Override
    public List<Pelicula> list() {
        List<Pelicula> lista = sessionFactory.getCurrentSession().createQuery("from Pelicula").list();
        return lista;
    }

    @Override
    public void update(long id, Pelicula pelicula) {

    }

    @Override
    public void delete(long id) {

    }
}
