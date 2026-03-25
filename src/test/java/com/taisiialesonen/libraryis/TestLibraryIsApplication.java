package com.taisiialesonen.libraryis;

import org.springframework.boot.SpringApplication;

public class TestLibraryIsApplication {

    public static void main(String[] args) {
        SpringApplication.from(LibraryIsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
