package com.employee.dao;

import com.employee.entity.LeaveHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LeaveHistoryDao {

    private SessionFactory factory = HibernateUtils.getSessionFactory();


    public ArrayList<LeaveHistory> getAllLeaveHistory() {

        ArrayList<LeaveHistory> lstLeaveHistory = new ArrayList<>();

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            // HQL query object
            String sql = "from LeaveHistory";

            // Query object
            Query query = session.createQuery(sql);

            // get result of query
            lstLeaveHistory = (ArrayList<LeaveHistory>) query.list();

        }catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.getTransaction().commit();
        }

        return lstLeaveHistory;
    }

    public List<LeaveHistory> getLeaveHistoryOfMember (String account) {

        List<LeaveHistory> listLeaveHistory = new ArrayList<>();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            // HQL query (Using inject param to prevent SQL injection)
            StringBuilder hql = new StringBuilder();
            hql.append("FROM LeaveHistory");
            hql.append(" WHERE account = :account");

            // Create Query object
            Query query = session.createQuery(hql.toString());

            // Set parameters
            query.setParameter("account", account);

            // get result of query
            listLeaveHistory = (List<LeaveHistory>) query.list();

        }catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.getTransaction().commit();
        }

        return listLeaveHistory;
    }
}
