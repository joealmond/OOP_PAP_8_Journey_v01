package com.codecool.model.room;

import com.codecool.model.user.Student;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String name;
    private final RoomColor color;
    private final List<Student> students;

    public Room(String name, RoomColor color) {
        this.name = name;
        this.color = color;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        student.setStartInSchool();
        student.setStartInRoom(color);
        students.add(student);
        System.out.println("Student added in room " + color.name());
    }

    public List<String> getStudnetsNames() {
        return students.stream().map(student -> student.getName()).toList();
    }
    public List<Student> getStudnets() {
        return students;
    }
    public RoomColor getColor() {
        return color;
    }

}
