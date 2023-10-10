package com.codecool.service;

import com.codecool.model.room.Room;
import com.codecool.model.room.RoomColor;
import com.codecool.model.user.Mentor;
import com.codecool.model.user.Student;
import com.codecool.model.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class School {
    private final List<Room> rooms;
    private final List<Mentor> mentors;

    public School(List<Room> rooms) {
        this.rooms = rooms;
        this.mentors = new ArrayList<>();
    }

    public List<String> getUsersStartedOnDate(LocalDate date) {
        // TODO: is it ok to print, not return?
        System.out.println("\nUsers in school with start date: " + date.toString());
        List<Student> allStudents = getAllStudents();
        List<User> allUsers = new ArrayList<>();
        allUsers.addAll(mentors);
        allUsers.addAll(allStudents);
        return allUsers.stream()
                .filter(user -> user.getStartInSchool().equals(date))
                .map(user -> user.getName())
                .peek(userName -> System.out.println(userName))
                .toList();
    }
    public List<String> getAllStudentsInRoom(RoomColor color) {
        System.out.println("\nStudents in room: " + color.name());
        return rooms.stream()
                .filter(room -> room.getColor().equals(color))
                .flatMap(room -> room.getStudnetsNames().stream())
                .peek(sudentNme -> System.out.println(sudentNme))
                .toList();
    }

    public List<String> getStudentsAllwaysPresent() {
        System.out.println("\nStudents allways present: ");
        List<Student> allStudents = getAllStudents();
        return allStudents.stream()
                .filter(student -> student.isAllwaysPreset())
                .map(student -> student.getName())
                .peek(studentName -> System.out.println(studentName))
                .toList();
    }

    public void addStudent(Student student) {
        student.setStartInSchool();
        rooms.get(0).addStudent(student);
    }

    public void addMentor(Mentor mentor, RoomColor roomColor) {
        mentor.setRoomColor(roomColor);
        mentor.setStartInSchool();
        mentors.add(mentor);
    }

    private List<Student> getAllStudents() {
        return rooms.stream()
                .flatMap(room -> room.getStudnets().stream())
                .toList();
    }

    private List<String> getAllMentorsNames() {
        return mentors.stream()
                .map(mentor -> mentor.getName())
                .toList();
    }

    //list students with always “present” attendance
}
