package org.example;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeaController {

    public final List<Tea> teas = new ArrayList<>();

    public TeaController() {
        teas.addAll(List.of(
                new Tea("Green"),
                new Tea("Black"),
                new Tea("White"),
                new Tea("Oolong"),
                new Tea("Yellow"),
                new Tea("Herbal")
        ));
    }

    @GetMapping("/tea/list")
    public Iterable<Tea> getTea() {
        return teas;
    }

    @PostMapping("/tea/list/add")
    public Tea addTea(@RequestBody Tea tea){
        teas.add(tea);
        return tea;
    }
}
