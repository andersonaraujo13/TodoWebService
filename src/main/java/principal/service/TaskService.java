package principal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import principal.model.Task;
import principal.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public void update(Task task) {
		taskRepository.updateTask(task.isBoFinalizado(), task.getId());
	}

	public void delete(int id) {
		taskRepository.deleteTask(id);
		
	}

	public Task create(Task task) {
		return taskRepository.save(task);		
	}
}
