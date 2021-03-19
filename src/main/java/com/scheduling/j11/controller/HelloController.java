package com.scheduling.j11.controller;

import com.scheduling.j11.repository.BookRepository;
import com.scheduling.j11.entities.Books;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    String message = "hello world";
    public static final Logger log = Logger.getLogger(HelloController.class.getName());
    @Autowired
    BookRepository repository;

    @GetMapping(value = "demo")
    public ResponseEntity<List<Books>> displayHelloMessage(@RequestParam("Id") String Id) {
        return ResponseEntity.ok(repository.findByMerchantId(Id));
    }

    @PostMapping(value = "demo")
    public ResponseEntity<Books> testCreate(@RequestParam("Id") String Id) {
        Books type = new Books("test_id","Setmore_test","sm_test","sm_test","sm_test","sm_test","sm_test");
        return ResponseEntity.ok(repository.save(type));
    }
}