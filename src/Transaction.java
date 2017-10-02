import java.sql.Connection;

@FunctionalInterface
public interface Transaction {

	void execte(Connection connection) throws Exception;
}
