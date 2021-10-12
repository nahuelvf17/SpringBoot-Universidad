package com.novando.springsimplespasos.universidadbackend.servicios.implementaciones;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.novando.springsimplespasos.universidadbackend.datos.DatosDummy;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Carrera;
import com.novando.springsimplespasos.universidadbackend.repositorios.CarreraRepository;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.CarreraDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarreraDAOImplTest {

    CarreraDAO carreraDAO;
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp(){
        carreraRepository = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImpl(carreraRepository);
    }

    @Test
    void findCarrerasByNombreContains() {
        // GIVEN
        String nombre = "Ingenieria";
        when(carreraRepository.findCarrerasByNombreContains(nombre)).
                thenReturn(Arrays.asList(
                        DatosDummy.carrera01(true),
                        DatosDummy.carrera03(true)));

        // WHEN

        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);

        //THEN

        assertThat(expected.get(0).equals(DatosDummy.carrera01(true)));
        assertThat(expected.get(1).equals(DatosDummy.carrera03(true)));

        verify(carreraRepository).findCarrerasByNombreContains(nombre);

    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase() {
        // GIVEN
        String nombre = "ingenieria";
        when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre)).
                thenReturn(Arrays.asList(
                        DatosDummy.carrera01(true),
                        DatosDummy.carrera03(true)));

        // WHEN

        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);

        //THEN

        assertThat(expected.get(0).equals(DatosDummy.carrera01(true)));
        assertThat(expected.get(1).equals(DatosDummy.carrera03(true)));

        verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Test
    void findCarrerasByCantidadAniosAfter() {
        // GIVEN
        int cantidad = 4;
        when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidad)).
                thenReturn(Arrays.asList(
                        DatosDummy.carrera01(true),
                        DatosDummy.carrera03(true)));

        // WHEN

        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidad);

        //THEN

        assertThat(expected.get(0).equals(DatosDummy.carrera01(true)));
        assertThat(expected.get(1).equals(DatosDummy.carrera03(true)));

        verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidad);
    }
}