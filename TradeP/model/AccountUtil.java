package com.tradingPlatform.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import com.tradingPlatform.model.entities.Account;
import com.tradingPlatform.model.entities.Broker;

/** Utility class for querying the database */
public class AccountUtil {

	List<Account> accounts = new ArrayList<Account>();

	public AccountUtil() {
		accounts.add(new Broker(1, "Todor", AccountTypes.BROKER));
		accounts.add(new Broker(2, "Gary", AccountTypes.BROKER));
		accounts.add(new Broker(3, "Luke", AccountTypes.SHAREHOLDER));
		accounts.add(new Broker(4, "Alex", AccountTypes.STOCK_EX_MANAGER));
		accounts.add(new Broker(5, "Gabriel", AccountTypes.STOCK_EX_MANAGER));
	}

	public void addAccount(Account account) {

		accounts.add(account);

	}
/** Remove account by a given id */
	public void removeAccountById(int id) {
		//accounts.remove(id);
		ListIterator<Account> it = accounts.listIterator();
		while (it.hasNext()) {
			//Account account = (Account) it.next();
			if (((Account) it.next()).getId() == id) {			
				it.remove();			
			}
		}
			System.out.println(accounts.size());
	}
/** Returns an Account object found by a given id */
	public Account findAccountById(int id) {
		for (Account acc : accounts) {
			if (acc.getId() == id) {
				return acc;
			}
		}
		return null;
	}
/** Returns a List Account object found by a given firstName */
	public List<Account> findAccountByFirstName(String firstName) {
		List<Account> foundAccounts = new ArrayList<Account>();
		for (Account acc : accounts) {
			if (firstName.equals(acc.getFirstName())) {
				foundAccounts.add(acc);
			}
		}
		return foundAccounts;
	}
/** Returns a List of Account objects found by a given lastName */
	public List<Account> findAccountByLastName(String lastName) {
		List<Account> foundAccounts = new ArrayList<Account>();
		for (Account acc : accounts) {
			if (acc.getLastName().equals(lastName)) {
				foundAccounts.add(acc);
			}
		}
		return foundAccounts;
	}
/** Returns a List of Account objects found by a given account type */
	public List<Account> findAccountByType(AccountTypes accType) {
		List<Account> foundAccounts = new ArrayList<Account>();
		for (Account acc : accounts) {
			if (acc.getAccountType() == accType) {
				foundAccounts.add(acc);
			}
		}
		return foundAccounts;
	}

	public void banAccountById(int id) {
		// TODO implement
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	// Database access

	// List<Account> accounts;
	//
	// public Properties getProps(){
	// Properties props = new Properties();
	// try {
	// props.load(new FileInputStream("src/main/resources/queries.properties"));
	// System.out.println(props.get("hostname"));
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return props;
	// }
	//
	// public static Connection getConnection() throws SQLException {
	// Connection connection = null;
	// try {
	// // Load the JDBC driver
	// String driverName = "oracle.jdbc.driver.OracleDriver";
	// Class.forName(driverName);
	//
	// // Create a connection to the database
	// // String serverName = "127.0.0.1";
	// // String portNumber = "1521";
	// // String sid = "mydatabase";
	// String url = "jdbc:oracle:thin:" + "TODORKOLEV1" + "@" +
	// "oracle.fdmgroup.com" + ":" + "1521" + "/" + "CAMPUS";
	// System.out.println(url);
	// // String username = "username";
	// // String password = "password";
	// connection = DriverManager.getConnection(url, "TODORKOLEV1", "password");
	// } catch (ClassNotFoundException e) {
	// // Could not find the database driver
	// }
	// return connection;
	// }
	//
	// public static void main(String[] args){
	// try {
	// Connection conn = AccountUtil.getConnection();
	// // Get a statement from the connection
	// Statement stmt = conn.createStatement();
	//
	// // Execute the query
	// ResultSet rs = stmt.executeQuery( "select * from account" ) ;
	//
	// // Loop through the result set
	// while( rs.next() )
	// System.out.println( rs.getString(1) ) ;
	//
	// // Close the result set, statement and the connection
	// rs.close() ;
	// stmt.close() ;
	// conn.close() ;
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
