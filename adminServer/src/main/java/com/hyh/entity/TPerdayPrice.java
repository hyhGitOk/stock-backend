package com.hyh.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PERDAY_PRICE")
public class TPerdayPrice {

	@Id
	@Column(name = "stock_code")
	private Integer stock_code;

	@Column(name = "date")
	private Date date;

	@Column(name = "start_price")
	private BigDecimal start_price;

	@Column(name = "end_price")
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
