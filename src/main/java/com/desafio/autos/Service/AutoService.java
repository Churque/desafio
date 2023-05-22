package com.desafio.autos.Service;

import com.desafio.autos.Model.Auto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class AutoService {

    private final List<Auto> autos = new ArrayList<>();
    private final Random random = new Random();
    private final List<String> marcas = Arrays.asList("Marca_1", "Marca_2", "Marca_3", "Marca_4", "Marca_5");
    private final List<String> colores = Arrays.asList("Rojo", "Azul", "Verde", "Blanco", "Negro");
    private final List<String> tipos = Arrays.asList("Sedan", "Camioneta", "SUV");
    private final List<String> motoresSedan = Arrays.asList("1.4cc", "1.6cc", "2.0cc");
    private final List<String> motoresCamioneta = Arrays.asList("2.4cc", "3.0cc", "4.0cc");
    private final List<String> motoresSUV = Arrays.asList("1.8cc", "2.2cc", "2.8cc");

    public List<Auto> generarAutos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Auto auto = new Auto();
            auto.setId(1);
            auto.setMarca(obtenerElementoAleatorio(marcas));
            auto.setAño(obtenerAñoAleatorio());
            auto.setColor(obtenerElementoAleatorio(colores));
            auto.setPrecio(obtenerPrecioAleatorio());
            auto.setTurbo(obtenerBooleanAleatorio());
            auto.setTipo(obtenerElementoAleatorio(tipos));
            auto.setMotor(obtenerMotorAleatorio(auto.getTipo()));
            if (auto.getTipo().equals("Camioneta")) {
                auto.setCabinas(obtenerCabinasAleatorio());
            }
            if (auto.getTipo().equals("SUV")) {
                auto.setSunroof(obtenerBooleanAleatorio());
            }
            auto.setPopularidad(0);
            autos.add(auto);
        }
        return autos;
    }

    public List<Auto> getAllAutos() {
        return autos;
    }

    private <T> T obtenerElementoAleatorio(List<T> lista) {
        return lista.get(random.nextInt(lista.size()));
    }

    private int obtenerAñoAleatorio() {
        return random.nextInt(9) + 2015;
    }

    private int obtenerPrecioAleatorio() {
        return random.nextInt(23000001) + 8000000;
    }

    private boolean obtenerBooleanAleatorio() {
        return random.nextBoolean();
    }

    private String obtenerMotorAleatorio(String tipo) {
        if (tipo.equals("Sedan")) {
            return obtenerElementoAleatorio(motoresSedan);
        } else if (tipo.equals("Camioneta")) {
            return obtenerElementoAleatorio(motoresCamioneta);
        } else if (tipo.equals("SUV")) {
            return obtenerElementoAleatorio(motoresSUV);
        }
        return "0.0cc";
    }

    private int obtenerCabinasAleatorio() {
        return random.nextInt(2) + 1;
    }

    public List<Auto> filtrarPorPrecio(int precio, String opcionFiltrado) {
        List<Auto> autosFiltrados = new ArrayList<>();
        for (Auto auto : autos) {
            if (opcionFiltrado.equals("menor") && auto.getPrecio() < precio) {
                autosFiltrados.add(auto);
            } else if (opcionFiltrado.equals("mayor") && auto.getPrecio() > precio) {
                autosFiltrados.add(auto);
            }
        }

        return autosFiltrados;
    }

    public void eliminarAutos() {
        autos.clear();
    }
}
