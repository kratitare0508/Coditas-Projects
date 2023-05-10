package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student {
    @Id
    private int studentid;
    private String Studentname;
    @ManyToOne
    private Teacher teacher;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return Studentname;
    }

    public void setStudentname(String studentname) {
        Studentname = studentname;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public Student(int studentid, String studentname, Teacher teacher) {
        this.studentid = studentid;
        Studentname = studentname;
        this.teacher = teacher;
    }

    public Student()
    {
        super();
    }


}


