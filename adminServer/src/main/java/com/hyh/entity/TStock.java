package com.hyh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_STOCK")
public class TStock {

	@Id
	@Column(name = "code")
	private Integer code;

	@Column(name = "exchange_id")
	private Integer exchange_id;

	@Column(name = "company_id")
	private Integer company_id;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getExchange_id() {
		return exchange_id;
	}

	public void setExchange_id(Integer exchange_id) {
		this.exchange_id = exchange_id;
	}

	public Integer getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

}
