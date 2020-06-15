package com.hyh.dto;

import java.math.BigDecimal;
import java.util.Date;

public class IpoPlanDto {

	private Integer id;
	private Integer company_id;
	private Integer exchange_id;
	private BigDecimal pre_price;
	private Integer total_amount;
	private Date open_date;
	private String brief;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

	public Integer getExchange_id() {
		return exchange_id;
	}

	public void setExchange_id(Integer exchange_id) {
		this.exchange_id = exchange_id;
	}

	public BigDecimal getPre_price() {
		return pre_price;
	}

	public void setPre_price(BigDecimal pre_price) {
		this.pre_price = pre_price;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public Date getOpen_date() {
		return open_date;
	}

	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}
}
