package com.atlantico.desafio.proxy.resources;

import com.atlantico.desafio.proxy.domain.UserCredentialsDTO;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "authenticate", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> login(@Valid @RequestBody UserCredentialsDTO user, HttpSession session) {

        val token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        val auth= authenticationManager.authenticate(token);

        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(auth);

        return ResponseEntity.ok(session.getId());
    }
}
