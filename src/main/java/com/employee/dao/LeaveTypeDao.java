package com.employee.dao;

import com.employee.entity.LeaveType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LeaveTypeDao {

    private SessionFactory factory = HibernateUtils.getSessionFactory();


    public ArrayList<LeaveType> getAllLeaveType() {

        ArrayList<LeaveType> listLeaveType = new ArrayList<>();

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            // HQL query object
            String sql = "from LeaveType";

            // Query object
            Query query = session.createQuery(sql);

            // get result of query
            listLeaveType = (ArrayList<LeaveType>) query.list();

        }catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.getTransaction().commit();
        }

        return listLeaveType;
    }

    public LeaveType getLeaveTypeById(int id) {

       LeaveType leaveType = null;

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            // HQL query object
            String sql = "from LeaveType where id = :id";

            // Query object
            Query query = session.createQuery(sql);

            // Set parameters
            query.setParameter("id", id);

            // get result of query
            leaveType = (LeaveType) query.uniqueResult();

        }catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.getTransaction().commit();
        }

        return leaveType;
    }
}
