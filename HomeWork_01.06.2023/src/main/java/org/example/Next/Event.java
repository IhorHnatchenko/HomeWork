package org.example.Next;


import java.time.LocalDate;

public class Event {
    private static int eventId;
    private final String userName;
    private final String userIp;
    private final LocalDate eventData;
    private final EventState eventState;

    public Event(String userName, int eventId, String userIp, LocalDate eventData, EventState eventState) {
        this.eventId = eventId;
        this.userName = userName;
        this.userIp = userIp;
        this.eventData = eventData;
        this.eventState = eventState;
    }


    public int getEventId() {
        return eventId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserIp() {
        return userIp;
    }

    public LocalDate getEventData() {
        return eventData;
    }

    public EventState getEventState() {
        return eventState;
    }


    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", userName='" + userName + '\'' +
                ", userIp='" + userIp + '\'' +
                ", eventData=" + eventData +
                ", eventState=" + eventState +
                '}';
    }


}
