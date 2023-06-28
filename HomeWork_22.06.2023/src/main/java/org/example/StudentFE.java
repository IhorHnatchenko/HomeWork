package org.example;

//В данном классе должно быть получено только поле surname
//префикс FE
@SuppressWarnings("unused")
@Prefixes(prefixes = "FE")
public class StudentFE extends AbstractStudent {

    private final String name;

    private final String surname;

    public StudentFE() {
        name = NameUtil.getRandomName();
        surname = NameUtil.getRandomName();
    }
}
