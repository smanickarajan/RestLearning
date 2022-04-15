package ConvertResponsetoPojo;

public class NestedJsonPojo {
private String name;
private int id;
private double sal;
private boolean ismarried;
private Address address;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
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

public boolean isIsmarried() {
	return ismarried;
}

public void setIsmarried(boolean ismarried) {
	this.ismarried = ismarried;
}

public void setSal(double sal) {
	this.sal = sal;
}


}
