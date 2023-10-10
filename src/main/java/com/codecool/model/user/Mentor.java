package com.codecool.model.user;

import com.codecool.model.room.RoomColor;

public class Mentor extends User {
    private final String githubAccount;
    private RoomColor roomColor;

    public Mentor(String githubAccount, String name, String email, Location location) {
        super(name, email, location);
        this.githubAccount = githubAccount;
        this.roomColor = null;
    }

    public String getRoomColor() {
        return roomColor.name();
    }

    public void setRoomColor(RoomColor roomColor) {
        // TODO: Not just scholl can set room! Is it ok?
        this.roomColor = roomColor;
        System.out.println("Mentor set in room " + roomColor.name());
    }

}
