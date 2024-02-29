package work02.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {


        Student student1 = new Student();
        student1.setId(1001);
        student1.setName("Celal Bey");
        student1.setGrade(75);

        Student student2 = new Student();
        student2.setId(1002);
        student2.setName("Murat Bey");
        student2.setGrade(75);

        Student student3 = new Student();
        student3.setId(1003);
        student3.setName("Cihan Bey");
        student3.setGrade(75);


        Diary diary1 = new Diary();
        diary1.setId(101);
        diary1.setName("Celal Beyin gunlugu");
        diary1.setStudent(student1);

        Diary diary2 = new Diary();
        diary2.setId(102);
        diary2.setName("Murat Beyin Gunlugu");
        diary2.setStudent(student2);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).addAnnotatedClass(Diary.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);

        tx.commit();
        session.close();
        sf.close();

    }

}
