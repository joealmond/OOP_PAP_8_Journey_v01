package com.codecool.service;

import com.codecool.model.Attendance;
import com.codecool.model.room.Room;
import com.codecool.model.room.RoomColor;
import com.codecool.model.user.Location;
import com.codecool.model.user.Mentor;
import com.codecool.model.user.Student;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void getStudentsAllwaysPresent() {
        // arrange
        Room basic = new Room("Basic", RoomColor.WHITE);
        School journey = new School(List.of(basic));
        Mentor mentor1 = new Mentor("gh1", "mentor1", "email1", Location.BUDAPEST);
        Student student1 = new Student("student1", "s1", Location.BUDAPEST);
        Student student2 = new Student("student2", "s2", Location.BUDAPEST);
        journey.addStudent(student1);
        journey.addStudent(student2);
        journey.addMentor(mentor1,RoomColor.WHITE);

        student1.setAttendenceToDate(Attendance.PRESENT,LocalDate.parse("2023-10-10"));
        student1.setAttendenceToDate(Attendance.PRESENT,LocalDate.parse("2023-10-11"));
        student2.setAttendenceToDate(Attendance.MISSING, LocalDate.parse("2023-10-10"));
        student2.setAttendenceToDate(Attendance.PRESENT, LocalDate.parse("2023-10-11"));

        // act
        List<String> studentsAllwaysPresent = journey.getStudentsAllwaysPresent();

        // assert
        assertEquals(studentsAllwaysPresent.size(),1);

    }
}