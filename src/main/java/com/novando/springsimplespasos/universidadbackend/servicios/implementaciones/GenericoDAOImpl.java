package com.novando.springsimplespasos.universidadbackend.servicios.implementaciones;

import com.novando.springsimplespasos.universidadbackend.servicios.contratos.GenericoDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericoDAOImpl <E, R extends CrudRepository<E, Integer>> implements GenericoDAO<E> {

    protected final R repository;

    public GenericoDAOImpl(R repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<E> findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public E save(E entidad) {
        return repository.save(entidad);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
