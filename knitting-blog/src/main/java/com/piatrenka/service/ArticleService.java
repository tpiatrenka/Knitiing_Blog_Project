package com.piatrenka.service;

import com.piatrenka.converter.ArticleConverter;
import com.piatrenka.dto.ArticleDto;
import com.piatrenka.entity.Article;
import com.piatrenka.entity.User;
import com.piatrenka.repository.ArticleRepository;
import com.piatrenka.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class ArticleService {
    private final ArticleRepository repository;
    private final ArticleConverter articleConverter;
    private final UserRepository userRepository;

    public ArticleService(ArticleRepository repository, ArticleConverter articleConverter, UserRepository userRepository) {
        this.repository = repository;
        this.articleConverter = articleConverter;
        this.userRepository = userRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public Long addArticle(ArticleDto articleDto) throws Exception {
        Long userId = articleDto.userId();
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("id: " + userId);
        }
        User user = userOptional.get();
        Article articleToAdd = articleConverter.toLocal(articleDto);
        articleToAdd.setUser(user);
        articleToAdd.setDate(new Date());
        Article article = repository.save(articleToAdd);
        return article.getId();
    }

    public List<ArticleDto> findAll() {
        List<Article> articles = (List<Article>) repository.findAll();
        return articles.stream().map(articleConverter::toFront).toList();
    }
}