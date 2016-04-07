/**
 * Created by brianmcveigh on 4/6/16.
 */
public class Employee {
    private String name;
    private double numYearsEmployed;
    private String performanceReview;
    private double salary;

    public Employee() {}

    public Employee(String name, double numYearsEmployed, String performanceReview) {
        this.name = name;
        this.numYearsEmployed = numYearsEmployed;
        this.performanceReview = performanceReview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumYearsEmployed() {
        return numYearsEmployed;
    }

    public void setNumYearsEmployed(double numYearsEmployed) {
        this.numYearsEmployed = numYearsEmployed;
    }

    public String getPerformanceReview() {
        return performanceReview;
    }

    public void setPerformanceReview(String performanceReview) {
        this.performanceReview = performanceReview;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", numYearsEmployed=" + numYearsEmployed +
                ", performanceReview='" + performanceReview + '\'' +
                '}';
    }
}
