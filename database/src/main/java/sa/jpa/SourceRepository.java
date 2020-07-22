package sa.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.entities.Source;

@Repository
public interface SourceRepository extends JpaRepository<Source, String> {

}
