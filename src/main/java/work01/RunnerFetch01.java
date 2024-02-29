package work01;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {


    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //hibernate ile  DB den bilgi çekmek için 3 yol :
        // 1) get methodu
        // 2) HQL ( Hibernate Query Language )
        // 3) SQL (saf sql sorguları)


        //*  Get query
        Student01 student01 = session.get(Student01.class, 1);
        //  System.out.println("student01 = " + student01);

        //* sql query
        String sqlQuery = "select * from t_student_01";
        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();
        //hql veya veya get() ile değilde sql sorgu ile veri aldığımız için veriyi map leme garantisi yoktur.
        //Onun için class ismi ile değilde Object[] ile karşılarız.Saf sql sorgusu olduğu için


        resultList.forEach(r-> System.out.println(Arrays.toString(r)));


        // ? Hql query
        String hqlQuery = "from Student01";
        List<Student01> resultListHql = session.createQuery(hqlQuery, Student01.class).getResultList();

        resultListHql.forEach(System.out::println);

        //******************************************
        // ? Sql query ile tek veri alma
        String sqlQuery2 = "select * from t_student_01 where student_name='Ceka Soft'";

        Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();

        System.out.println(Arrays.toString(uniqueResult1));

        //? Hql query ile tek veri alma
        String hqlQuery2 = "FROM Student01 std where std.name='Ceka Soft'";
        Student01 student011 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();

        System.out.println(student011);


        // Hql ; sadec is ve name bilgilerini aldığımız için Object ile karşılamak şlazım.
        //Çünkü diğer field lar null olacak.Class ismi ile karşılama olmaz
        String hqlQuery3="Select s.id,s.name from Student01 s where s.grade=75";
        List<Object[]> hqlResult3=session.createQuery(hqlQuery3).getResultList();

        hqlResult3.forEach(r-> System.out.println(Arrays.toString(r)));

         // Hql ; id ye göre sıralı getir.
        String hqlQuery4 = "FROM Student01 s ORDER BY s.id DESC";
        List<Student01> resultList4 = session.createQuery(hqlQuery4, Student01.class).getResultList();

        resultList4.forEach(System.out::println);

        tx.commit();
        session.close();
        sf.close();


    }
}
