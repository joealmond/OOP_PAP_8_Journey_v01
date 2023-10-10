package com.codecool;

import com.codecool.model.Attendance;
import com.codecool.model.user.Location;
import com.codecool.model.user.Mentor;
import com.codecool.model.room.Room;
import com.codecool.model.room.RoomColor;
import com.codecool.model.user.Student;
import com.codecool.service.School;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Room basic = new Room("Basic", RoomColor.WHITE);
        Room web = new Room("Web", RoomColor.GREEN);
        Room oop = new Room("Oop", RoomColor.BLUE);
        Room advanced = new Room("Advanced", RoomColor.RED);

        School journey = new School(List.of(basic, web, oop, advanced));

        Mentor mentor1 = new Mentor("gh1", "mentor1", "email1", Location.BUDAPEST);
        Mentor mentor2 = new Mentor("gh2", "mentor2", "email2", Location.BUDAPEST);
        Mentor mentor3 = new Mentor("gh3", "mentor3", "email3", Location.BUDAPEST);
        Mentor mentor4 = new Mentor("gh4", "mentor4", "email4", Location.BUDAPEST);

        Student student1 = new Student("student1", "s1", Location.BUDAPEST);
        Student student2 = new Student("student2", "s2", Location.BUDAPEST);
        Student student3 = new Student("student3", "s3", Location.BUDAPEST);
        Student student4 = new Student("student4", "s4", Location.BUDAPEST);

        journey.addStudent(student1);
        journey.addStudent(student2);
        web.addStudent(student3);
        web.addStudent(student4);
        journey.addMentor(mentor1,RoomColor.WHITE);
        journey.addMentor(mentor2,RoomColor.GREEN);
        journey.addMentor(mentor3,RoomColor.BLUE);
        journey.addMentor(mentor4,RoomColor.RED);

        student1.setAttendenceToday(Attendance.PRESENT);
        student2.setAttendenceToDate(Attendance.MISSING,LocalDate.parse("2023-10-11"));
        student3.setAttendenceToDate(Attendance.MISSING,LocalDate.parse("2023-10-11"));
        student4.setAttendenceToday(Attendance.PRESENT);

        journey.getUsersStartedOnDate(LocalDate.parse("2023-10-10"));
        journey.getAllStudentsInRoom(RoomColor.WHITE);
        journey.getStudentsAllwaysPresent();
    }
}