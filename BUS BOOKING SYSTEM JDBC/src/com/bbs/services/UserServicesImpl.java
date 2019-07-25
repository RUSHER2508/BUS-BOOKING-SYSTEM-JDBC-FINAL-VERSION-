package com.bbs.services;

import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bbs.beans.Bus;
import com.bbs.beans.Ticket;
import com.bbs.beans.User;
import com.bbs.dao.DAOUser;
import com.bbs.dao.DaoUserImpl;

public class UserServicesImpl implements UserServices{
	Pattern pat = null;
	Matcher mat = null;
	

	DAOUser dao = new DaoUserImpl();
	@Override
	public Boolean createUser(User user) {
		return dao.createUser(user);
	}

	@Override
	public Boolean updateUser(User user) {
		return dao.updateUser(user);
	}


	@Override
	public Boolean loginUser(Integer userId, String password) {
		return dao.loginUser(userId, password);
	}

	@Override
	public User searchUser(Integer userId) {
		return dao.searchUser(userId);
	}

	@Override
	public Ticket bookTicket(Ticket ticket) {
		return dao.bookTicket(ticket);
	}

	@Override
	public Boolean cancelTicket(Integer bookingId,Integer userId) {
		return dao.cancelTicket(bookingId, userId);
	}

	@Override
	public Ticket getTicket(Integer bookingId,Integer userId) {
		return dao.getTicket(bookingId, userId);
	}

	@Override
	public Integer checkAvailability(Integer busId, Date availdate) {
		return dao.checkAvailability(busId, availdate);
	}

	@Override
	public List<Bus> checkAvailability(String source, String destination, Date date) {
		return dao.checkAvailability(source, destination, date);
	}

	
	@Override
	public String checkemail(String email) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(email);
		if(mat.matches()) {
			return email;
		}else {
			return null;
		}

	}

	@Override
	public Long checkContact(String contact) {
		Pattern pat = Pattern.compile("\\d{10}");
		Matcher mat = pat.matcher(contact);
		if(mat.matches()) {
			return Long.parseLong(contact);
		}else {
			return null;
		}



	
	}
	@Override
	public Integer idCheck(String userId) {

		pat = Pattern.compile("\\d+");
		mat = pat.matcher(userId);
		if(mat.matches()) {
			return Integer.parseInt(userId);
		}
		return null;
	}
	@Override
	public boolean nameCheck(String name) {

		pat = Pattern.compile("\\w+\\s\\w+");
		mat = pat.matcher(name);
		if(mat.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteUser(Integer userId, String password) {
		return dao.deleteUser(userId, password);
	}
	@Override
	public Long regexcontact(String contact) {
		Pattern pat = Pattern.compile("\\d{10}");
		Matcher mat = pat.matcher(contact);
		if(mat.matches()) {
			return Long.parseLong(contact);
		}else {
			return null;
		}



	}
}
	
