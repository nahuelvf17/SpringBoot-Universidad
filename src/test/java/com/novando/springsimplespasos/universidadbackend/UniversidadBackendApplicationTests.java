package com.novando.springsimplespasos.universidadbackend;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UniversidadBackendApplicationTests {

	Calculadora calculadora = new Calculadora();


	@Test
	@DisplayName("Suma de valores a y b")
	void sumaDeValores() {
		// GIVEN
		int valor_a=2;
		int valor_b=3;
		//WHEN
		int expectativa = calculadora.sumar(valor_a, valor_b);

		// THEN
		int resultadoEsperado=5;

		assertThat(expectativa).isEqualTo(resultadoEsperado);
	}

	@Test
	@DisplayName("Test deprecado")
	@Disabled("Test deprecado")
	void testDesactivado(){

	}

	class Calculadora{
		int sumar(int valor_a, int valor_b){
			return valor_a+valor_b;
		}
	}



}
