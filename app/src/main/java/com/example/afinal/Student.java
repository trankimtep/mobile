package com.example.afinal;

public class Student implements Comparable<Student>{
    public int id;
    public String name;
    public int yob;
    public String addr;
    public int year;

    public Student(int id, String name, int yob, String addr, int year) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.addr = addr;
        this.year = year;
    }

    public Student(String name, int yob, String addr, int year) {
        this.name = name;
        this.yob = yob;
        this.addr = addr;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Student other) {
        return (id - other.id);
    }
}
