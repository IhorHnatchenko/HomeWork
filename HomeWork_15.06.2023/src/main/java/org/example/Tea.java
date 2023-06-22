package org.example;

import java.util.UUID;

public class Tea {

    private final String uuid;

    private final String name;

    public Tea(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public Tea(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    @Override
    public String toString() {
        return "Tea{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
