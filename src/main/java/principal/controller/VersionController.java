package principal.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RequestMapping(value = "/config")
@Api(tags = {"Config"})
@RestController
public class VersionController {

	@RequestMapping(method = RequestMethod.GET, value = "/version", produces = MediaType.TEXT_PLAIN_VALUE)
	public String version() {
		return "release 1.0.0";
	}
}
