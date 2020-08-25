package com.api.service;

import com.api.dao.PeliculaDAO;
import com.api.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    @Autowired
    private PeliculaDAO peliculaDAO;

    @Override
    public long save(Pelicula pelicula) {
        return 0;
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
