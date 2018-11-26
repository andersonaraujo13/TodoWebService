package principal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import principal.model.Postit;
import principal.model.Task;
import principal.repository.PostitRepository;

@Service
public class PostitService {
	
	@Autowired
	private PostitRepository postitRepository;
	
	public Postit create(Postit postit) {
		for(Task task : postit.getListTarefas()) {
			task.setCePostit(postit);
		}
		return postitRepository.save(postit);		
	}
	
	public Postit update(Postit postit) {
		return postitRepository.save(postit);
	}
	
	public List<Postit> listAll(){
		return postitRepository.findAll();
	}
}
