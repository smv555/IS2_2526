package es.unican.is2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;


import java.util.LinkedList;
import java.util.List;

public class ClienteTest {

    @Test
    public void test() {
        Cliente c1 = new Cliente();
        c1.setDni("123456789A");
        c1.setNombre("Nombre1");
        c1.setMinusvalia(true);

        assertEquals(0, c1.getSeguros().size());

        assertEquals(0, c1.totalSeguros());


        Cliente c2 = new Cliente();
        c2.setDni("123456789B");
        c2.setNombre("Nombre2");
        c2.setMinusvalia(true);

        //Valor 600
        Seguro s1 = new Seguro();
        s1.setId(123);
        s1.setFechaInicio(LocalDate.now().minusYears(1).minusDays(1));
        s1.setCobertura(Cobertura.TERCEROS_LUNAS);
        s1.setPotencia(1);

        List<Seguro> listaSeguros2 = new LinkedList<Seguro>();
        listaSeguros2.add(s1);

        c2.setSeguros(listaSeguros2);

        assertEquals(1, c2.getSeguros().size());
        assertEquals(450, c2.totalSeguros());



        Cliente c3 = new Cliente();
        c3.setDni("123456789C");
        c3.setNombre("Nombre3");
        c3.setMinusvalia(true);


        //Precio = 840
        Seguro s2 = new Seguro();
        s2.setId(124);
        s2.setFechaInicio(LocalDate.now().minusDays(2));
        s2.setCobertura(Cobertura.TODO_RIESGO);
        s2.setPotencia(100);


        //Precio = 576
        Seguro s3 = new Seguro();
        s3.setId(125);
        s3.setFechaInicio(LocalDate.now());
        s3.setCobertura(Cobertura.TERCEROS_LUNAS);
        s3.setPotencia(2300);


        //Precio = 504
        Seguro s4 = new Seguro();
        s4.setId(126);
        s4.setFechaInicio(LocalDate.now());
        s4.setCobertura(Cobertura.TERCEROS_LUNAS);
        s4.setPotencia(110);

        List<Seguro> listaSeguros3 = new LinkedList<Seguro>();
        listaSeguros3.add(s1);
        listaSeguros3.add(s2);
        listaSeguros3.add(s3);
        listaSeguros3.add(s4);


        c3.setSeguros(listaSeguros3);

        assertEquals(4, c3.getSeguros().size());

        assertEquals(1890, c3.totalSeguros());


        Cliente c4 = new Cliente();
        c4.setDni("123456789D");
        c4.setNombre("Nombre4");
        c4.setMinusvalia(true);



        //Precio = 0
        Seguro s5 = new Seguro();
        s5.setId(127);
        s5.setMatricula("Matricula5");
        s5.setFechaInicio(LocalDate.now().plusDays(2));
        s5.setCobertura(Cobertura.TODO_RIESGO);
        s5.setPotencia(100);


        //Precio = 1200
        Seguro s6 = new Seguro();
        s6.setId(128);
        s6.setMatricula("Matricula6");
        s6.setFechaInicio(LocalDate.now().minusYears(1).minusDays(1));
        s6.setCobertura(Cobertura.TODO_RIESGO);
        s6.setPotencia(200);

        List<Seguro> listaSeguros4 = new LinkedList<Seguro>();
        for (int i = 0; i < 10; i++) {
            listaSeguros4.add(s5);
        }
        for (int i = 0; i < 4; i++) {
            listaSeguros4.add(s6);
        }
        for (int i = 0; i < 3; i++) {
            listaSeguros4.add(s1);
        }
        for (int i = 0; i < 2; i++) {
            listaSeguros4.add(s2);
        }
        for (int i = 0; i < 1; i++) {
            listaSeguros4.add(s3);
        }

        c4.setSeguros(listaSeguros4);
        assertEquals(20, c4.getSeguros().size());

        assertEquals(6642, c4.totalSeguros());



        Cliente c5 = new Cliente();
        c5.setDni("123456789E");
        c5.setNombre("Nombre5");
        c5.setMinusvalia(false);

        assertEquals(0, c5.getSeguros().size());

        assertEquals(0, c5.totalSeguros());



        Cliente c6 = new Cliente();
        c6.setDni("123456789F");
        c6.setNombre("Nombre6");
        c6.setMinusvalia(false);

        List<Seguro> listaSeguros6 = new LinkedList<Seguro>();
        listaSeguros6.add(s3);

        c6.setSeguros(listaSeguros6);

        assertEquals(1, c6.getSeguros().size());

        assertEquals(576, c6.totalSeguros());


        Cliente c7 = new Cliente();
        c7.setDni("123456789G");
        c7.setNombre("Nombre7");
        c7.setMinusvalia(false);

        //Precio = 320
        Seguro s7 = new Seguro();
        s7.setId(129);
        s7.setMatricula("Matricula7");
        s7.setFechaInicio(LocalDate.now().minusYears(1));
        s7.setCobertura(Cobertura.TERCEROS);
        s7.setPotencia(89);


        List<Seguro> listaSeguros7 = new LinkedList<Seguro>();
        listaSeguros7.add(s2);
        listaSeguros7.add(s7);
        listaSeguros7.add(s4);
        listaSeguros7.add(s1);


        c7.setSeguros(listaSeguros7);

        assertEquals(4, c7.getSeguros().size());

        assertEquals(2264, c7.totalSeguros());



        Cliente c8 = new Cliente();
        c8.setDni("123456789H");
        c8.setNombre("Nombre8");
        c8.setMinusvalia(false);


        List<Seguro> listaSeguros8 = new LinkedList<Seguro>();
        for (int i = 0; i < 5; i++) {
            listaSeguros8.add(s5);
        }
        for (int i = 0; i < 10; i++) {
            listaSeguros8.add(s7);
        }
        for (int i = 0; i < 2; i++) {
            listaSeguros8.add(s6);
        }
        for (int i = 0; i < 1; i++) {
            listaSeguros8.add(s2);
        }
        for (int i = 0; i < 1; i++) {
            listaSeguros8.add(s3);
        }
        for (int i = 0; i < 1; i++) {
            listaSeguros8.add(s4);
        }

        c8.setSeguros(listaSeguros8);
        assertEquals(20, c8.getSeguros().size());

        assertEquals(7520, c8.totalSeguros());



    }


}
