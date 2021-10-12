package com.novando.springsimplespasos.universidadbackend;

import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Alumno;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Direccion;
import com.novando.springsimplespasos.universidadbackend.modelo.entidades.Persona;
import com.novando.springsimplespasos.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniversidadBackendApplication {


	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();
		/*for (String str: beanDefinitionNames) {
			System.out.println(str);
		}*/
	}

	@Bean
	public CommandLineRunner runner(){
		return args-> {
			/*
			Direccion direccion = new Direccion("San Jose", "1243", "1630", "", "", "Cabildo");
			Persona alumno = new Alumno(null, "Martin", "Romero", "32554667",direccion);
			Persona save =  servicio.save(alumno);
			System.out.println(save.toString());
			 */
			/*
			List<Persona> alumnos = (List<Persona>) servicio.findAll();
			alumnos.forEach(System.out::println);*/

		};
	}
}
