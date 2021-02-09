package com.atlantico.desafio.users.resource;

import com.atlantico.desafio.users.domain.UserCredentialsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Base64;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "authenticate", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class AuthenticateController {

    private final AuthenticationManager authenticationManager;
    private final RedisTemplate<String, String> redis;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> login(@Valid @RequestBody UserCredentialsDTO user, HttpSession session) {

        val token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        val auth= authenticationManager.authenticate(token);

        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(auth);
        val key = Base64.getEncoder().encodeToString(session.getId().getBytes());

        redis.opsForHash().put("1", key, token.getPrincipal());

        return ResponseEntity.ok(key);
    }
}
