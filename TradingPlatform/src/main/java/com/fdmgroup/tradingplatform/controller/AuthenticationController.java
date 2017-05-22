package com.fdmgroup.tradingplatform.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.fdmgroup.tradingplatform.dao.CollectionRoleDAO;
import com.fdmgroup.tradingplatform.dao.CollectionUserDAO;
import com.fdmgroup.tradingplatform.databasedao.RoleDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.UserDAO_JDBC;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.User;
import com.fdmgroup.tradingplatform.view.AdminView;
import com.fdmgroup.tradingplatform.view.BrokerView;
import com.fdmgroup.tradingplatform.view.ShareholderView;

public class AuthenticationController {

	private UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();

	private RoleDAO_JDBC roleDAO = RoleDAO_JDBC.getInstance();

	AdminController ac = new AdminController();
	ShareholderController sc = new ShareholderController();
	BrokerController bc = new BrokerController();

	AdminView av = new AdminView();
	BrokerView bv = new BrokerView();
	ShareholderView sv = new ShareholderView();
	Logger userLog = Logger.getLogger("UserLogger");
	
	static Scanner scanner = new Scanner(System.in);

	public void logout(String uname) {
		User targetUser = userDAO.findByUserName(uname);
		System.out
				.println(targetUser.getFirstName() + " have been logged out.");
		userLog.info("User <" + uname + "> logged out");
		
	}

	public void registerUser(String uname, String pw, String fname,
			String lname, List<String> roles) {

		User existingUser = userDAO.findByUserName(uname);
		if (existingUser != null) {
			System.out.println("Username is already taken.");
			return;
		}

		List<Role> listRoles = new ArrayList<Role>();
		for (String name : roles) {
			Role foundRole = roleDAO.findRoleByRoleName(name);

			if (foundRole != null) {
				listRoles.add(foundRole);
			}
		}
		User user = new User(uname, fname, lname, pw, listRoles);
		User createdUser = userDAO.create(user);

		if (createdUser == null) {
			System.out
					.println("An error occurred while processing your request. Please try again.");

		}

		else {
			System.out.println("You've been successfully registered!");
			userLog.info("New user <" + uname + "> registered");

		}
	}

	public User login(String username, String password) {

		User foundUser = userDAO.findByUserName(username);
		if (foundUser == null) {
			System.out.println("User does not exist. Please register.");

		} else {
			if (foundUser.getPassWord().equals(password)) {
				System.out.println(foundUser.getUserName() + " has logged in.");
				System.out.println("Welcome " + foundUser.getFirstName());
				userLog.info("User <" + username + "> logged in");
				showDashboard(username);

				return foundUser;
			} else {
				userLog.info("User <" + username + "> failed to enter correct password");
				System.out.println("Invalid password. Please try again.");
			}
		}

		return null;
	}

	public User updatePassword(String oldPassword, String newPassword,
			String uname) {
		User foundUser = userDAO.findByUserName(uname);
		if (foundUser == null) {
			System.out
					.println("An error occurred while logging in. Please try again.");
		} else if (!oldPassword.equals(foundUser.getPassWord())) {
			System.out.println("Invalid password. Please try again.");
		} else {
			foundUser.setPassWord(newPassword);
			if ((foundUser = userDAO.update(foundUser)) == null) {
				System.out
						.println("An error occurred while udapating your password. Please Tyr Again");
			} else {
				System.out.println("Password successfully updated");
				userLog.info("User <" + uname + "> changed password");
				return foundUser;
			}
		}
		return null;

	}

	public boolean checkUserExists(String userName) {
		return (userDAO.findByUserName(userName) != null);
	}

