public abstract class Employee {

    private String name;
    private String ni;
    private Double salary;

    public Employee(String nameInput, String niInput, Double salaryInput){
        this.name = nameInput;
        this.ni = niInput;
        this.salary = salaryInput;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getNI() {
        return ni;
    }
    public Double getSalary() {
        return salary;
    }

    public void raiseSalary(Double raiseRate){
        this.salary = this.salary * raiseRate;

    }
    public Double payBonus(){
        return this.salary * 0.01;
    }
}
