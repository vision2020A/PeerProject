import java.util.*;
public class Employee
{
    //scanner
    public static void main(String[] args) {
    Scanner department = new Scanner(System.in);
    //other
    private int id;
    private String name;
    private String department;
    private double salary;
    private double performanceRating = 3;
    //constructor
    public Employee(int id, String name, String department, double salary, double performanceRating){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.performanceRating = performanceRating;
    }
    //performanceRating
    private void adjustStats(double performanceRatingChange){
        this.performanceRating = Math.clamp(this.performanceRating+performanceRatingChange,1,5);
    }
    //getters
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getDepartment(){
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
            System.out.println("error rating is out of bounds");
        }
    }
    //part 2
    public void giveRaise(double percentage){
        if(percentage > 0){
        salary+=(salary(percentage/100));
        System.out.println("the salary is now" + salary);
        }
        else{
            System.out.println("raise cant be negative");
        }
    }
    public void giveRaise(double percentage, String newDepartment){
        if(percentage > 0){
            salary+=(salary(percentage/100));
            System.out.print("Enter a department: ");
            String newDepartment = department.nextInt();
            System.out.println("your Employee is now in the" + newDepartment + "department")
            System.out.println("the salary is now" + salary);
       
        }
        else{
            System.out.println("raise cant be negative");
        }
    }
    public double calculateBonus(){
        if (performanceRating >= 4.5){
            return salary*0.15
        }
        if(performanceRating >= 3.5){
            return salary*0.08
        }
        else(){
            return salary*0.02
        }
    }
    public string getEmployeeDetails(){
        return ("ID:" + id + " | Name: " + name " | Department: " + department + " | Salary: " + salary + " | Rating:" + performanceRating "/5.0")
    }
}
