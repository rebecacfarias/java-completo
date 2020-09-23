package funcionalLambda.entities;

public class Employee{
    private String name;
    private String email;
    private double salary;

    public Employee(String name, String email, double salary){
        setName(name);
        setEmail(email);
        setSalary(salary);
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }
    public double getSalary(){
        return this.salary; 
    }

    @Override 
    public String toString(){
        return String.format(" Name: %s, \n Email: %s, \n Salary: %.2f; \n", getName(),getEmail(),getSalary());
    }


}