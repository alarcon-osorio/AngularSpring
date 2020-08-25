package com.api.service;

import com.api.dao.PeliculaDAO;
import com.api.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly=true)
public class PeliculaServiceImpl implements PeliculaService{

    @Autowired
    private PeliculaDAO peliculaDAO;

    @Override
    @Transactional //Hace que haya transaccion en base de datos
    public long save(Pelicula pelicula) {
        return peliculaDAO.save(pelicula);
    }

    @Override
    public Pelicula get(long id) {
        return null;
    }

    @Override
    @Transactional
    public List<Pelicula> list() {
        return peliculaDAO.list();
    }

    @Override
    public void update(long id, Pelicula pelicula) {

    }

    @Override
    public void delete(long id) {

    }
}
