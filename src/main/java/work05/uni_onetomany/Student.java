package work05.uni_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
class Student {
   @Id
    private int id;

    @Column(name="student_name",nullable = false)
    private  String name;
    private  int grade;

    @OneToMany()
    @JoinColumn//JoinColumn yazmassak 3. tablo oluşur.id ve forein Key tutan.
    //?? hipernate burda bizi dimlemiyor. kendi insifiyatini kullanıyor. ve forein keyi (book claas ında ki id) e atıyor
    private List<Book> bookList=new ArrayList<>();

    //getter-setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> book06List) {
        this.bookList = book06List;
    }

    // tostring

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", book06List=" + bookList +
                '}';
    }


}
