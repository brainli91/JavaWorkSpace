package com.fdmgroup.tradingplatform.dao;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.tradingplatform.model.Company;
import com.fdmgroup.tradingplatform.model.Trade;

public class CollectionCompanyDAO implements ICompanyDAO {

	private List<Company> companies = null;

	private static CollectionCompanyDAO companyDAO = null;

	CollectionCompanyDAO() {
		companies = new ArrayList<Company>();
		companies.add(new Company(174, 174, "COCA-COLA", 390.74));
	}

	public static CollectionCompanyDAO getInstance() {
		if (companyDAO == null)
			companyDAO = new CollectionCompanyDAO();

		return companyDAO;
	}
	
	public List<Company> readAll() {
		return companies;
	}

	public Company create(Company t) {
		t.setId(generateId());
		t.setStockId(generateId());
		companies.add(t);
		return t;
	}

	private Integer generateId() {
		
		return companies.size() + 1;
	}

	public Company read(int id) {
		for (Company company : companies) {
			if (company.getId() == id) {
				return company;
			}
		}
		return null;
	}

	public Company update(Company t) {
		if (companies.contains(t)){
			int i = companies.indexOf(t);
			companies.set(i, t);
			
			return t;
		}
		
		return null;
	}

	public boolean delete(Company t) {

		return companies.remove(t);
	}

	public Company findByStockId(int stockId) {
		for (Company company : companies) {
			if (company.getStockId() == stockId) {
				return company;
			}
		}
		return null;
	}

	public Company findByName(String name) {
		for (Company company : companies) {
			if (company.getName().equals(name)) {
				return company;
			}
		}
		return null;
	}

}
