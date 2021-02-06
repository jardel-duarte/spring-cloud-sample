package com.atlantico.desafio.users.resource;

import com.atlantico.desafio.users.domain.UserCreateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "auth", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class AuthenticateController {

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> signIn(@Valid @RequestBody UserCreateDTO user) {

        return ResponseEntity.ok(user);
    }

}
