package com.example.demo.data;

public class InputTeacher {

    private String id;

    private String name;

    private String active;

    public InputTeacher() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
    public Teacher getTeacher(){
        Teacher t=new Teacher();
        t.setId(Long.valueOf(id));
        t.setName(name);
        t.setActive(active);
        return t;
    }
}
