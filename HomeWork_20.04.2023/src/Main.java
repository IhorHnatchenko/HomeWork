import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> listForExampleOne = Arrays.asList("a1", "b5", "c1", "a2", "b4", "c1", "a1");
        System.out.println("Our list: ");
        System.out.println(listForExampleOne);

        List<String> collectSortedAndDistinct = listForExampleOne.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println("Our normal sorted and distinct list: ");
        System.out.println(collectSortedAndDistinct);

        List<String> collectReversSortedAndDistinct = listForExampleOne.stream().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
        System.out.println("Our normal revers sorted and distinct list: ");
        System.out.println(collectReversSortedAndDistinct);
        System.out.println();

        List<String> listForExampleTwo = Arrays.asList("a1", "b5", "a2", "b4");
        System.out.println(listForExampleTwo);
        String s = listForExampleTwo.stream().min(String::compareTo).orElse("0");
        System.out.println("The smallest element: " + s);

        List<FrontEndStudent> frontEndStudentList = Arrays.asList(
                new FrontEndStudent("Dia", 4.1, true, ""),
                new FrontEndStudent("Junko", 2.3, false, ""),
                new FrontEndStudent("Yukiko", 1.5, false, ""),
                new FrontEndStudent("Ritsuko", 1.4, false, ""),
                new FrontEndStudent("Sayuri", 4.5, true, "")
        );
        List<BackEndStudent> backEndStudentList = Arrays.asList(
                new BackEndStudent("Kazuo", 5, true, ""),
                new BackEndStudent("Umeko", 3.5, false, ""),
                new BackEndStudent("Yuki", 2.2, true, ""),
                new BackEndStudent("Taro", 1.5, false, ""),
                new BackEndStudent("Daichi", 2.1, true, "")
        );

        List<QAStudent> QAStudentList = Arrays.asList(
                new QAStudent("Sayuri", 1.4, true, ""),
                new QAStudent("Hiroshi", 4.2, false, ""),
                new QAStudent("Kameko", 3.5, false, ""),
                new QAStudent("Shima", 2.1, false, ""),
                new QAStudent("Misato", 4.6, true, "")
        );

        List<Student> studentList = frontEndStudentList.stream().collect(Collectors.toList());
        studentList.addAll(backEndStudentList);
        studentList.addAll(QAStudentList);

        System.out.println(studentList);

        List<ProjectStudent> projectStudents = studentList.stream()
                .filter(student -> student.getRate() >= 4.5 && student.isFinished())
                .peek(student -> {
                    if (student instanceof FrontEndStudent){
                        student.setType("FE");
                    }else if (student instanceof BackEndStudent){
                        student.setType("BE");
                    }else if (student instanceof QAStudent){
                        student.setType("QA");
                    }else {
                        student.setType("--");
                    }
                })
                .map(student -> new ProjectStudent(student.getName(), student.getRate(), student.getType()))
                .toList();

        System.out.println(projectStudents);

    }
}