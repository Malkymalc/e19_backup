public class Manager extends Employee {

    private String deptName;

    public Manager(String name, String ni, Double salary, String deptName){
        super(name, ni, salary);
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }
}
