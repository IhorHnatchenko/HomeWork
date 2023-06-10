package org.example.Next;



import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FirewallEventListenerData implements Runnable {

    private static CopyOnWriteArrayList<String> logList = new CopyOnWriteArrayList<>();
    private static CopyOnWriteArrayList<org.example.Next.Event> eventList = new CopyOnWriteArrayList<>();

    public static void setEventList(CopyOnWriteArrayList<Event> eventList) {
        FirewallEventListenerData.eventList = eventList;
    }

    public static void setLogList(CopyOnWriteArrayList<String> logList) {
        FirewallEventListenerData.logList = logList;
    }

    @Override
    public void run() {
        while (!eventList.isEmpty()) {
            Event event = eventList.remove(0);
            processEvent(event);
            System.out.println(logList);
        }
    }

    private void processEvent(Event event) {
        String handlerName = Thread.currentThread().getName();
        EventCreator eventCreator = new EventCreator();
        AtomicInteger eventId = eventCreator.getEventId();
        String logUsername = "Handler " + handlerName + eventId + " " + event.getUserName();
        String logIpAddress = "Handler " + handlerName + eventId + " " + event.getUserIp();
        String logDateTime = "Handler " + handlerName + eventId + " " + event.getEventData();
        String logStatus = "Handler " + handlerName + eventId + " " + event.getEventState();

        logList.add(logUsername);
        logList.add(logIpAddress);
        logList.add(logDateTime);
        logList.add(logStatus);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
