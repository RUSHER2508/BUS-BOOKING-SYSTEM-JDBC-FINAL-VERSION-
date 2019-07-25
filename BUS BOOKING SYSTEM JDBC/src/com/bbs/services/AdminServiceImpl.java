package com.bbs.services;

import java.util.HashMap;

import com.bbs.beans.Bus;
import com.bbs.dao.AdminDaoBBS;
import com.bbs.dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminServices{

	AdminDaoBBS daoad = new AdminDaoImpl();
	@Override
	public Boolean createBus(Bus bus) {
		return daoad.createBus(bus);
	}

	@Override
	public Boolean updateBus(Bus bus) {
		return daoad.updateBus(bus);
	}

	@Override
	public Bus searchBus(int busId) {
		return daoad.searchBus(busId);
	}

	@Override
	public Boolean deletebus(int busId) {
		// TODO Auto-generated method stub
		return daoad.deletebus(busId);
	}

	@Override
	public HashMap<Integer, Bus> busBetween(String source, String destination) {
		return daoad.busBetween(source, destination);
	}


	@Override
	public Boolean adminLogin(Integer adminId, String password) {
		return daoad.adminLogin(adminId, password);
	}


}
