package doba.app.library.repositories;

import doba.app.library.entities.BookInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfoEntity, UUID> {
}
