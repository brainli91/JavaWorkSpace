package com.fdmgroup.tradingplatform.model;

import java.io.Serializable;

public class Share implements IStorable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Company company;
	private int shareCount;
	private User shareHolder;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getShareCount() {
		return shareCount;
	}

	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}

	public User getShareHolder() {
		return shareHolder;
	}

	public void setShareHolder(User shareHolder) {
		this.shareHolder = shareHolder;
	}

	@Override
	public String toString() {
		return "Share [company=" + company + ", shareCount=" + shareCount
				+ ", shareHolder=" + shareHolder + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + shareCount;
		result = prime * result
				+ ((shareHolder == null) ? 0 : shareHolder.hashCode());
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
		Share other = (Share) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (shareCount != other.shareCount)
			return false;
		if (shareHolder == null) {
			if (other.shareHolder != null)
				return false;
		} else if (!shareHolder.equals(other.shareHolder))
			return false;
		return true;
	}

}
