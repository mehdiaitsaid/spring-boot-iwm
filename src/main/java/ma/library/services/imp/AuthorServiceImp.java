package ma.library.services.imp;


import jakarta.transaction.Transactional;
import ma.library.dto.AuthorDto;
import ma.library.entities.Author;
import ma.library.repos.AuthorRepo;
import ma.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImp implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public Author createAuthor(AuthorDto author) {

        Author authorEntity = new Author();
        authorEntity.setName(author.getName());
        authorEntity.setBio(author.getBio());
        System.out.printf("Creating Author %s\n", author.getName());
        System.out.printf("Creating Author %s\n", authorEntity.getName());
        return authorRepo.save(authorEntity);

    }

    public Author updateAuthor(Long id, AuthorDto author) {

        Author authorEntity = authorRepo.findById(id).orElseThrow();
        authorEntity.setName(author.getName());
        authorEntity.setBio(author.getBio());
        return authorRepo.save(authorEntity);

    }


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
