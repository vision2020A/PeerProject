import java.util.Scanner;

public class EMSMainDriver{
    //worked on by ALEXANDER SIGNORE THE GREAT

    static void main(String[] args){
        ManagementSystem company = new ManagementSystem("TechCorp",20);
        Employee blankEmployee = new Employee(0,"null","null",0);
        boolean run = true;
        String temp = "";
        String temp2 = "";
        Scanner sc = new Scanner(System.in);
        int tempInt = 0;
        int tempInt2 = 0;
        System.out.println("Welcome to the "+company.companyName+" Manager.\nThis Manager will allow easy establishment of the "+company.companyName+" database.\nHope this is convienient, and remember the motto!");
        String format = "\u001B[1;3;31m";
        String end = "\u001B[0m";
        System.out.println(format+"Investors before clients!"+end);
        while(run) {
            options();
            switch (getSafeNum()) {
                case 1:
                    System.out.println("Please enter Employee's name.");
                    temp=sc.nextLine();
                    System.out.println("Please enter Employee's ID.(Not 0)");
                    tempInt = getSafeNum();
                    if(tempInt==0){
                        System.out.println("Bro. Not cool");
                        tempInt=1;
                    }
                    System.out.println("Please enter Employee's Department.");
                    temp2 = sc.nextLine();
                    System.out.println("Please enter Employee's Salary.");
                    company.addEmployee(blankEmployee);
                    break;
                case 2:
                    company.displayAllEmployees();
                    break;
                case 3:
                    System.out.println("Enter Employee ID");
                    company.searchEmployee(getSafeNum());
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
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
