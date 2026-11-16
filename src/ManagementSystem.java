public class ManagementSystem{
    //worked on by ALEXANDER SIGNORE THE GREAT
    private Employee[] employeeArray;
    private int count;
    final String companyName;
    public ManagementSystem(String companyName, int maxEmployees){//constructor for a new management system obj
        this.companyName = companyName;
        Employee[] employeeArray = new Employee[maxEmployees];
        count=0;
    }
    public boolean addEmployee(Employee emp){//if provided employee, will add that employee to system unless it is a duplicate.
        if(count>=employeeArray.length)
            return false;
        for(int i = 0;i<count;i++){
            if(emp.getId()==employeeArray[i].getId())
                return false;

        }
        employeeArray[count]=emp;
        count++;
        return true;
    }
    public boolean removeEmployee(int id){//removes employee with matching ID
        int depth= -1;
        for(int i = 0;i<=count;i++){
            if(employeeArray[i].getId()==id){
                depth=i;
                employeeArray[i]=null;
                count--;
                break;
            }
        }
        if(depth==-1)//if employee with that id doesn't exist, do nothing.
            return false;
        else{
            for(int Depth=depth;Depth<=count;Depth++){//{1,2,3,4,5} 2 {1,null,3,4,5} 1,3,4,5
                employeeArray[Depth]=employeeArray[Depth+1];
            }
        }
        return true;
    }
    public Employee searchEmployee(int id){
        for(int i = 0;i<count;i++){
            if(employeeArray[i].getId()==id)
                return employeeArray[i];
        }
        return null;
    }
    public void displayAllEmployees(){
        if(count==0){
            System.out.println("No employee records exist. Try adding some before retrying.");
        }
        else {
            for (int i = 0; i < count; i++) {
                System.out.println(employeeArray[i].getEmployeeDetails());
            }
        }
    }
    public double calculateTotalPayroll(){
        double combined=0;
        if(count==0){
            System.out.println("No employee records exist. Try adding some before retrying.");
            return 0.0;
        }
        else {
            for (int i = 0; i < count; i++) {
                combined+=(employeeArray[i].getSalary()+employeeArray[i].calculateBonus());
            }
        }
        return combined;
    }
}
