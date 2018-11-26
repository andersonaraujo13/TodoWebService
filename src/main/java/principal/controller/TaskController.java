package principal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import principal.model.Task;
import principal.service.TaskService;

@RequestMapping(value = "/task")
@Api(tags = {"Task"})
@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Task task) {
		taskService.update(task);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idTask}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable int idTask) {
		taskService.delete(idTask);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> create(@RequestBody Task task) {
		return new ResponseEntity<Task>(taskService.create(task), HttpStatus.OK);
	}
	
	
}
