package work03.bi_onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class RunnerSave {
    public static void main(String[] args) {

        // ?  ÖĞRENCİLER ...
        Student student1 = new Student();
        student1.setId(1001);
        student1.setName("Murat Bey");
        student1.setGrade(75);

        Student student2 = new Student();
        student2.setId(1002);
        student2.setName("Furkan Bey");
        student2.setGrade(75);

        Student student3 = new Student();
        student3.setId(1003);
        student3.setName("Enes Faruk Bey");
        student3.setGrade(75);

        // ?  GÜNLÜKLER ...
        Diary diary1 = new Diary();
        diary1.setId(101);
        diary1.setName("A gunlugu");
        diary1.setStudent(student1);


        Diary diary2 = new Diary();
        diary2.setId(102);
        diary2.setName("B gunlugu");
        diary2.setStudent(student2);


        Diary diary3 = new Diary();
        diary3.setId(103);
        diary3.setName("Kimseye Ait degil");


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Diary.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);

        tx.commit();
        session.close();
        sessionFactory.close();



    }


}
