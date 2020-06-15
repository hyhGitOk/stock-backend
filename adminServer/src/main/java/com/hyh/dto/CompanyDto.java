package com.hyh.dto;

import java.math.BigDecimal;

public class CompanyDto {

	private Integer id;
	private String name;
	private BigDecimal turn_over;
	private BigDecimal profit;
	private String ceo_name;
	private String board_of_directors;
	private Integer sector_id;
	private String brief;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getTurn_over() {
		return turn_over;
	}

	public void setTurn_over(BigDecimal turn_over) {
		this.turn_over = turn_over;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public String getCeo_name() {
		return ceo_name;
	}

	public void setCeo_name(String ceo_name) {
		this.ceo_name = ceo_name;
	}

	public String getBoard_of_directors() {
		return board_of_directors;
	}

	public void setBoard_of_directors(String board_of_directors) {
		this.board_of_directors = board_of_directors;
	}

	public Integer getSector_id() {
		return sector_id;
	}

	public void setSector_id(Integer sector_id) {
		this.sector_id = sector_id;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

}
