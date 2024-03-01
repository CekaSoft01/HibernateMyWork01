package work04.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class RunnerSave {
  public static void main(String[] args) {

   Student student1 = new Student();
   student1.setId(1001);
   student1.setName("Kemal terzi");
   student1.setGrade(0);

   Student student2 = new Student();
   student2.setId(1002);
   student2.setName("Hatice remse");
   student2.setGrade(0);

   Student student3 = new Student();
   student3.setId(1003);
   student3.setName("Enes Deniz");
   student3.setGrade(0);

   University university = new University();
   university.setId(1);
   university.setName("DUMLUPINAR UNI");


   University university2 = new University();
   university2.setId(2);
   university2.setName("MİMAR SİNAN UNI");


   student1.setUniversity(university);
   student2.setUniversity(university2);
   student3.setUniversity(university2);

   Configuration con=new Configuration().configure("hibernate.cfg.xml")
           .addAnnotatedClass(Student.class).addAnnotatedClass(University.class);
   SessionFactory sessionFactory= con.buildSessionFactory();
   Session session=sessionFactory.openSession();
   Transaction tx =  session.beginTransaction();

   session.save(university);
   session.save(university2);

   session.save(student2);
   session.save(student1);
   session.save(student3);

   tx.commit();
   session.close();
   sessionFactory.close();
  }
}
