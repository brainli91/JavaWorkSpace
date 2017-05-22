package dao;

import dto.IStorable;
import entities.Person;
import exceptions.NoUserException;
import exceptions.StorableNotFoundException;

public interface IStorage <T extends IStorable, P, I > {
	
	public IStorable create(T storable) throws StorableNotFoundException;
	
	public IStorable read(P uniquevalue) throws StorableNotFoundException;
	
	public void update(T oldstorable, T newstorable) throws StorableNotFoundException;
	
	public void delete(I id) throws StorableNotFoundException;
	
	
	

}