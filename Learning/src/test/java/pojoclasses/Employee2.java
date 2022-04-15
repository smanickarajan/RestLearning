package pojoclasses;

import java.util.List;

public class Employee2 {
	private String name;
	private int id;
	private double sal;
	private boolean ismarried;
	private List<String> mobnos;
	private List<Address> user_address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public boolean isIsmarried() {
		return ismarried;
	}

	public void setIsmarried(boolean ismarried) {
		this.ismarried = ismarried;
	}

	public List<String> getMobnos() {
		return mobnos;
	}

	public void setMobnos(List<String> mobnos) {
		this.mobnos = mobnos;
	}

	public List<Address> getUser_address() {
		return user_address;
	}

	public void setUser_address(List<Address> user_address) {
		this.user_address = user_address;
	}

	

}
