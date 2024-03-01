package work03.bi_onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Diary.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, 1001);
        Diary diary = session.get(Diary.class, 101);

        //System.out.println(student);
        //System.out.println("diary = " + diary);


        // * diary si olan öğrencilerin name,diary name lerini getireceğiz.
        //HQL
        String hqlQuery = "select s.name,d.name from Student s inner join Diary d on s.id=d.student";
        List<Object[]> resulList1 = session.createQuery(hqlQuery).getResultList();
      //  resulList1.forEach(r -> System.out.println(Arrays.toString(r)));


        //* bütün öğrenciler ve varsa bu ogrencilerin gunlukleri
        String hqlQuery2="select s.name,d.name from Student s left join fetch Diary d on s.id=d.student";
        List<Object[]> resulList2=session.createQuery(hqlQuery2).getResultList();
        resulList1.forEach(r -> System.out.println(Arrays.toString(r)));

        //: Bütün günlükler ve varsa günlüğü olan Öğrenciler geliyor
        String hqlQuery3 = "SELECT s.name,d.name FROM Student s RIGHT JOIN FETCH Diary d ON s.id=d.student";
        List<Object[]> resultList3 = session.createQuery(hqlQuery3).getResultList();
        resultList3.forEach(oa-> {
            System.out.println(Arrays.toString(oa));
        });

        //: butun ogrenci ve diary bilgilerini getiriyoruz
        String hqlQuery4 = "SELECT s.name,d.name FROM Student s FULL JOIN FETCH Diary d ON s.id=d.student";
        List<Object[]> resultList4 = session.createQuery(hqlQuery4).getResultList();
        resultList4.forEach(oa-> {
            System.out.println(Arrays.toString(oa));
        });

        tx.commit();
        session.close();
        sf.close();





    }


}
