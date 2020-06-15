package com.hyh.controller;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hyh.dto.CompanyDto;
import com.hyh.entity.TCompany;
import com.hyh.service.CompanyService;
import com.hyh.utility.CollectionUtil;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	/**
	 * Find all companies
	 * 
	 * @return ResponseEntity<Iterable<TCompany>>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<TCompany>> findAll() {
		Iterable<TCompany> companyList = companyService.findAll();
		if (CollectionUtil.isEmpty(companyList)) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(companyList);
	}

	/**
	 * Find company by id
	 * 
	 * @param id company id
	 * @return ResponseEntity<TCompany>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TCompany> findById(@PathVariable("id") String id) {

		TCompany company = companyService.findById(Integer.parseInt(id));
		if (company == null) {
			return new ResponseEntity("No company exists which id = " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(company);
	}

	/**
	 * Create company
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TCompany> create(@RequestBody CompanyDto companyDto) {

		// copy values from UI
		TCompany company = new TCompany();
		BeanUtils.copyProperties(companyDto, company);

		// set new id
		int newId = companyService.getNewId();
		company.setId(newId);

		// save data
		companyService.save(company);

		return ResponseEntity.ok(company);
	}

	/**
	 * Update company
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<TCompany> update(@RequestBody CompanyDto companyDto) {

		int id = companyDto.getId();
		if (id <= 0) {
			return new ResponseEntity("id:" + id + " is wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		TCompany company = companyService.findById(id);
		if (company == null) {
			return new ResponseEntity("No company exists which id = " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// copy specified values from UI
		company.setBoard_of_directors(companyDto.getBoard_of_directors());
		company.setBrief(companyDto.getBrief());
		company.setCeo_name(companyDto.getCeo_name());
		company.setName(companyDto.getName());
		company.setProfit(companyDto.getProfit());
		company.setSector_id(companyDto.getSector_id());
		company.setTurn_over(companyDto.getTurn_over());

		// save data
		companyService.save(company);

		return ResponseEntity.ok(company);
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

		int flag = companyService.deleteById(Integer.parseInt(id));

		if (flag == -1) {
			return new ResponseEntity("No company exists which id = " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok(id);
	}
}