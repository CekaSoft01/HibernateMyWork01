package work01;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnnerSave01 {


    public static void main(String[] args) {
        Student01 student01 = new Student01();
        student01.setId(1);
        student01.setName("Ceka Soft");
        student01.setGrade(75);

        //2. öğrenci
        Student01 student02 = new Student01();
        student02.setId(2);
        student02.setName("Berat tutmaz");
        student02.setGrade(85);

        Student01 student03 = new Student01();
        student03.setId(3);
        student03.setName("Selim kaya");
        student03.setGrade(99);
        //config setting
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory= con.buildSessionFactory();

        Session session=sessionFactory.openSession();//connection create

        Transaction tx=session.beginTransaction();//transaction --tüm işlemlerin ok alması lazım.o zaman db ye kayıt gerçeekleşir.

        session.save(student01);
        session.save(student02);
        session.save(student03);


        tx.commit();//transactionu comitlemek gerek. sorguların tamamaı 200 döndüyse işlem gerçekleşecek.
        session.close();//connec kapat.
        sessionFactory.close();

    }
}
