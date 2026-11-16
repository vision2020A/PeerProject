public class Employee{
    int id;
    String name;
    String department;
    double salary;
    public Employee(int id, String name, String department, double salary){
        this.id=id;
        this.name=name;
        this.department = department;
        this.salary=salary;
    }
    public int getId(){//temp
        return 1;
    }
    public String getEmployeeDetails(){
        return "";
    }
    public double getSalary(){
        return 0.0;
    }
    public double calculateBonus(){
        return 0.0;
    }
    public String getDepartment(){
        return "";
    }
    public void giveRaise(double percent){
    }
}
