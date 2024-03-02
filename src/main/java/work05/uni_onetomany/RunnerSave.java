package work05.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

 class RunnerSave {

    public static void main(String[] args) {
        //!!! Student nesnelerimizi olusturalim
        Student student1 = new Student();
        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(50);

        Student student2 = new Student();
        student2.setId(1002);
        student2.setName("James Bond");
        student2.setGrade(60);

        Student student3 = new Student();
        student3.setId(1003);
        student3.setName("Tony Stark");
        student3.setGrade(70);


        //!!! Book nesnelerimizi olusturalim
        Book book1 = new Book();
        book1.setId(101);
        book1.setName("John's Art Book");

        Book book2 = new Book();
        book2.setId(102);
        book2.setName("John's Math Book");

        Book book3 = new Book();
        book3.setId(103);
        book3.setName("James's Java Book");

        //!!! Student uzerinden book nesnelerini setliyoruz
        student1.getBookList().add(book1);
        student1.getBookList().add(book2);
        student2.getBookList().add(book3);



        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).addAnnotatedClass(Book.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sf.close();


    }
}
