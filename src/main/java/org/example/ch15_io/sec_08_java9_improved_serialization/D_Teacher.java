package org.example.ch15_io.sec_08_java9_improved_serialization;

public class D_Teacher implements java.io.Serializable {
    private String name;

    private A_Person student;

    public D_Teacher(String name, A_Person student) {
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A_Person getStudent() {
        return student;
    }

    public void setStudent(A_Person student) {
        this.student = student;
    }
}
