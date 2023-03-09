package br.com.hotel1800.modelo;

public class Cargo {
	private Integer idcargos;
	private String cargo;
	private Integer salario;

	public Cargo(Integer idcargos, String cargo, Integer salario) {
		this.idcargos = idcargos;
		this.cargo = cargo;
		this.salario = salario;
	}

	public Cargo(String cargo, Integer salario) {
		this.cargo = cargo;
		this.salario = salario;
	}

	public Integer getIdcargos() {
		return idcargos;
	}

	public void setIdcargos(Integer idcargos) {
		this.idcargos = idcargos;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "ID Cargo: " + idcargos + "\n " + cargo + "\n Salário: " + salario+ "\n------";
	}


}
