package principal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import principal.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	@Transactional
	@Modifying
	@Query("update Task e set e.boFinalizado = ?1 where e.id = ?2")
	public void updateTask(boolean status, int id);
	
	@Transactional
	@Modifying
	@Query("delete from Task e where e.id = ?1")
	public void deleteTask(int id);
}
