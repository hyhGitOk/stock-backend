package com.hyh.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hyh.dto.SectorDto;
import com.hyh.entity.TSector;
import com.hyh.service.SectorService;
import com.hyh.utility.CollectionUtil;

@RestController
@RequestMapping("/api/v1/sector")
public class SectorController {

	@Autowired
	private SectorService sectorService;

	/**
	 * Find all access level
	 * 
	 * @param request HttpServletRequest
	 * @return ResponseEntity<Iterable<TSector>>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<TSector>> findAll(HttpServletRequest request) {
		Iterable<TSector> sectorList = sectorService.findAll();
		if (CollectionUtil.isEmpty(sectorList)) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(sectorList);
	}

	/**
	 * Find sector by id
	 * 
	 * @param id sector id
	 * @return ResponseEntity<TSector>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TSector> findById(@PathVariable("id") String id) {

		TSector sector = sectorService.findById(Integer.parseInt(id));
		if (sector == null) {
			return new ResponseEntity("No sector exists which id = " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(sector);
	}

	/**
	 * Create sector
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TSector> create(@RequestBody SectorDto sectorDto) {

		// copy values from UI
		TSector sector = new TSector();
		BeanUtils.copyProperties(sectorDto, sector);

		// set new id
		int newId = sectorService.getNewId();
		sector.setId(newId);

		// save data
		sectorService.save(sector);

		return ResponseEntity.ok(sector);
	}

	/**
	 * Update sector
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<TSector> update(@RequestBody SectorDto sectorDto) {

		int id = sectorDto.getId();
		if (id <= 0) {
			return new ResponseEntity("id:" + id + " is wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		TSector sector = sectorService.findById(id);
		if (sector == null) {
			return new ResponseEntity("No sector exists which id = " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// copy specified values from UI
		sector.setBrief(sectorDto.getBrief());
		sector.setName(sectorDto.getName());

		// save data
		sectorService.save(sector);

		return ResponseEntity.ok(sector);
	}

	/**
	 * Delete table field by field id
	 * 
	 * @param elementId element id
	 * @param request   HttpServletRequest
	 * @return StatusDto
	 * @throws IOException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") String id) {

		int flag = sectorService.deleteById(Integer.parseInt(id));

		if (flag == -1) {
			return new ResponseEntity("No sector exists which id = " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok(id);
	}
}