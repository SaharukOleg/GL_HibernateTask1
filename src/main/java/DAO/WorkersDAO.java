package DAO;

import entity.Worker;
import org.hibernate.Session;
import util.Setup;

import java.util.List;

public class WorkersDAO {

    public void addWorkers(Worker worker) {
        Session session = Setup.getSession().openSession();
        session.save(worker);
        session.close();
    }

    public void updateWorksers(Worker worker) {
        Session session = Setup.getSession().openSession();
        session.update(worker);
        session.close();
    }

    public Worker findById(int id) {
        Session session = Setup.getSession().openSession();
        Worker worker = session.get(Worker.class, id);
        session.close();
        return worker;
    }

    public void delete(Worker entity) {
        Session session = Setup.getSession().openSession();
        session.delete(entity);
        session.close();
    }

    public List<Worker> findAll() {
        Session session = Setup.getSession().openSession();
        List<Worker> workers = (List<Worker>) session.createQuery("from Worker").list();
        session.close();
        return workers;
    }
}