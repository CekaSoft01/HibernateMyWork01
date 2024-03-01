package work04.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

class RunnerFetch {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .addAnnotatedClass(University.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student student1 = session.get(Student.class, 1001);
        System.out.println(student1.getUniversity());

        String hqlQuery = "from Student s where s.university.id=1";//s.university ' de kabul eder.Otomatik anlar. kendileri.
        List<Student> studentList = session.createQuery(hqlQuery).getResultList();
        studentList.forEach(r -> {
            System.out.println(r);


        });

        tx.commit();
        session.close();
        sf.close();


    }
}
