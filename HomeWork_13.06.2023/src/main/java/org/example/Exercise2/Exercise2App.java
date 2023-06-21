package org.example.Exercise2;

import java.util.concurrent.*;

public class Exercise2App {


    public static void main(String[] args) throws Exception {

        Exchanger<String> exchanger = new Exchanger<>();

        String[] p1 = {"A -> D", "A -> C"};
        String[] p2 = {"B -> C", "B -> D"};

        String[] p3 = {"A -> E", "A -> G"};
        String[] p4 = {"B -> G", "B -> E"};

        String[] p5 = {"A -> F", "A -> K"};
        String[] p6 = {"B -> K", "B -> F"};

        String[] p7 = {"A -> L", "A -> M"};
        String[] p8 = {"B -> M", "B -> L"};

        String[] p9 = {"A -> J", "A -> X"};
        String[] p10 = {"B -> X", "B -> J"};


        ThreadHandler[] threadHandlers = {
                new ThreadHandler(1, "A", "D", p1, exchanger),
                new ThreadHandler(2, "B", "C", p2, exchanger),
                new ThreadHandler(3, "A", "E", p3, exchanger),
                new ThreadHandler(4, "B", "G", p4, exchanger),
                new ThreadHandler(5, "A", "F", p5, exchanger),
                new ThreadHandler(6, "B", "K", p6, exchanger),
                new ThreadHandler(7, "A", "L", p7, exchanger),
                new ThreadHandler(8, "B", "M", p8, exchanger),
                new ThreadHandler(9, "A", "J", p9, exchanger),
                new ThreadHandler(10, "B", "X", p10, exchanger)
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (ThreadHandler threadHandler : threadHandlers) {
            executorService.submit(threadHandler);
            Thread.sleep(1000);
        }

        executorService.shutdown();
    }
}
