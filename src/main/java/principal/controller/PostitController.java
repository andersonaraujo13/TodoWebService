package principal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import principal.model.Postit;
import principal.service.PostitService;

@RequestMapping(value = "/postit")
@Api(tags = {"Postit"})
@RestController
public class PostitController {
	
	@Autowired
	private PostitService postitService;
	
	@ApiOperation(	response = Postit.class, value = "Cadastro de postit",
			notes = "Insere na basa de dados um postit juntamente com a lista de tarefas referentes a ele.")
	@RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Postit> create(@RequestBody Postit postit) {
		return new ResponseEntity<Postit>(postitService.create(postit), HttpStatus.OK);
	}
	
	@ApiOperation(	response = Postit.class, value = "Atualiza postit",
			notes = "Atualiza na base de dados o postit passado.")
	@RequestMapping(method = RequestMethod.PUT, value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Postit> update(@RequestBody Postit postit) {
		return new ResponseEntity<Postit>(postitService.update(postit), HttpStatus.OK);
	}
	
	@ApiOperation(	response = Postit.class, responseContainer = "List" ,value = "Lista de postit cadastrados",
			notes = "Busca na base de dados todos os postit persistido. Postit são um conjunto de tarefas.")
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Postit>> listAll() {
		List<Postit> listPostit = postitService.listAll();
		return new ResponseEntity<List<Postit>>(listPostit, HttpStatus.OK);
	}
}
