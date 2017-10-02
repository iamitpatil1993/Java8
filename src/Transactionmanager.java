import java.sql.Connection;

public class Transactionmanager {

	public static void execute(Transaction transaction) {

		// create connection here
		Connection connection = null;

		System.out.println("Executing code in transaction");
		try {
			transaction.execte(connection);
			System.out.println("Done with executing code in transaction");
		} catch (Exception e) {
			System.out.println("something went wrong while processing the request");
			e.printStackTrace();
		}

	}

}
