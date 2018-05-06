package com.nationwide.coatsn.bearboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class GUIDController {

	private static final Logger log = LoggerFactory.getLogger(GUIDController.class);

	@Autowired
	private GUIDRepository guidRepository;

	@RequestMapping("/uuid")
	public GUID guid() {
		RestTemplate restTemplate = new RestTemplate();
		GUID guid = restTemplate.getForObject("http://httpbin.org/uuid", GUID.class);
		log.info("trying to save..." + guid.toString());
		guidRepository.save(guid);
		log.info("..saved." + guid.toString());
		return guid;
	}

	@RequestMapping("/uuids/{id}")
	public GUID guidById(@PathVariable("id") Long id) {
		System.out.println("get guid by id... " + id);
		Optional<GUID> guid = guidRepository.findById(id);
		System.out.println("...guid: " + guid.get());
		GUID guidActual = guid.get();
		return guidActual;
	}

	@RequestMapping("/uuids")
	public List<GUID> guids() {
		log.info("retrieving all guids..");
		return (List<GUID>) guidRepository.findAll();
		// return new ArrayList<GUID>();
	}

	public GUIDRepository getGuidRepository() {
		return guidRepository;
	}

	public void setGuidRepository(GUIDRepository guidRepository) {
		this.guidRepository = guidRepository;
	}

}