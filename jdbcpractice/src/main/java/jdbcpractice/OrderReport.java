package jdbcpractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderReport {

	public static void main(String[] args) {
		try (Connection conn = DBConnection.getConnection()) {
			if (conn != null) {
				System.out.println("Connected to database.\n");

				top3BestSellingProducts(conn);
				System.out.println("\n------------------------\n");

				customersWithNoOrders(conn);
				System.out.println("\n------------------------\n");

				productWiseRevenueReport(conn);
				System.out.println("\n------------------------\n");

				topCustomerByPurchase(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Your methods (top3BestSellingProducts, customersWithNoOrders, etc.) remain
	// the same
	// Just use the Connection object passed in as before

	public static void top3BestSellingProducts(Connection conn) throws SQLException {
		String query = "SELECT p.id, p.name, SUM(oi.qty) AS total_quantity_sold " + "FROM order_items oi "
				+ "JOIN products p ON oi.prod_id = p.id " + "GROUP BY p.id, p.name "
				+ "ORDER BY total_quantity_sold DESC " + "LIMIT 3";

		try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
			System.out.println("Top 3 Best-Selling Products:");
			while (rs.next()) {
				System.out.printf("Product ID: %d, Name: %s, Quantity Sold: %d%n", rs.getInt("id"),
						rs.getString("name"), rs.getInt("total_quantity_sold"));
			}
		}
	}

	public static void customersWithNoOrders(Connection conn) throws SQLException {
		String query = "SELECT c.id, c.name, c.email " + "FROM customers c " + "LEFT JOIN orders o ON c.id = o.cust_id "
				+ "WHERE o.id IS NULL";

		try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
			System.out.println("Customers with No Orders:");
			while (rs.next()) {
				System.out.printf("Customer ID: %d, Name: %s, Email: %s%n", rs.getInt("id"), rs.getString("name"),
						rs.getString("email"));
			}
		}
	}

	public static void productWiseRevenueReport(Connection conn) throws SQLException {
		String query = "SELECT p.id, p.name, " + "SUM(oi.qty) AS total_quantity_sold, "
				+ "SUM(oi.qty * p.price) AS total_revenue " + "FROM order_items oi "
				+ "JOIN products p ON oi.prod_id = p.id " + "GROUP BY p.id, p.name " + "ORDER BY total_revenue DESC";

		try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
			System.out.println("Product-Wise Revenue Report:");
			while (rs.next()) {
				System.out.printf("Product ID: %d, Name: %s, Quantity Sold: %d, Revenue: %.2f%n", rs.getInt("id"),
						rs.getString("name"), rs.getInt("total_quantity_sold"), rs.getDouble("total_revenue"));
			}
		}
	}

	public static void topCustomerByPurchase(Connection conn) throws SQLException {
		String query = "SELECT c.id, c.name, c.email, " + "SUM(oi.qty * p.price) AS total_spent "
				+ "FROM customers c " + "JOIN orders o ON c.id = o.cust_id "
				+ "JOIN order_items oi ON o.id = oi.id " + "JOIN products p ON oi.prod_id = p.id "
				+ "GROUP BY c.id, c.name, c.email " + "ORDER BY total_spent DESC " + "LIMIT 1";

		try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
			System.out.println("Top Customer by Purchase:");
			if (rs.next()) {
				System.out.printf("Customer ID: %d, Name: %s, Email: %s, Total Spent: %.2f%n", rs.getInt("id"),
						rs.getString("name"), rs.getString("email"), rs.getDouble("total_spent"));
			}
		}
	}
}
