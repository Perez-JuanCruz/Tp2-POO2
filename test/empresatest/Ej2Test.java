package empresatest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Contratado;
import clases.Empresa;
import clases.ReciboDeHaberes;

public class Ej2Test {
	private Contratado empContratado;
    private Empresa miEmpresa;

    @BeforeEach
    void setUp() {
        // Sueldo Básico: 50000 | Nro Contrato: 1010 | Medio: Transferencia
        empContratado = new Contratado(
            "Luis Gomez", "Avenida Siempre Viva 742", false, 
            LocalDate.of(1992, 4, 10), 50000, 1010, "Transferencia"
        );

        miEmpresa = new Empresa("Agencia Creativa", 305544332, Arrays.asList(empContratado));
    }

    @Test
    void calculosSueldoContratado() {

        assertEquals(50000, empContratado.getSueldoBruto());

        assertEquals(50.0, empContratado.getRetenciones());

        assertEquals(49950.0, empContratado.getSueldoNeto());
    }

    @Test
    void desgloseContratado() {
        List<String> desglose = empContratado.getDesglose();
        
        assertEquals(2, desglose.size());
        
        assertTrue(desglose.get(0).contains("Sueldo Básico: $50000"));
        assertTrue(desglose.get(1).contains("Gastos Administrativos: -$50"));
    }

    @Test
    void liquidacionEmpresaConContratado() {
        miEmpresa.liquidarSueldos();
        
        List<ReciboDeHaberes> recibos = miEmpresa.getRecibosDeHaberes();
        
        assertEquals(1, recibos.size());
        
        ReciboDeHaberes reciboLuis = recibos.get(0);
        
        assertEquals("Luis Gomez", reciboLuis.getNombreEmpleado());
        assertEquals(2, reciboLuis.getDesgloseConceptos().size());
    }
}
