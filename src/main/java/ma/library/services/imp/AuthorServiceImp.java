package ma.library.services.imp;


import ma.library.entities.Author;
import ma.library.repos.AuthorRepo;
import ma.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImp implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public Author save(Author author) {
      return authorRepo.save(author);
    }
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }
    public Author update(Author author) {
        return authorRepo.save(author);
    }
    public Optional<Author> getAuthorById(Long id) {
        return  authorRepo.findById(id);
    }
    public void delete(Long id) {
          authorRepo.deleteById(id);
    }

}
