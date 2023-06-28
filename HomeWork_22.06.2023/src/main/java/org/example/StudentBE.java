package org.example;


//В данном классе должно быть получено только поле name
//префикс BE

@SuppressWarnings("unused")
@Prefixes(prefixes = "BE")
public class StudentBE extends AbstractStudent {

    private final String name;

    private final String surname;


    public StudentBE() {
        name = NameUtil.getRandomName();
        surname = NameUtil.getRandomName();
    }
}
