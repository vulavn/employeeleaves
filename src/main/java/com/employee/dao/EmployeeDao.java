package com.employee.dao;

import com.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EmployeeDao {

    private SessionFactory factory = HibernateUtils.getSessionFactory();

    public ArrayList<Employee> getAllEmployee() {

        ArrayList<Employee> lstEmployee = new ArrayList<>();

        Session session = factory.getCurrentSession();

        try {
            // *** Importance: all access inside DB must be between Transaction().begin() and close
            session.getTransaction().begin();

            // HQL query object
            String sql = "from Employee"; // Select all

            // Query object
            Query<Employee> query = session.createQuery(sql);

            // get result of query
            lstEmployee = (ArrayList<Employee>) query.list();

        }catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.getTransaction().commit();
        }

        return lstEmployee;
    }


    public Employee getByLoginAcc(String account, String password) {

        Employee employee = new Employee();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            // HQL query (Using inject param to prevent SQL injection)
            StringBuilder hql = new StringBuilder();
            hql.append("FROM Employee");
            hql.append(" WHERE account = :account");
            hql.append(" AND password = :password");

            // Create Query object
            Query query = session.createQuery(hql.toString());

            // Set parameters
            query.setParameter("account", account);
            query.setParameter("password", password);

            // get result of query
            employee = (Employee) query.uniqueResult();

        }catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.getTransaction().commit();
        }

        return employee;
    }

    public ArrayList<Employee> getByManager(String manager) {

        ArrayList<Employee> listEmployee = new ArrayList<>();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            // HQL query (Using inject param to prevent SQL injection)
            StringBuilder hql = new StringBuilder();
            hql.append("FROM Employee");
            hql.append(" WHERE manager = :manager");

            // Create Query object
            Query query = session.createQuery(hql.toString());

            // Set parameters
            query.setParameter("manager", manager);

            // get result of query
            listEmployee = (ArrayList<Employee>) query.list();

        }catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.getTransaction().commit();
        }

        return listEmployee;
    }
}
