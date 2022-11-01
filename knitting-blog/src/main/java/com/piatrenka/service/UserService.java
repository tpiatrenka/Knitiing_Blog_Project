package com.piatrenka.service;

import com.piatrenka.converter.ArticleConverter;
import com.piatrenka.converter.UserConverter;
import com.piatrenka.dto.ArticleDto;
import com.piatrenka.dto.UserDto;
import com.piatrenka.entity.User;
import com.piatrenka.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserConverter converter;

    public UserService(UserRepository repository, UserConverter converter, ArticleConverter articleConverter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Transactional(rollbackFor = Exception.class)
    public Long save(UserDto dto) throws Exception {
        User userForSave = converter.toLocal(dto);
        User user = repository.save(userForSave);
        //createAndThrowException();
        return user.getId();
    }

    public List<UserDto> findAll() {
        List<User> users = (List<User>) repository.findAll();
        return users.stream().map(converter::toFront).toList();
    }
    public UserDto getById(Long id) {
        return repository.findById(id).map(converter::toFront).orElse(null);
    }


}
