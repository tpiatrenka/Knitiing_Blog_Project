package com.piatrenka.converter;

import com.piatrenka.dto.UserDto;
import com.piatrenka.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private final ArticleConverter articleConverter;

    public UserConverter(ArticleConverter articleConverter) {
        this.articleConverter = articleConverter;
    }


    public User toLocal(UserDto dto) {
        User user = new User();
        user.setName(dto.name());
        return user;
    }

    public UserDto toFront(User user) {
        return new UserDto(user.getName());
    }
}
