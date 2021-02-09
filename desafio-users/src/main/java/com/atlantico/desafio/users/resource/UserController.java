package com.atlantico.desafio.users.resource;

import com.atlantico.desafio.persistence.service.UserService;
import com.atlantico.desafio.users.domain.UserCreateDTO;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders={"x-auth-token", "x-requested-with", "x-xsrf-token"})
@RestController
@RequestMapping(path = "users", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("signIn")
    @ResponseBody
    public ResponseEntity<?> signIn(@Valid @RequestBody UserCreateDTO body) {

        // TODO: tratar esse tipo de exceção em {ErrorHandler}
        val user = Optional.of(userService.save(body.toUser()))
                .orElseThrow(() -> new IllegalArgumentException("Tivemos um problema ao salvar o usuário"));

        val response = new UserCreateDTO(user.getName(), user.getEmail(), null);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
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
