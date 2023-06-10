package org.example.Next;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class EventCreator implements Runnable{



    CopyOnWriteArrayList<Event> listOfEvents = new CopyOnWriteArrayList<>();

    private final AtomicInteger eventId = new AtomicInteger();


    public AtomicInteger getEventId() {
        return eventId;
    }




    private static List<String> userNamesList = new ArrayList<>(Arrays.asList(
            "User1", "User2", "User3", "User4", "User5",
            "User6", "User7", "User8", "User9", "User10"
    ));

    public static String getRandomUser() {
        if (userNamesList.isEmpty()) {
            return "No more users available";
        }

        Random random = new Random();
        int index = random.nextInt(userNamesList.size());
        String randomUser = userNamesList.remove(index);
        return randomUser;
    }
    private String generateRandomIp() {
        Random random = new Random();
        return random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256);
    }

    private org.example.Next.EventState generateRandomEventState() {
        Random random = new Random();
        int index = random.nextInt(org.example.Next.EventState.values().length);
        return org.example.Next.EventState.values()[index];
    }



    @Override
    public void run() {

        // Мне кажется, что здесь я сделал не правлиьно.
        Event event = new Event(getRandomUser(), eventId.get(), generateRandomIp(), LocalDate.now(), generateRandomEventState());



        //System.out.println(Thread.currentThread().getName());


        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }





            listOfEvents.add(event);



        System.out.println(listOfEvents);
    }
}
