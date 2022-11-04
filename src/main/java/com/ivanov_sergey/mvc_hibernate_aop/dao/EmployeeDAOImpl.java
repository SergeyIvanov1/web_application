package com.ivanov_sergey.mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ivanov_sergey.mvc_hibernate_aop.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

//    @Transactional
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
//        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class)
//                .getResultList();

        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
        Query<Employee> query = session.createQuery("delete from Employee where id = " + id);
//        query.setParameter("imployeeID", id);
        query.executeUpdate();
    }
}
