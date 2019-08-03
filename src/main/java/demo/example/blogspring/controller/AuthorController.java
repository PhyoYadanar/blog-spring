package demo.example.blogspring.controller;

import demo.example.blogspring.model.Author;
import demo.example.blogspring.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {
    private AuthorService authorService;
    @GetMapping("/author")
    public String create(Model model){
        model.addAttribute("author",new Author());
    return "authorForm";
    }
    public String process(Author author, BindingResult result){
    if (result.hasErrors()){
        return "authorForm";
    }
    authorService.create(author);
    return "redirect:/authors";
    }
    public String showallAuthors(Model model){
        model.addAttribute("authors",authorService.findAll());
        return "authors";
    }
}
