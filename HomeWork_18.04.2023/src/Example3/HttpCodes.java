package Example3;

import java.util.function.Function;

public enum HttpCodes {

    INFORMATIONAL(100, 199, new Action() {
        @Override
        public void action(int code, HttpCodes d) {
            System.out.println("http code: " + code + ": " + INFORMATIONAL);
        }
    }),
    SUCCESS(200, 299, new Action() {
        @Override
        public void action(int code, HttpCodes d) {
            System.out.println("http code: " + code + ": " + SUCCESS);
        }
    }),
    REDIRECTION(300, 399, new Action() {
        @Override
        public void action(int code, HttpCodes d) {
            System.out.println("http code: " + code + ": " + REDIRECTION);
        }
    }),
    CLIENTERROR(400, 499, new Action() {
        @Override
        public void action(int code, HttpCodes d) {
            System.out.println("http code: " + code + ": " + CLIENTERROR);
        }
    }),
    SERVERERROR(500, 599, new Action() {
        @Override
        public void action(int code, HttpCodes d) {
            System.out.println("http code: " + code + ": " + SERVERERROR);
        }
    });

    private final Action action;
    private int startBound;
    private int endBound;

    HttpCodes(int startBound, int endBound, Action action) {
        this.startBound = startBound;
        this.endBound = endBound;
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    public static void findValueByCode(int code) {
        // Не хватает реализации метода
        // где будет проверено, что код попадает в диапазон кодов , для одного из енамов
        // и будет вызван метод фунционального интерфейса Action для соответствующего кода

        switch (code / 100){
            case 1:
                System.out.println(INFORMATIONAL);
                break;
            case 2:
                System.out.println(SUCCESS);
                break;
            case 3:
                System.out.println(REDIRECTION);
                break;
            case 4:
                System.out.println(CLIENTERROR);
                break;
            case 5:
                System.out.println(SERVERERROR);
                break;
        }


    }
}
