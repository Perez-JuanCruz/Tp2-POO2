package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contratado extends Empleado{
	
	private int nroContrato;
	
	private String medioDePago;
	
	public Contratado(String nombre, String direccion, boolean estadoCivil, LocalDate nacimiento, int sueldoBasico, int nroContrato, String medioPago) {
		super(nombre, direccion, estadoCivil, nacimiento, sueldoBasico);
		this.medioDePago = medioPago;
		this.nroContrato = nroContrato;
	}

	public int getNroContrato() {
		return nroContrato;
	}

	public String getMedioDePago() {
		return medioDePago;
	}
	
	private int gastosAdministrativosContractuales() {
		return 50;
	}
	
	@Override
	public double getRetenciones() {
		return this.gastosAdministrativosContractuales();
	}
	
	@Override
	protected double obraSocial() {
		return 0;
	}
	
	@Override
	protected double aportesJubilatorios() {
		return 0;
	}
	
	@Override
	public List<String> getDesglose(){
		List<String> desglose = new ArrayList<>();
	    desglose.add("Sueldo Básico: $" + this.getSueldoBasico());
	    desglose.add("Gastos Administrativos: -$" + this.gastosAdministrativosContractuales());
	    
	    return desglose;
	}
}
