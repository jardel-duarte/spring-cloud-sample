package com.atlantico.desafio.users.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "users", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@RefreshScope
public class UserController {

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> index() {
        return ResponseEntity.ok("Test");
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> save() {
        return ResponseEntity.ok("Test");
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable("id") Long id) {
        return ResponseEntity.ok("Test :: " + id);
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> view(@PathVariable("id") Long id) {
        return ResponseEntity.ok("Test :: " + id);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok("Test :: " + id);
    }
}
