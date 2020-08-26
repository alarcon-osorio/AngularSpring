package com.api.dao;

import com.api.model.Pelicula;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.loader.plan.build.internal.returns.CollectionFetchableElementAnyGraph;
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
        return sessionFactory.getCurrentSession().get(Pelicula.class, id);
    }

    @Override
    public List<Pelicula> list() {
        List<Pelicula> lista = sessionFactory.getCurrentSession().createQuery("from Pelicula").list();
        return lista;
    }

    @Override
    public void update(long id, Pelicula pelicula) {
        Session session = sessionFactory.getCurrentSession();
        Pelicula oldPelicula = session.byId(Pelicula.class).load(id);
        oldPelicula.setTitulo(pelicula.getTitulo());
        oldPelicula.setSinopsis(pelicula.getSinopsis());
        oldPelicula.setGenero(pelicula.getGenero());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Pelicula pelicula = sessionFactory.getCurrentSession().byId(Pelicula.class).load(id);
        sessionFactory.getCurrentSession().delete(pelicula);
    }
}
