package org.example;

//В данном классе должно быть получено только поле number
//префикс QA
@SuppressWarnings("unused")
@Prefixes(prefixes = "QA")
public class StudentQA extends AbstractStudent {

    private final String name;

    private final String surname;

    private String number;

    public StudentQA() {
        name = NameUtil.getRandomName();
        surname = NameUtil.getRandomName();
        number = NameUtil.getRandomNumber();
    }
}

