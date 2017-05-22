package com.fdmgroup.listener;

import java.util.Vector;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.fdmgroup.model.User;

/**
 * Application Lifecycle Listener implementation class UserSessionListener
 *
 */
@WebListener
public class UserSessionListener implements HttpSessionAttributeListener {
	
	private Vector<User> users = new Vector();
	
    /**
     * Default constructor. 
     */
    public UserSessionListener() {
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent e)  { 
    	if(e.getName().equals("user") && !users.contains((User) e.getValue())){
    		users.add((User) e.getValue());
    		e.getSession().getServletContext().setAttribute("userCount", users.size());
    		
    	}
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent e)  { 
    	if(e.getName().equals("user") && users.contains((User) e.getValue())){
    		users.remove((User) e.getValue());
    		e.getSession().getServletContext().setAttribute("userCount", users.size());
    		
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    }
	
}
