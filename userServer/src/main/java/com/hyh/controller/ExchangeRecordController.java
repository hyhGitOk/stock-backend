package com.hyh.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hyh.entity.TExchangeRecord;
import com.hyh.service.ExchangeRecordService;
import com.hyh.utility.CollectionUtil;

@RestController
@RequestMapping("/api/v1/exchangeRecord")
public class ExchangeRecordController {

	@Autowired
	private ExchangeRecordService exchangeRecordService;

	/**
	 * Find all exchangeRecords
	 * 
	 * @return ResponseEntity<Iterable<TExchangeRecord>>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<TExchangeRecord>> findAll() {
		Iterable<TExchangeRecord> exchangeRecordList = exchangeRecordService.findAll();
		if (CollectionUtil.isEmpty(exchangeRecordList)) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(exchangeRecordList);
	}

	/**
	 * Create exchangeRecord
	 * 
	 * @param fieldDto ProjectFieldDto
	 * @return StatusDto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TExchangeRecord> create(@RequestBody File exchangeRecordFile) {
		// TODO 解析文件

		TExchangeRecord exchangeRecord = new TExchangeRecord();

		// save data
		exchangeRecordService.save(exchangeRecord);

		return ResponseEntity.ok(exchangeRecord);
	}
}