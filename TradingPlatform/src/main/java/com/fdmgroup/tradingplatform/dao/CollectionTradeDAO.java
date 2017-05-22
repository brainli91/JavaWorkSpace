package com.fdmgroup.tradingplatform.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.Trade;
import com.fdmgroup.tradingplatform.model.User;

public class CollectionTradeDAO implements ITradeDAO {

	private List<Trade> trades = new ArrayList<Trade>();

	private static CollectionTradeDAO tradeDAO = null;

	private CollectionTradeDAO() {
		// trades.add(new Trade(company, transactionTime, shares, sharePrice,
		// priceTotal, buyer, seller, buyRequest, sellRequest))

	}

	public static CollectionTradeDAO getInstance() {
		if (tradeDAO == null)
			tradeDAO = new CollectionTradeDAO();

		return tradeDAO;
	}

	public List<Trade> readAll() {

		return trades;
	}

	public Trade create(Trade t) {
		t.setId(generateId());
		trades.add(t);

		return t;
	}

	private Integer generateId() {
		return trades.size() + 1;
	}

	public Trade read(int id) {
		for (Trade trade : trades) {
			if (trade.getId() == id) {
				return trade;
			}
		}
		return null;
	}

	
	public Trade update(Trade t) {
		if (trades.contains(t)) {
			int i = trades.indexOf(t);
			trades.set(i, t);

			return t;
		}

		return null;
	}

	public boolean delete(Trade t) {
		return trades.remove(t);
	}

	public List<Trade> findTradeByUserName(String userName) {
		for (Trade trade : trades) {
			if (trade.getBuyer().getUserName().equals(userName))
				return trades;
		}
		return null;
	}

	public HashMap<Integer, Integer> portfolioForuser(User user) {
		HashMap<Integer, Integer> portfolio = new HashMap<Integer, Integer>();

		for (Trade trade : trades) {
			if (trade.getBuyer().equals(user) && trade.getSellRequest() == null) {
				portfolio.put(trade.getCompany().getId(), trade.getShares());
			}
		}
		for (Trade trade : trades) {
			if (trade.getBuyer().equals(user) && trade.getBuyRequest() == null) {
				Integer shares = portfolio.get(trade.getCompany().getId()) - trade.getShares();
				portfolio.put(trade.getCompany().getId(), shares);
			}
		}
		return portfolio;
	}

}
