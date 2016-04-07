import java.util.ArrayList;

/**
 * Created by brianmcveigh on 4/6/16.
 */
public class Payroll {
    private ArrayList<Employee> employees;

    public static final double MIN_SALARY = 8000;
    public static final double MAX_SALARY = 200000;
    public static final double BONUS = 2000;
    public static final double RAISE_PCT = 0.04;

    public Payroll() {
        employees = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean isValidSalary(double salary) {
        if (salary <= MAX_SALARY && salary >= MIN_SALARY) {
            return true;
        }

        return false;
    }

    public double monthsToYears(double months) {
        return Math.round(months/12);
    }

    public double generateEmployeeBonus(Employee employee) {
        double bonus = 0.0;

        if (isEligibleForBonus(employee)) {
            bonus += BONUS;
        }

        return bonus;
    }

    public double generateEmployeeRaise(Employee employee) {
        if (isEligibleForRaise(employee)) {
            return (employee.getSalary() * RAISE_PCT);
        }
        return 0;
    }

    public boolean isEligibleForBonus(Employee e) {
        if (e.getPerformanceReview() == "Excellent") {
            return true;
        }
        return false;
    }

    public boolean isEligibleForRaise(Employee e) {
        if (e.getNumYearsEmployed() >= 5) {
            return true;
        }
        return false;
    }

    public String printReportForAllEmployees() {
        String s = "";

        for (Employee e : employees) {
            s += "Name: " + e.getName() + "\n";
            s += "Performance Review: " + e.getPerformanceReview() + "\n";
            s += "Years Employed: " + e.getNumYearsEmployed() + "\n";
            s += "Old Salary: " + e.getSalary() + "\n";
            s += "\t+ Bonus: $" + generateEmployeeBonus(e) + "\n";
            s += "\t+ Raise: $" + generateEmployeeRaise(e) + "\n";
        }

        return s;
    }

    public String printReportForOneEmployee(Employee e) {
        String s = "";

        if (isEligibleForRaise(e)) {
            s += "Congratulations! You're eligible for a raise.\n";
        }
        else {
            s += "Not eligible for a raise.\n";
        }
        if (isEligibleForBonus(e)) {
            s += "Congratulations! You're eligible for a bonus. Keep up the hard work!\n";
        }
        else {
            s += "Not eligible for a bonus. Stop slacking off.\n";
        }


        s += "\nName: " + e.getName() + "\n";
        s += "Performance Review: " + e.getPerformanceReview() + "\n";
        s += "Years Employed: " + e.getNumYearsEmployed() + "\n";
        s += "Old Salary: $" + e.getSalary() + "\n";
        s += "\t+ Bonus: $" + generateEmployeeBonus(e) + "\n";
        s += "\t+ Raise: $" + generateEmployeeRaise(e) + "\n";
        s += "\t= New Salary: $" + (e.getSalary() + generateEmployeeBonus(e) + generateEmployeeRaise(e)) + "\n";

        return s;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "employees=" + employees +
                '}';
    }
}
