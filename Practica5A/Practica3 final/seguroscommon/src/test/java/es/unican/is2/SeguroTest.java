package es.unican.is2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;


public class SeguroTest {

    @Test
    public void test() {
    Seguro s = new Seguro();
    s.setId(123);
    s.setMatricula("Matricula1");
    s.setFechaInicio(LocalDate.now().plusDays(2));
    s.setCobertura(Cobertura.TODO_RIESGO);
    s.setPotencia(100);

    double valor = s.precio();

    assertEquals(0, s.precio());

    s.setFechaInicio(LocalDate.now().plusDays(1));
    s.setCobertura(Cobertura.TODO_RIESGO);
    s.setPotencia(100);

    assertEquals(0, s.precio());


    s.setFechaInicio(LocalDate.now().plusDays(1));
    s.setCobertura(Cobertura.TODO_RIESGO);
    s.setPotencia(100);

    assertEquals(0, s.precio());

    s.setFechaInicio(LocalDate.now().minusDays(2));
    s.setCobertura(Cobertura.TODO_RIESGO);
    s.setPotencia(100);

    assertEquals(840, s.precio());

    s.setFechaInicio(LocalDate.now().minusMonths(6));
    s.setCobertura(Cobertura.TODO_RIESGO);
    s.setPotencia(100);

    assertEquals(840, s.precio());


    s.setFechaInicio(LocalDate.now().minusYears(2));
    s.setCobertura(Cobertura.TERCEROS_LUNAS);
    s.setPotencia(45);

    assertEquals(600, s.precio());

    s.setFechaInicio(LocalDate.now().minusYears(1).minusDays(1));
    s.setCobertura(Cobertura.TERCEROS_LUNAS);
    s.setPotencia(1);

    assertEquals(600, s.precio());

    s.setFechaInicio(LocalDate.now().minusYears(1));
    s.setCobertura(Cobertura.TERCEROS);
    s.setPotencia(89);

    assertEquals(320, s.precio());


    s.setFechaInicio(LocalDate.now());
    s.setCobertura(Cobertura.TODO_RIESGO);
    s.setPotencia(90);

    assertEquals(840, s.precio());

    s.setFechaInicio(LocalDate.now());
    s.setCobertura(Cobertura.TERCEROS_LUNAS);
    s.setPotencia(110);

    assertEquals(504, s.precio());

    s.setFechaInicio(LocalDate.now().minusYears(2));
    s.setCobertura(Cobertura.TERCEROS);
    s.setPotencia(111);

    assertEquals(480, s.precio());

    s.setFechaInicio(LocalDate.now().minusYears(1).minusDays(1));
    s.setCobertura(Cobertura.TODO_RIESGO);
    s.setPotencia(200);

    assertEquals(1200, s.precio());

    s.setFechaInicio(LocalDate.now());
    s.setCobertura(Cobertura.TERCEROS_LUNAS);
    s.setPotencia(2300);

    assertEquals(576, s.precio());

    s.setFechaInicio(LocalDate.now().plusMonths(10));
    s.setCobertura(Cobertura.TERCEROS);
    s.setPotencia(45);

    assertEquals(0, s.precio());

    s.setFechaInicio(LocalDate.now().plusYears(4));
    s.setCobertura(Cobertura.TERCEROS_LUNAS);
    s.setPotencia(120);

    assertEquals(0, s.precio());




    // Casos no validos

    
    Seguro s2 = new Seguro();
    s2.setId(321);
    s2.setMatricula("Matricula2");
    s2.setFechaInicio(LocalDate.now().plusDays(2));
    s2.setCobertura(null);
    s2.setPotencia(100);

    assertThrows(NullPointerException.class,
			() -> s2.precio());
    

    s2.setFechaInicio(LocalDate.now().plusDays(1));
    s2.setCobertura(Cobertura.TODO_RIESGO);
    s2.setPotencia(-2);

    
	assertThrows(PotenciaNoValidaException.class,
			() -> s2.precio());
    }

}
