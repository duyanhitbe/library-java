package doba.app.library.repositories;

import doba.app.library.entities.BorrowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BorrowerRepository extends JpaRepository<BorrowerEntity, UUID> {
    Optional<BorrowerEntity> findByPhone(String phone);
}
