package com.hyh.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ExchangeRecordDto {

	private Integer stock_code;
	private Date date;
	private BigDecimal exhange_price;
	private Integer exchange_amount;
	private Timestamp exchange_time;
	private Integer seller_id;
	private Integer buyer_id;

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

	public BigDecimal getExhange_price() {
		return exhange_price;
	}

	public void setExhange_price(BigDecimal exhange_price) {
		this.exhange_price = exhange_price;
	}

	public Integer getExchange_amount() {
		return exchange_amount;
	}

	public void setExchange_amount(Integer exchange_amount) {
		this.exchange_amount = exchange_amount;
	}

	public Timestamp getExchange_time() {
		return exchange_time;
	}

	public void setExchange_time(Timestamp exchange_time) {
		this.exchange_time = exchange_time;
	}

	public Integer getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}

	public Integer getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(Integer buyer_id) {
		this.buyer_id = buyer_id;
	}

}
