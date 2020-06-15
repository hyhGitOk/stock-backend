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

import com.hyh.dto.StockExchangeDto;
import com.hyh.entity.TStockExchange;
import com.hyh.service.StockExchangeService;
import com.hyh.utility.CollectionUtil;

@RestController
@RequestMapping("/stockExchange")
public class StockExchangeController {

	@Autowired
	private StockExchangeService stockExchangeService;

	/**
	 * Find all access level
	 * 
	 * @param request HttpServletRequest
	 * @return ResponseEntity<Iterable<TStockExchange>>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<TStockExchange>> findAll(HttpServletRequest request) {
		Iterable<TStockExchange> stockExchangeList = stockExchangeService.findAll();
		if (CollectionUtil.isEmpty(stockExchangeList)) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(stockExchangeList);
	}

	/**
	 * Find stockExchange by id
	 * 
	 * @param id stockExchange id
	 * @return ResponseEntity<TStockExchange>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TStockExchange> findById(@PathVariable("id") String id) {

		TStockExchange stockExchange = stockExchangeService.findById(Integer.parseInt(id));
		if (stockExchange == null) {
			return new ResponseEntity("No stockExchange exists which id = " + id + ".",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(stockExchange);
	}

	/**
	 * Create stockExchange
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TStockExchange> create(@RequestBody StockExchangeDto stockExchangeDto) {

		// copy values from UI
		TStockExchange stockExchange = new TStockExchange();
		BeanUtils.copyProperties(stockExchangeDto, stockExchange);

		// set new id
		int newId = stockExchangeService.getNewId();
		stockExchange.setId(newId);

		// save data
		stockExchangeService.save(stockExchange);

		return ResponseEntity.ok(stockExchange);
	}

	/**
	 * Update stockExchange
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<TStockExchange> update(@RequestBody StockExchangeDto stockExchangeDto) {

		int id = stockExchangeDto.getId();
		if (id <= 0) {
			return new ResponseEntity("id:" + id + " is wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		TStockExchange stockExchange = stockExchangeService.findById(id);
		if (stockExchange == null) {
			return new ResponseEntity("No stockExchange exists which id = " + id + ".",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// copy specified values from UI
		stockExchange.setAddress(stockExchangeDto.getAddress());
		stockExchange.setBrief(stockExchangeDto.getBrief());
		stockExchange.setName(stockExchangeDto.getName());
		stockExchange.setRemarks(stockExchangeDto.getRemarks());

		// save data
		stockExchangeService.save(stockExchange);

		return ResponseEntity.ok(stockExchange);
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

		int flag = stockExchangeService.deleteById(Integer.parseInt(id));

		if (flag == -1) {
			return new ResponseEntity("No stockExchange exists which id = " + id + ".",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok(id);
	}
}