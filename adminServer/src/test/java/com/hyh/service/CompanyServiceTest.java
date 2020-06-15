package com.hyh.service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyh.AdminApplication;
import com.hyh.entity.TCompany;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { AdminApplication.class })
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class CompanyServiceTest {

	@Autowired
	private CompanyService companyService;
	private static int newId = 0;

	/**
	 * tets find all companies
	 */
	@Test
	public void test004_findAll() {

		// get companies
		Iterable<TCompany> companyList = companyService.findAll();
		Assert.assertTrue(companyList.iterator().hasNext());
	}

	/**
	 * test find company by id
	 */
	@Test
	public void test003_findById() {

		// get company
		TCompany company = companyService.findById(CompanyServiceTest.newId);
		Assert.assertTrue(company != null);
	}

	/**
	 * test Create/Update company
	 */
	@Test
	public void test002_save() {

		// save company
		TCompany companyEntity = new TCompany();
		companyEntity.setBoard_of_directors("chen yi,lu qiao,xiao ya");
		companyEntity.setBrief(
				"Sichuan bridge comnpany's main business is build bridge in these cities belong to sichuan province.");
		companyEntity.setCeo_name("chen yi");
		companyEntity.setId(CompanyServiceTest.newId);
		companyEntity.setName("Sichuan bridge");
		companyEntity.setProfit(new BigDecimal(145698000));
		companyEntity.setSector_id(1);
		companyEntity.setTurn_over(new BigDecimal(897879450));

		companyService.save(companyEntity);
	}

	/**
	 * test Delete company by id
	 */
	@Test
	public void test005_deleteById() {

		// delete company
		int ret = companyService.deleteById(CompanyServiceTest.newId);
		Assert.assertTrue(ret > 0);
	}

	/**
	 * test get new id
	 */
	@Test
	public void test001_getNewId() {

		// get new id
		CompanyServiceTest.newId = companyService.getNewId();
		Assert.assertTrue(CompanyServiceTest.newId > 0);
	}
}
