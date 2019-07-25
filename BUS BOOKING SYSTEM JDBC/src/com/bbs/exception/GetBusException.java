package com.bbs.exception;

public class GetBusException extends RuntimeException{

	public String getBus() {
		return "Bus Not Found ";
	}
}
