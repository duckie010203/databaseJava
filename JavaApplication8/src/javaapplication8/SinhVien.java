/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

public class SinhVien implements Comparable<SinhVien>{
    private String name, classs, id;
    private float gpa;

    public SinhVien(String name, String classs, String id, float gpa) {
        this.name = name;
        this.classs = classs;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getClasss() {
        return classs;
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
        this.classs = classs;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    
    public Object[] toObject(){
        return new Object[]{
            id,name,classs,String.format("%.2f", gpa)
        };
    }
    
    @Override
    public int compareTo(SinhVien o){
        return (int) o.gpa - (int)gpa;
    }
    
}