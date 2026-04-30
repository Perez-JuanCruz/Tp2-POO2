package empresatest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Empresa;
import clases.Permanente;
import clases.ReciboDeHaberes;
import clases.Temporaria;

public class EmpresaTest {
	private Permanente empPermanente;
    private Temporaria empTemporaria;
    private Empresa miEmpresa;

    @BeforeEach
    void setUp() {
        // Sueldo Basico: 100000 | Hijos: 2 | Antigüedad: 5
        empPermanente = new Permanente(
            "Juan Pérez", "Calle Falsa 123", true, 
            LocalDate.of(1980, 5, 15), 100000, 2, 5
        );


        // Sueldo Basico: 80000 | Horas Extra: 10
        empTemporaria = new Temporaria(
            "María Gómez", "Avenida Siempre Viva 742", false, 
            LocalDate.of(1995, 8, 20), 80000, 10, LocalDate.of(2026, 12, 31)
        );

        miEmpresa = new Empresa("Tech Solutions", 301122334, Arrays.asList(empPermanente, empTemporaria));
    }

    @Test
    void calculoTotalSueldosNetos() {
        double totalNetoEsperado = 139717.5;
        
        assertEquals(totalNetoEsperado, miEmpresa.getSueldosNetos());
    }

    @Test
    void liquidacionDeSueldos() {
        miEmpresa.liquidarSueldos();
    
        assertNotNull(miEmpresa.getRecibosDeHaberes());
        
        assertEquals(2, miEmpresa.getRecibosDeHaberes().size());
        
        ReciboDeHaberes reciboJuan = miEmpresa.getRecibosDeHaberes().get(0);
        
        assertEquals("Juan Pérez", reciboJuan.getNombreEmpleado());
        
        assertFalse(reciboJuan.getDesgloseConceptos().isEmpty());
        
        assertEquals(4, reciboJuan.getDesgloseConceptos().size());
    }
}
