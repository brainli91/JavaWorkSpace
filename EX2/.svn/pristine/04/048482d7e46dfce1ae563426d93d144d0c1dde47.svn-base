package dao;

import java.awt.List;
import java.util.ArrayList;

import dto.IStorable;
import dto.RequestDTO;
import exceptions.NoUserException;

public class RequestDAO implements IStorage<RequestDTO, Integer, Integer>{

	ArrayList<RequestDTO> requestList = new ArrayList<RequestDTO>();
	@Override
	public IStorable create(RequestDTO newrequest) {
		requestList.add(newrequest);
		return newrequest;
	}

	@Override
	public IStorable read(Integer id) {
		for(RequestDTO request: requestList){
			if(request.getRequest_id()==id)
				return request;
		}
		return null;
	}

	@Override
	public void update(RequestDTO oldrequest, RequestDTO newrequest) {
		for(int i =0;i< requestList.size(); i++){
			if(requestList.get(i).equals(oldrequest))
				requestList.set(i, newrequest);
		}
		// TODO Auto-generated method stub
	}

	

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		for(RequestDTO request: requestList){
			if(request.getRequest_id()==id)
				requestList.remove(request);
		}
		
	}

	
}
