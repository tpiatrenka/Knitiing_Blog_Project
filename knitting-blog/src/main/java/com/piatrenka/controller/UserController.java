package com.piatrenka.controller;

import com.piatrenka.dto.ArticleDto;
import com.piatrenka.dto.UserDto;
import com.piatrenka.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public long save(@RequestBody UserDto userDto) throws Exception {
        return userService.save(userDto);
    }

    @GetMapping("/all")
    public List<UserDto> findAll() {
        return userService.findAll();
    }
}
