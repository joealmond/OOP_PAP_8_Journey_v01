package com.codecool.model.user;

import com.codecool.model.Attendance;
import com.codecool.model.room.RoomColor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Student extends User {
    private final Map<LocalDate, RoomColor> startInRoom;
    private final Map<LocalDate, Attendance> attendancePerDay;
    private String notes;

    public Student(String name, String email, Location location) {
        super(name, email, location);
        this.startInRoom = new HashMap<>();
        this.attendancePerDay = new HashMap<>();
        this.notes = "";
    }

    public Map<LocalDate, RoomColor> getStartInRoom() {
        return startInRoom;
    }

//    public Map<LocalDate, Attendance> getAttendancePerDay() {
//        return attendancePerDay;
//    }
    // TODO: instead of the above the belove is ok?

    public void setStartInRoom(RoomColor roomColor) {
        startInRoom.put(LocalDate.now(), roomColor);
        System.out.println("Student started in " + roomColor.name() + "-room..");
    }

    public boolean isAllwaysPreset() {
        if (attendancePerDay.values().isEmpty()) return false;
        return attendancePerDay.values().stream()
                .filter(attendance -> attendance != Attendance.PRESENT)
                .findFirst()
                .isEmpty();
    }

    public void setAttendenceToday(Attendance attendanceToday) {
        attendancePerDay.put(LocalDate.now(), attendanceToday);
        System.out.println("Attendance set to " + attendanceToday.name() + " on " + LocalDate.now());
    }

    public void setAttendenceToDate(Attendance attendance, LocalDate date) {
        attendancePerDay.put(date, attendance);
        System.out.println("Attendance set to " + attendance.name() + " on " + date);
    }
}
