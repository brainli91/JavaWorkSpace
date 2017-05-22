package com.fdmgroup.tradingplatform.model;

import java.io.Serializable;
import java.sql.Date;

public class AuthorizedShare implements IStorable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Company company;
	private Date timeStart;
	private Date timeEnd;
	private Integer authorized;

	@Override
	public String toString() {
		return "AuthorizedShare [company=" + company + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd
				+ ", authorized=" + authorized + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorized == null) ? 0 : authorized.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((timeEnd == null) ? 0 : timeEnd.hashCode());
		result = prime * result + ((timeStart == null) ? 0 : timeStart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorizedShare other = (AuthorizedShare) obj;
		if (authorized == null) {
			if (other.authorized != null)
				return false;
		} else if (!authorized.equals(other.authorized))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (timeEnd == null) {
			if (other.timeEnd != null)
				return false;
		} else if (!timeEnd.equals(other.timeEnd))
			return false;
		if (timeStart == null) {
			if (other.timeStart != null)
				return false;
		} else if (!timeStart.equals(other.timeStart))
			return false;
		return true;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Integer getAuthorized() {
		return authorized;
	}

	public void setAuthorized(Integer authorized) {
		this.authorized = authorized;
	}

}
