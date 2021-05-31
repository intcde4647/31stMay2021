package com.model;

public class Employee {
   private String empId;
   private String name;
   private String desig;
   private String dept;
   private int basic;
   private float hra;
   
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(String empId, String name, String desig, String dept, int basic, float hra) {
	super();
	this.empId = empId;
	this.name = name;
	this.desig = desig;
	this.dept = dept;
	this.basic = basic;
	this.hra = hra;
}
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesig() {
	return desig;
}
public void setDesig(String desig) {
	this.desig = desig;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public int getBasic() {
	return basic;
}
public void setBasic(int basic) {
	this.basic = basic;
}
public float getHra() {
	return hra;
}
public void setHra(float hra) {
	this.hra = hra;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + basic;
	result = prime * result + ((dept == null) ? 0 : dept.hashCode());
	result = prime * result + ((desig == null) ? 0 : desig.hashCode());
	result = prime * result + ((empId == null) ? 0 : empId.hashCode());
	result = prime * result + Float.floatToIntBits(hra);
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (basic != other.basic)
		return false;
	if (dept == null) {
		if (other.dept != null)
			return false;
	} else if (!dept.equals(other.dept))
		return false;
	if (desig == null) {
		if (other.desig != null)
			return false;
	} else if (!desig.equals(other.desig))
		return false;
	if (empId == null) {
		if (other.empId != null)
			return false;
	} else if (!empId.equals(other.empId))
		return false;
	if (Float.floatToIntBits(hra) != Float.floatToIntBits(other.hra))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", name=" + name + ", desig=" + desig + ", dept=" + dept + ", basic=" + basic
			+ ", hra=" + hra + "]";
}
   
}
