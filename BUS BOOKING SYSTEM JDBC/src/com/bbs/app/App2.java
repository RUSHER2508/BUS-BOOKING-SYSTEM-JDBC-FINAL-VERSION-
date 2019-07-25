package com.bbs.app;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.bbs.beans.Available;
import com.bbs.beans.Bus;
import com.bbs.beans.Ticket;
import com.bbs.beans.User;
import com.bbs.services.AdminServiceImpl;
import com.bbs.services.AdminServices;
import com.bbs.services.UserServices;
import com.bbs.services.UserServicesImpl;


public class App2 {
	public static void main(String[] args) {

		UserServices services =new UserServicesImpl();
		AdminServices adservices = new AdminServiceImpl();
		Scanner sc = new Scanner(System.in);
		User user = new User();
		Bus bus = new Bus();
		Boolean loop = true;
		while(loop){
			//the MAIN MENU//
			System.out.println("*********************************************");
			System.out.println("****      RUSHER BUS BOOKING SYSTEM      ****");
			System.out.println("*********************************************");
			System.out.println("** [1] Login                               **");
			System.out.println("** [2] Create Profile                      **");
			System.out.println("** [3] Admin Login                         **");
			System.out.println("** [4] Exit                                **");
			System.out.println("*********************************************");
			System.out.println("*********************************************");
			System.out.println("Enter your choice");
			int firstChoice = sc.nextInt();
			if(firstChoice == 1) {
				System.out.println("Enter User Id");
				Integer userId = services.idCheck(sc.next());
				if(userId !=null)
				{
				System.out.println("Enter the Password");
				String password = sc.next();
				boolean a = services.loginUser(userId, password);
				Boolean loop1 = true;
				if(a)
				{
					System.out.println("Login Succesfull");
					while(loop1){
						{
							System.out.println("** [1] Search Profile               **");
							System.out.println("** [2] Update Profile               **");
							System.out.println("** [3] Delete Profile               **");
							System.out.println("** [4] Book Ticket                  **");
							System.out.println("** [5] Cancel Ticket                **");
							System.out.println("** [6] Get Ticket                   **");
							System.out.println("** [7] Check availability           **");
							System.out.println("** [8] Exit                         **");


							System.out.println("***************************************");
							System.out.println("***************************************\n");

							{
								System.out.print("ENTER CHOICE: ");
								Integer	choice = sc.nextInt();

								//if CHOICE is "1" Searches User//
								if (choice == 1) {

									User search = services.searchUser(userId);
									System.out.println(search);
								}
								else if(choice == 2){
									user.setUserId(userId);
									user.setPassword(password);
									System.out.println("Enter New Username");
									user.setUsername(sc.next());
									System.out.println("Enter New Email");
									user.setEmail(sc.next());
									System.out.println("Enter New Contact");
									user.setContact(sc.nextLong());
									boolean c = services.updateUser(user);
									if(c)

									{
										System.out.println("Profile Updated");
									}else
									{
										System.out.println("Failed to update the profile");
									}
								}

								else if(choice==3) {
									boolean d = services.deleteUser(userId, password);
									if(d)
									{
										System.out.println("Profile Deleted");
									}else
									{
										System.out.println("Failed to delete the profile");
									}
								}
								else if(choice == 4) {
									Ticket ticket = new Ticket();

									System.out.println("Enter source point");
									String checksource=sc.next();
									System.out.println("Enter Destination point");
									String checkdestination=sc.next();
									System.out.println("Enter date of journey(yyyy-mm-dd)");
									String tempDate=sc.next();
									Date date=Date.valueOf(tempDate);
									ticket.setJourneyDate(date);
									List<Bus> list = 
											services.checkAvailability(checksource,checkdestination,date);

									for(Bus bs:list)
									{	

										System.out.println(bs);
										int avail = services.checkAvailability(bs.getBusId(), date);
										System.out.println("Available Seats:"+avail);
									}

									System.out.println("Enter the bus id");
									int busId=sc.nextInt();
									ticket.setBusId(busId);

									ticket.setUserId(userId);

									Integer availSeats=services.checkAvailability(busId, date);
									if(availSeats!=null){
										System.out.println("Total available seats are: "+availSeats);
									}

									System.out.println("Enter number of seats to book");
									ticket.setNumofSeats(sc.nextInt());
									Ticket bookTicket=services.bookTicket(ticket);
									if(bookTicket!=null){
										System.out.println("Ticket sucessfully Booked");
										System.out.println(services.getTicket(ticket.getBookingId(),userId));
									}else{
										try {
											throw new Exception("Ticket Booking Fail Exception");
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}	
								}
								
								else if(choice == 5) {
									System.out.println("Enter booking id");
									int bookingId = sc.nextInt();
									Boolean c = services.cancelTicket(bookingId,userId);
									if(c) {
										System.out.println("Tickets cancelled sucessfully");
									}
									else {
										System.out.println("No ticktes found");
									}
								}
								else if(choice == 6) {
									System.out.println("Enter booking id");
									int bookingId = sc.nextInt();
									Ticket ticket = services.getTicket(bookingId, userId);
									if(ticket != null) {
										System.out.println(ticket);
									}else {
										System.out.println("No Tickets Found");
									}	


								}

								else if(choice == 7) {
									Available available = new Available();
									System.out.println("Enter Source point");
									String source = sc.next();
									System.out.println("Enter Destination point");
									String destination = sc.next();
									System.out.println("Enter Date (YYYY-MM-DD)");
									String tempDate=sc.next();
									Date date=Date.valueOf(tempDate);
									available.setAvailableDate(date);
									List<Bus> list = 
											services.checkAvailability(source,destination,date);

									for(Bus bs:list)
									{	
										System.out.println(bs);
										int avail = services.checkAvailability(bs.getBusId(), date);
										System.out.println("Available Seats:"+avail);
									}
								}
								else if(choice == 8) {
									System.out.println("Thank you for visiting");
									loop1=false;
								}
							}


						}
					}
				}else
				{
					System.out.println("Login Failed");
					loop1 = false;
				}
				}else {
					
					System.err.println("Enter in Integer format");
				}


			}
			else if(firstChoice == 2){
				User user1 = new User();
				System.out.println("Enter user id");
				user1.setUserId(sc.nextInt());
				System.out.println("Enter the username");
				user1.setUsername(sc.next());
				System.out.println("Enter the email id");
				user1.setEmail(sc.next());
				System.out.println("Enter the password");
				user1.setPassword(sc.next());
				System.out.println("Enter the contact");
				user1.setContact(sc.nextLong());
				boolean b = services.createUser(user1);
				if(b)
				{
					System.out.println("Profile Created");
				}else
				{
					System.out.println("Failed to create the profile");

				}

			}
			else if(firstChoice == 3) 
			{
				System.out.println("Welcome to Admin Login");
				System.out.println("Enter User Id");
				Integer adminId = sc.nextInt();
				System.out.println("Enter the Password");
				String password = sc.next();
				Boolean a = adservices.adminLogin(adminId, password);
				Boolean loop3 = true;
				if(a) {
					System.out.println("Login successfull");
					while(loop3) {
						System.out.println("** [1] Create bus               **");
						System.out.println("** [2] Update bus               **");
						System.out.println("** [3] Search bus               **");
						System.out.println("** [4] Delete bus               **");
						System.out.println("** [5] Search between source and destination        **");
						System.out.println("** [6] Exit                                **");


						System.out.println("***************************************");
						System.out.println("***************************************\n");

						{
							System.out.print("ENTER CHOICE: ");
							Integer	choice = sc.nextInt();

							if(choice==1) {
								Bus bus1 = new Bus();
								System.out.println("Enter bus id");
								bus1.setBusId(sc.nextInt());
								System.out.println("Enter bus name");
								bus1.setBusName(sc.next());
								System.out.println("Enter bus source");
								bus1.setSource(sc.next());
								System.out.println("Enter the destination");
								bus1.setDestination(sc.next());
								System.out.println("Enter bus type");
								bus1.setBusType(sc.next());
								System.out.println("Enter the total seats");
								bus1.setTotalSeats(sc.nextInt());
								Boolean b = adservices.createBus(bus1);
								System.out.println(b);
							}
							else if(choice == 2) {
								Boolean b1 = adservices.updateBus(bus);
								System.out.println(b1);


							}
							else if(choice == 3) {
								System.out.println("Enter the bus id");
								int busId = sc.nextInt();
								Bus b = adservices.searchBus(busId);
								System.out.println(b);

							}
							else if(choice == 4) {
								System.out.println("Enter the bus id");
								int busId = sc.nextInt();
								Boolean b = adservices.deletebus(busId);
							}

							else if(choice == 5) {
								System.out.println("Enter source");
								String source = sc.next();
								System.out.println("Enter the destination");
								String destination = sc.next();
								HashMap<Integer, Bus> b = adservices.busBetween(source, destination);
								System.out.println(b);

							}

							else if(choice == 6) {
								System.out.println("Exit");
								loop3= false;
							}

							else {
								System.out.println("Unsuccessfull");
							}
						}
					}
				}
			}
			else if(firstChoice ==4) {
				loop =  false;
				System.out.println("Thank you for visting");

			}


		}

	}






}

