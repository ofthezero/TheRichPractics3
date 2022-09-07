package com.example.Test.controllers;

import com.example.Test.models.News;
import com.example.Test.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<News> news = newsRepository.findAll();
        model.addAttribute("news",news);
        return "news/index";
    }

    @GetMapping("/add")
    public String addView(Model model)
    {
        return "news/adde-news";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("body_text") String bodyText,
            @RequestParam("views") Integer views,
            @RequestParam("likes") Integer likes,
            Model model)
    {
        News newsOne = new News(title,bodyText,author,views,likes);
        newsRepository.save(newsOne);
        return "redirect:/news/";
    }
    @GetMapping("/search")
    public String add(
            @RequestParam("title") String title,
            Model model)
    {
        List<News> newList = newsRepository.findByTitle(title);
        model.addAttribute("news",newList);

        return "news/index";
    }
    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") Long id,
            Model model)
    {
        Optional<News> news = newsRepository.findById(id);
        ArrayList<News> newsArrayList = new ArrayList<>();
        news.ifPresent(newsArrayList::add);
        model.addAttribute("news",newsArrayList);
        return "news/info-news";
    }
    @GetMapping("/del/{id}")
    public String del(
            @PathVariable("id") Long id
       )
    {
        News news = newsRepository.findById(id).orElseThrow();
        newsRepository.delete(news);

        //newsRepository.deleteById(id);
        return "redirect:/news/";
    }
    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model
    )
    {
        if (!newsRepository.existsById(id)) {
            return "redirect:/news/";
        }

        Optional<News> news = newsRepository.findById(id);
        ArrayList<News> newsArrayList = new ArrayList<>();
        news.ifPresent(newsArrayList::add);
        model.addAttribute("news", newsArrayList);
        return "news/edit-news";
    }
    @PostMapping("/edit/{id}")
    public String editNews(
            @PathVariable("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("body_text") String body_text,
            @RequestParam("views") Integer views,
            @RequestParam("likes") Integer likes,
            Model model
    )
    {

        News news = newsRepository.findById(id).orElseThrow();

        news.setTitle(title);
        news.setAuthor(author);
        news.setBody_text(body_text);
        news.setViews(views);
        news.setLikes(likes);

        newsRepository.save(news);

        return "redirect:/news/";
    }


}
