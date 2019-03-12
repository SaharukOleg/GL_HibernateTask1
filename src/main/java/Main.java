import DAO.DepartmentDAO;
import DAO.WorkersDAO;
import entity.Worker;
import enums.Availability;
import entity.Department;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DepartmentDAO departmentDAO = new DepartmentDAO();
        WorkersDAO workersDao = new WorkersDAO();

        Department department = new Department("newDepartment", true);
        departmentDAO.addDepartment(department);

        List<Worker> listWorkers = new ArrayList<>();

// create 2 users
        Worker worker1 = new Worker(24, Availability.PART_TIME, "OLEG");
        Worker worker2 = new Worker(50, Availability.FULL_TIME, "IVAN");
        worker1.setDepartment(department);
        worker2.setDepartment(department);
        listWorkers.add(worker1);
        listWorkers.add(worker2);

        department.setWorkers(listWorkers);
        departmentDAO.updateDepartment(department);

        departmentDAO.delete(department);

        System.out.println("Select user by id ");
        Worker workerDaoById = workersDao.findById(1);
        System.out.println(workerDaoById);

        System.out.println("all users");
        System.out.println(workersDao.findAll());
    }
}