	public void showDashboard(String uname) {
		User targetUser = userDAO.findByUserName(uname);

		for (Role role : targetUser.getRoles()) {
			int opt = -1;

			while (opt != 0) {
				if (role.getName().equalsIgnoreCase("admin")) {
					opt = av.AdminPage();

					if (opt == 1) {

						System.out.print("Username: ");
						String newUserName = scanner.nextLine();
						System.out.print("First Name: ");
						String fname = scanner.nextLine();
						System.out.print("Last Name: ");
						String lname = scanner.nextLine();
						System.out.print("Password: ");
						String pw = scanner.nextLine();

						int rolenum = -1;
						List<String> roles = new ArrayList<String>();

						while (rolenum != 0) {
							System.out
									.print("Roles(1-Admin/ 2-Shareholder/ 3-Broker/ 0 - Stop ): ");
							rolenum = scanner.nextInt();
							scanner.nextLine();

							if (rolenum == 1)
								roles.add("admin");

							else if (rolenum == 2) {
								roles.add("shareholder");
							} else if (rolenum == 3) {
								roles.add("broker");
							}
						}
						if(ac.adminAddUser(newUserName, fname, lname, pw, roles)!= null){
							userLog.info("Admin <" + uname + "> added user <" + newUserName+ ">" );
						}
						
					} else if (opt == 2) {

						System.out.print("Enter Username to Delete: ");
						String deleteUserName = scanner.nextLine();
						if(ac.adminDeleteUser(deleteUserName))
							userLog.info("Admin <" + uname + "> deleted user <" + deleteUserName+ ">" );

					} else if (opt == 3) {
						List<String> roles = new ArrayList<String>();

						System.out
								.print("Enter the User's username that requires update: ");
						String newUserName = scanner.nextLine();
						System.out.print("New First Name: ");
						String fname = scanner.nextLine();
						System.out.print("New Last Name: ");
						String lname = scanner.nextLine();
						System.out.print("New Password: ");
						String pw = scanner.nextLine();

						int rolenum = -1;

						while (rolenum != 0) {
							System.out
									.print("New Roles(1-Admin/ 2-Shareholder/ 3-Broker/ 0 - Stop ): ");
							rolenum = scanner.nextInt();
							scanner.nextLine();

							if (rolenum == 1)
								roles.add("admin");

							else if (rolenum == 2) {
								roles.add("shareholder");
							} else if (rolenum == 3) {
								roles.add("broker");
							}

						}
						if(ac.adminEditUser(newUserName, fname, lname, roles) && ac.adminResetPassword(newUserName, pw))
							userLog.info("Admin <" + uname + "> updated user <" + newUserName+ ">" );

					} else if (opt == 4) {
						ac.printUserList();
						userLog.info("Admin <" + uname + "> listed all user");
					}else if (opt == 5){
						 ac.adminReadLog("./user.log");
					}else if (opt == 0) {
						logout(uname);
					} else {
						System.out.println("Invalid Option");
						userLog.warn("Admin <" + uname + "> inputs invalid option" );
					}
				}
				if (role.getName().equalsIgnoreCase("Broker")) {
					opt = bv.BrokerPage();
					if (opt == 1) {

						List<String> roles = new ArrayList<String>();
						scanner.nextLine();
						System.out.print("Enter New Company Name: ");
						String companyName = scanner.nextLine();
						System.out.print("Enter Stock Starting Price: $");
						double startPrice = scanner.nextDouble();
						System.out
								.print("Enter the Amount of Initial Authorized Shares: ");
						int shareCount = scanner.nextInt();
						scanner.nextLine();

						if(bc.brokerAddCompany(companyName, startPrice, shareCount)!= null)
							userLog.info("Broker <" + uname + "> added new company <" + companyName+ ">" );
					} else if (opt == 2) {
						System.out.print("Enter Company Name to Delete: ");
						String deleteComapnyName = scanner.nextLine();
						if(bc.brokerDeleteCompany(deleteComapnyName))
							userLog.info("Broker <" + uname + "> deleted company <" + deleteComapnyName+ ">" );

					} else if (opt == 3) {
						scanner.nextLine();
						System.out.print("Enter Old Company Name: ");
						String oldCompanyName = scanner.nextLine();
						System.out.print("New Company Name: ");
						String newCompanyName = scanner.nextLine();
						System.out.print("New Starting Price");
						double startingPrice = scanner.nextDouble();
						scanner.nextLine();

						if(bc.brokerUpdateCompany(oldCompanyName, newCompanyName, startingPrice))
							userLog.info("Broker <" + uname + "> updated company <" + oldCompanyName + ">" );

					} else if (opt == 4) {
						bc.brokerCompanyList();
						userLog.info("Broker <" + uname + "> listed all company" );
					} else if (opt == 0) {
						logout(uname);
					} else {
						System.out.println("Invalid Option");
						userLog.warn("Shareholder <" + uname + "> inputs invalid option" );
					}
				}
				if (role.getName().equalsIgnoreCase("Shareholder")) {
					opt = sv.ShareholderPage();
					if (opt == 1) {
						scanner.nextLine();
						sc.profile(uname);
						userLog.info("Shareholder <" + uname + "> displayed profile" );
					} else if (opt == 2) {

						List<String> roles = new ArrayList<String>();

						System.out.print("Enter New First Name: ");
						String fname = scanner.nextLine();
						System.out.print("Enter New Last Name: ");
						String lname = scanner.nextLine();
						System.out.print("Enter New Password: ");
						String pw = scanner.nextLine();

						int rolenum = -1;

						while (rolenum != 0) {
							System.out
									.print("New Roles(1-Admin/ 2-Shareholder/ 3-Broker/ 0 - Stop ): ");
							rolenum = scanner.nextInt();
							scanner.nextLine();

							if (rolenum == 1)
								roles.add("admin");

							else if (rolenum == 2) {
								roles.add("shareholder");
							} else if (rolenum == 3) {
								roles.add("broker");
							}

						}
						
						if(sc.changeProfile(uname, fname, lname, roles) && ac.adminResetPassword(uname, pw))
							userLog.info("Shareholder <" + uname + "> updated profile" );
					} else if (opt == 3) {
						if (sc.showPortfolio(uname) != null)
							userLog.info("Shareholder <" + uname + "> listed portfolio" );
					} else if (opt == 4) {
						opt = sv.RequestPage();
						if (opt == 1) {
							System.out
									.println("***********BUY REQUEST**********");
							System.out
									.print("Enter the Company Name for Purchasing Stock: ");
							String companyName = scanner.nextLine();
							System.out
									.print("Enter an Amount of Buying Shares: ");
							Integer shareCount = scanner.nextInt();
							if (sc.buy(uname, companyName, shareCount))
								userLog.info("Shareholder <" + uname + "> send buy request" );
						} else if (opt == 2) {
							System.out
									.println("***********SELL REQUEST**********");

							System.out
									.print("Enter the Company Name of the Stock: ");
							String companyName = scanner.nextLine();
							System.out
									.print("Enter an Amount of Solding Shares: ");
							Integer shareCount = scanner.nextInt();
							if (sc.sell(uname, companyName, shareCount))
								userLog.info("Shareholder <" + uname + "> send sell request" );
						}

					} else if (opt == 5) {
						sc.requestsHistoryView(uname);
						userLog.info("Shareholder <" + uname + "> view request history" );
					} else if (opt == 6) {
						sc.tradeHistoryView(uname);
						userLog.info("Shareholder <" + uname + "> view trade history" );
					}
				}

			}
		}
	}
}
