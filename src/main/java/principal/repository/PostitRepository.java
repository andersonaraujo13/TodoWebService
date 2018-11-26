package principal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import principal.model.Postit;

public interface PostitRepository extends JpaRepository<Postit, Integer>{

}
