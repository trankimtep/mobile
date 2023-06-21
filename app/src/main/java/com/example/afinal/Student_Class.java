package com.example.afinal;

public class Student_Class {

    private int StudentId;
    private int ClassId;
    private int semester;
    private int credit;

    public Student_Class() {
    }

    public Student_Class(int studentId, int classId, int semester, int credit) {
        StudentId = studentId;
        ClassId = classId;
        this.semester = semester;
        this.credit = credit;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
