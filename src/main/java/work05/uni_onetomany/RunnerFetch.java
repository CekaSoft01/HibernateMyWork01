package work05.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).addAnnotatedClass(Book.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, 1001);
        //System.out.println(student);

        //  ?  HQL ile id'si 101 olan kitabı getirelim
        String hqlQuery="from Book b  where b.id=101";
        Book book= session.createQuery(hqlQuery, Book.class).uniqueResult();
        //System.out.println("book = " + book);


        // ? yukardaki ayni sorguyu get ile 
        Book book1Get=session.get(Book.class,101);
      //  System.out.println("book1Get = " + book1Get);


        // ?  1001 id'li öğrencinin kitaplarını getirme ( HQL )
        String hqlQuery2="from Student s inner join s.bookList b where s.id=1001";
        List<Object[]> book2=session.createQuery(hqlQuery2).getResultList();
        book2.forEach(r-> System.out.println("r = " + Arrays.toString(r)));


        // ?  yukardaki taski get ile yazalim
        Student student2 = session.get(Student.class, 1001);
        student2.getBookList().forEach(System.out::println);




        tx.commit();
        session.close();
        sf.close();
    }
}
