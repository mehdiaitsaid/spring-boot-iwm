package ma.library.repos;

import ma.library.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo  extends JpaRepository<Card, Long> {
}
