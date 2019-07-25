package com.bbs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbs.beans.Bus;
import com.bbs.beans.Ticket;
import com.bbs.beans.User;

public interface DAOUser {
	//user manipulation
		public Boolean createUser(User user);
		Boolean updateUser(User user);
		public Boolean loginUser(Integer userId,String password);
		public User searchUser(Integer userId);
		public Boolean deleteUser(Integer userId,String password);
		
		
		//ticket booking
		public Ticket bookTicket(Ticket ticket);
		public Boolean cancelTicket(Integer bookingId,Integer userId);	
		Ticket getTicket(Integer bookingId, Integer userId);
		public Integer checkAvailability(Integer busId,java.sql.Date availdate);
		public List <Bus>checkAvailability(String source,String destination,java.sql.Date date);


}
