package hello.hello.spring.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.hello.spring.DTO.UserT;
import java.util.*;

// REST API 테스트 컨트롤러 < postman 에서 JSON 형식의 데이터 보내면 CRUD 가능 >
// 단점 - 앱 재시작 시 초기화 작업도 진행됨.

@RestController
@RequestMapping("/api/users")
public class TestController {
    private List<UserT> users = new ArrayList<>();

    @GetMapping
    public List<UserT> getAllUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public UserT getUserById(@PathVariable Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public UserT createUser(@RequestBody UserT user) {
        user.setId((long) (users.size() + 1));
        users.add(user);
        return user;
    }

    @PutMapping("/{id}")
    public UserT updateUser(@PathVariable Long id, @RequestBody UserT updatedUser) {
        UserT existingUser = getUserById(id);

        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
        }
        return existingUser;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
