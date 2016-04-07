import javax.swing.*;

/**
 * Created by brianmcveigh on 4/6/16.
 */
public class PayrollApp {
    public static void main(String[] args) {
        Payroll p = new Payroll();

        while (true) {
            String name = JOptionPane.showInputDialog("Enter employee name");
            double numYearsEmployed = p.monthsToYears(Double.parseDouble(JOptionPane.showInputDialog("Enter number of months employed")));
            int performance = Integer.parseInt(JOptionPane.showInputDialog("Enter your performance:\n1. Excellent\n2. Average\n3. Poor"));

            boolean validated = false;
            double salary = 0;

            do {
                salary = Double.parseDouble(JOptionPane.showInputDialog("Enter your salary"));

                if (p.isValidSalary(salary)) {
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error! Salary must be between $" + Payroll.MIN_SALARY + " and $" + Payroll.MAX_SALARY + "!");
                }
            } while (!validated);

            String perfStr = "";

            switch (performance) {
                case 1:
                    perfStr = "Excellent";
                    break;
                case 2:
                    perfStr = "Average";
                    break;
                case 3:
                    perfStr = "Poor";
                    break;
            }

            Employee emp = new Employee();
            emp.setName(name);
            emp.setNumYearsEmployed(numYearsEmployed);
            emp.setPerformanceReview(perfStr);
            emp.setSalary(salary);

            JOptionPane.showMessageDialog(null, p.printReportForOneEmployee(emp));

            p.addEmployee(emp);

            int choice = JOptionPane.showConfirmDialog(null, "Employee added. Would you like to enter another employee?", "Select an Option", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.NO_OPTION) {
                break;
            }
        }

        JOptionPane.showMessageDialog(null, p.printReportForAllEmployees());
    }
}
