package datastructure.connectionpool;

/**
 * Custom Interface for the basic Connection Pool.
 * 
 * @author svivaramneni
 * @since company 1.0.0
 */
public interface CustomConnectionPool extends ConnectionPool {

	/**
	 * Method to calculate number of available connections in the pool.
	 * 
	 * @return number of available connections.
	 */
	public int getNumberOfAvailableConnections();

	/**
	 * Method to calculate number of busy connections in the pool.
	 * 
	 * @return number of busy connections.
	 */
	public int getNumberOfBusyConnections();

	/**
	 * Method to close all the connections.
	 */
	public void closeAllConnections();

}
