package mvc;

import mvc.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(new Customer("malak","maurice","email"));
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
