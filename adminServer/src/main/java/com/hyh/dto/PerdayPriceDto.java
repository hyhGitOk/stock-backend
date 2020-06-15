package com.hyh.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PerdayPriceDto {

	private Integer stock_code;
	private Date date;
	private BigDecimal start_price;
	private BigDecimal end_price;

	public Integer getStock_code() {
		return stock_code;
	}

	public void setStock_code(Integer stock_code) {
		this.stock_code = stock_code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getStart_price() {
		return start_price;
	}

	public void setStart_price(BigDecimal start_price) {
		this.start_price = start_price;
	}

	public BigDecimal getEnd_price() {
		return end_price;
	}

	public void setEnd_price(BigDecimal end_price) {
		this.end_price = end_price;
	}
}
