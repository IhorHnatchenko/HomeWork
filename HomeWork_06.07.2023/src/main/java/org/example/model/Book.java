package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String name;
    private long ISBN;
    private Author author;
    private int year;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", ISBN=" + ISBN +
                ", author=" + author +
                ", year=" + year +
                '}';
    }
}
