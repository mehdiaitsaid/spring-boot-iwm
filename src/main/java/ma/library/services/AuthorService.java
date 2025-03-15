package ma.library.services;


import ma.library.dto.AuthorDto;
import ma.library.entities.Author;
import ma.library.repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {


    Author createAuthor(AuthorDto author);

    Author updateAuthor(Long id, AuthorDto author);
    Author save(Author author);

    List<Author> getAllAuthors();

    Author update(Author author);

    Optional<Author> getAuthorById(Long id);

    void delete(Long id);

}
