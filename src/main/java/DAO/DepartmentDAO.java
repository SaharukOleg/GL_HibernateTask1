package DAO;

import entity.Department;
import org.hibernate.Session;
import util.Setup;

import java.util.List;

public class DepartmentDAO {

    public void addDepartment(Department department) {
        Session session = Setup.getSession().openSession();
        session.save(department);
        session.close();
    }

    public void updateDepartment(Department department) {
        Session session = Setup.getSession().openSession();
        session.update(department);
        session.close();
    }

    public Department findById(int id) {
        Session session = Setup.getSession().openSession();
        Department dep = session.get(Department.class, id);
        session.close();
        return dep;
    }

    public void delete(Department entity) {
        Session session = Setup.getSession().openSession();
        session.delete(entity);
        session.close();
    }

    public List<Department> findAll() {
        Session session = Setup.getSession().openSession();
        List<Department> departments = (List<Department>) session.createQuery("from Department").list();
        session.close();
        return departments;
    }


}