package clases;

import java.time.LocalDate;
import java.util.List;

public class ReciboDeHaberes {
    private String nombreEmpleado;
    private String direccion;
    private LocalDate fechaEmision;
    private int sueldoBruto;
    private double sueldoNeto;
    private List<String> desgloseConceptos; 

    public ReciboDeHaberes(Empleado empleado) {
        this.nombreEmpleado = empleado.getNombre();
        this.direccion = empleado.getDireccion();
        this.fechaEmision = LocalDate.now();
        this.sueldoBruto = empleado.getSueldoBruto();
        this.sueldoNeto = empleado.getSueldoNeto();
        this.desgloseConceptos = empleado.getDesglose();
    }

	public List<String> getDesgloseConceptos() {
		return desgloseConceptos;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
}
