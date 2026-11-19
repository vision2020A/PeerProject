import java.util.Scanner;

public class EMSMainDriver{
    //worked on by ALEXANDER SIGNORE THE GREAT

    static void main(String[] args){
        ManagementSystem company = new ManagementSystem("TechCorp",20);
        Employee blankEmployee;
        boolean run = true;
        String temp;
        String temp2;
        Scanner sc = new Scanner(System.in);
        int tempInt;
        int tempInt2;
        System.out.println("Welcome to the "+company.companyName+" Manager.\nThis Manager will allow easy establishment of the "+company.companyName+" database.\nHope this is convenient, and remember the motto!");
        String format = "\u001B[1;3;31m";
        String end = "\u001B[0m";
        System.out.println(format+"Investors before clients!"+end);
        company.EmplTest();
        while(run) {
            options();
            switch (getSafeNum()) {
                case 1:
                    try {
                        System.out.println("Please enter Employee's name");
                        temp = sc.nextLine();
                        System.out.println("Please enter Employee's ID(Not 0)");
                        tempInt = getSafeNum();
                        if (tempInt == 0) {
                            System.out.println("Bro. Not cool");
                            tempInt = 4;
                        }
                        System.out.println("Please enter Employee's Department");
                        temp2 = sc.nextLine();
                        System.out.println("Please enter Employee's Salary");
                        tempInt2 = getSafeNum();
                        blankEmployee = new Employee(tempInt, temp, temp2, tempInt2);
                        company.addEmployee(blankEmployee);
                    }catch(Exception e){
                        System.out.println("ERR, invalid input.");
                    }
                    break;
                case 2:
                    company.displayAllEmployees();
                    break;
                case 3:
                    System.out.println("Enter Employee ID");
                    System.out.println(company.searchEmployee(getSafeNum()).getEmployeeDetails());
                    break;
                case 4:
                    System.out.println("Enter Employee ID");
                    try{
                        tempInt = sc.nextInt();
                        System.out.println("Enter raise percentage");
                        tempInt2 = sc.nextInt();
                        System.out.println("Whats their new department? (old department was "+company.searchEmployee(tempInt).getDepartment());

                        company.searchEmployee(tempInt).giveRaise(tempInt2);
                    }catch(Exception e){
                        System.out.println("ERR, that isn't a valid ID buddy o pal.");
                    }
                    break;
                case 5:
                    System.out.println("What is your employee's ID?");
                    try{
                        company.removeEmployee(sc.nextInt());
                    }catch(Exception e){
                        System.out.println("ERR, invalid input");}
                    break;
                case 6:
                    System.out.println("The total cash that the company spends on employees is "+((Math.round(10*company.calculateTotalPayroll())/10)));
                    break;
                case 7:
                    run=false;
                    System.out.println("Shutting down");
                    break;
                default:
                    System.out.println("ERR, invalid input. Please put a number from 1-7!");
            }
        }
    }
    private static void options(){
        System.out.println("1. Add New Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee by ID");
        System.out.println("4. Apply Raise / Promotion)");
        System.out.println("5. Remove Employee");
        System.out.println("6. Display Total Company Payroll & Bonus Analytics");
        System.out.println("7. Exit System");
    }
    private static int getSafeNum(){
        Scanner sc = new Scanner(System.in);
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("ERR, Invalid input. Please enter a integer next time.");
                return 0;
            }
    }
}
