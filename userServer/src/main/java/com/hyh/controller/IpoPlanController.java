package com.hyh.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hyh.entity.TIpoPlan;
import com.hyh.service.IpoPlanService;
import com.hyh.utility.CollectionUtil;

@RestController
@RequestMapping("/api/v1/ipoPlan")
public class IpoPlanController {

	@Autowired
	private IpoPlanService ipoPlanService;

	/**
	 * Find all ipoPlans
	 * 
	 * @return ResponseEntity<Iterable<TIpoPlan>>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<TIpoPlan>> findAll() {
		Iterable<TIpoPlan> ipoPlanList = ipoPlanService.findAll();
		if (CollectionUtil.isEmpty(ipoPlanList)) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(ipoPlanList);
	}

	/**
	 * Create ipoPlan
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TIpoPlan> create(@RequestBody File ipoPlanFile) {
		// TODO 解析文件

		TIpoPlan ipoPlan = new TIpoPlan();

		// set new id
		int newId = ipoPlanService.getNewId();
		ipoPlan.setId(newId);

		// save data
		ipoPlanService.save(ipoPlan);

		return ResponseEntity.ok(ipoPlan);
	}
}