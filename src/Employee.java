import java.util.*;
public class Employee
{
    private int id;
    private String name;
    private String department;
    private double salary=0;
    private double performanceRating;
    Employee(int id, String name, String department, double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.performanceRating = 3;
    }
    //performanceRating
    void adjustStats(double performanceRatingChange){
        this.performanceRating = Math.clamp(this.performanceRating+performanceRatingChange,1,5);
    }
    //getters
    int getId(){
        return this.id;
    }
    String getName(){
        return this.name;
    }
    String getDepartment(){
        return this.department;
    }
    public double getSalary(){
        return this.salary;
    }
    public double getPerformanceRating(){
        return this.performanceRating;
    }
    //seters
    public void setDepartment(String department){
        this.department = department;
    }
    public void setSalary(double salary){
        if(salary>0){
            this.salary = salary;
        }
        else{
            System.out.println("Cant have negative salary!");
        }
    }
    public void setPerformanceRating(double performanceRating){
        if(performanceRating >= 1 && performanceRating <= 5){
            this.performanceRating = performanceRating;
        }
        else{
            System.out.println("ERR, rating is out of bounds");
        }
    }
    //part 2
    public void giveRaise(double percentage){
        if(percentage > 0){
        salary+=(salary*(percentage/100));
        System.out.println("Their salary is now" + salary);
        }
        else{
            System.out.println("ERR, Raise cant be negative");
        }
    }
    public void giveRaise(double percentage, String newDepartment){
        Scanner sc = new Scanner(System.in);
        if(percentage > 0){
            salary+=(salary*(percentage/100));
            System.out.print("Enter a department: ");
            newDepartment = sc.nextLine();
            System.out.println("Your Employee is now in the" + newDepartment + "department");
            System.out.println("Their salary is now" + salary);
       
        }
        else{
            System.out.println("Raise cant be negative");
        }
    }
    public double calculateBonus(){
        if (performanceRating >= 4.5){
            return salary*0.15;
        }
        if(performanceRating >= 3.5){
            return salary*0.08;
        }
        else{
            return salary*0.02;
        }
    }
    public String getEmployeeDetails(){
        return ("ID:" + id + " | Name: " + name +" | Department: " + department + " | Salary: " + salary + " | Rating:" + performanceRating +"/5.0");
    }
}
