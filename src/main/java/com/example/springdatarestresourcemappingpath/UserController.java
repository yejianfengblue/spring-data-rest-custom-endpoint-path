package com.example.springdatarestresourcemappingpath;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RepositoryRestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{id}/greeting")
    ResponseEntity<String> greeting(@PathVariable Integer id) {

        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            return ResponseEntity.ok("Hello " + foundUser.get().getUsername());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
