package com.piatrenka.service;

import com.piatrenka.converter.ArticleConverter;
import com.piatrenka.converter.ArticleGetConverter;
import com.piatrenka.dto.ArticleGetDto;
import com.piatrenka.entity.Article;
import com.piatrenka.repository.ArticleRepository;
import com.piatrenka.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleGetService {

    private final ArticleRepository repository;
    private final ArticleGetConverter articleGetConverter;

    public ArticleGetService(ArticleRepository repository, ArticleGetConverter articleGetConverter) {
        this.repository = repository;
        this.articleGetConverter = articleGetConverter;
    }

    public List<ArticleGetDto> findAll() {
        List<Article> articles = (List<Article>) repository.findAll();
        return articles.stream().map(articleGetConverter::toFront).toList();
    }
}
