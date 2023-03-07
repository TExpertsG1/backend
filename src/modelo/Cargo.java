package modelo;

public class Cargo {
	private int idcargos;
	private String cargo;
	private double salario;

	public Cargo(int idcargos, String cargo, double salario) {
		this.idcargos = idcargos;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public Cargo(String cargo, double salario) {
		this.cargo = cargo;
		this.salario = salario;
	}
	

	public String getCargo() {
		return cargo;
	}
	
	public double getSalario() {
		return salario;
	}

	public int getIdcargos() {
		return idcargos;
	}

	public void setIdcargos(int idcargos) {
		this.idcargos = idcargos;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "ID Cargo: " + idcargos + "\n " + cargo + "\n Salário: " + salario+ "\n------";
	}


}
