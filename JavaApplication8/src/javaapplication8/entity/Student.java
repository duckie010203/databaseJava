/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8.entity;

public class Student implements Comparable<Student>{
    private String id, name, classId;
    private float gpa;

    public Student(String id, String name, String classId, float gpa) {
        this.name = name;
        this.classId = classId;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getClasss() {
        return classId;
    }

    public String getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasss(String classs) {
        this.classId = classs;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    
    public Object[] toObject(){
        return new Object[]{
            id,name,classId,String.format("%.2f", gpa)
        };
    }
    
    @Override
    public int compareTo(Student o){
        return (int) o.gpa - (int)gpa;
    }
    
}