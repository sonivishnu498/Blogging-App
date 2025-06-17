package com.blog.blogging.util;

import com.blog.blogging.model.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
public class ArticleFileStorage {

    private static final String STORAGE_DIR = "articles";// Directory to store JSON files
    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    public ArticleFileStorage() throws IOException {
        Files.createDirectories(Paths.get(STORAGE_DIR));
    }

    public List<Article> loadAll() {
        List<Article> articles = new ArrayList<>();
        File folder = new File(STORAGE_DIR);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));

        if (files != null) {
            for (File file : files) {
                try {
                    Article article = mapper.readValue(file, Article.class);
                    articles.add(article);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // Optional: sort by date descending
        articles.sort(Comparator.comparing(Article::getPublishDate).reversed());
        return articles;
    }

    public Optional<Article> load(String id) {
        File file = new File(STORAGE_DIR, id + ".json");
        if (!file.exists()) return Optional.empty();

        try {
            return Optional.of(mapper.readValue(file, Article.class));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void save(Article article) throws IOException {
        if (article.getId() == null || article.getId().isEmpty()) {
            article.setId(UUID.randomUUID().toString());
        }
        File file = new File(STORAGE_DIR, article.getId() + ".json");
        mapper.writeValue(file, article);
    }

    public void delete(String id) {
        File file = new File(STORAGE_DIR, id + ".json");
        if (file.exists()) {
            file.delete();
        }
    }
}
