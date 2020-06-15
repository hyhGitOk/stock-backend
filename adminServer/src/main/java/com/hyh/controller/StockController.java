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

import com.hyh.dto.StockDto;
import com.hyh.entity.TStock;
import com.hyh.service.StockService;
import com.hyh.utility.CollectionUtil;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	/**
	 * Find all access level
	 * 
	 * @param request HttpServletRequest
	 * @return ResponseEntity<Iterable<TStock>>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<TStock>> findAll(HttpServletRequest request) {
		Iterable<TStock> stockList = stockService.findAll();
		if (CollectionUtil.isEmpty(stockList)) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(stockList);
	}

	/**
	 * Find stock by id
	 * 
	 * @param id stock id
	 * @return ResponseEntity<TStock>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TStock> findById(@PathVariable("id") String id) {

		TStock stock = stockService.findById(Integer.parseInt(id));
		if (stock == null) {
			return new ResponseEntity("No stock exists which id = " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(stock);
	}

	/**
	 * Create stock
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TStock> create(@RequestBody StockDto stockDto) {

		// copy values from UI
		TStock stock = new TStock();
		BeanUtils.copyProperties(stockDto, stock);

		// set new code
		int newId = stockService.getNewCode();
		stock.setCode(newId);

		// save data
		stockService.save(stock);

		return ResponseEntity.ok(stock);
	}

	/**
	 * Update stock
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<TStock> update(@RequestBody StockDto stockDto) {

		int code = stockDto.getCode();
		if (code <= 0) {
			return new ResponseEntity("code:" + code + " is wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		TStock stock = stockService.findById(code);
		if (stock == null) {
			return new ResponseEntity("No stock exists which code = " + code + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// copy specified values from UI
		stock.setCompany_id(stockDto.getCompany_id());
		stock.setExchange_id(stockDto.getExchange_id());

		// save data
		stockService.save(stock);

		return ResponseEntity.ok(stock);
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

		int flag = stockService.deleteById(Integer.parseInt(id));

		if (flag == -1) {
			return new ResponseEntity("No stock exists which id = " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok(id);
	}
}