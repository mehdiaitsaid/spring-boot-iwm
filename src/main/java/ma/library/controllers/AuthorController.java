package ma.library.controllers;

import ma.library.entities.Author;
import ma.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";

    }

    @GetMapping("/create")
    public String createAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "add_author";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("author") Author author) {

        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String editAuthor(@PathVariable("id") Long id , Model model) {
        model.addAttribute("author",
                authorService.getAuthorById(id).orElseThrow(()-> new IllegalArgumentException("Author not found"))
                );
        return "edit_author";
    }

    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute("author") Author author) {
        authorService.update(author);
        return "redirect:/authors";
    }


    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorService.delete(id);
        return "redirect:/authors";
    }

}
