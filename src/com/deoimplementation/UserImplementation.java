package com.deoimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.datasource.DataSource;
import com.deo.UserDeo;
import com.variables.User;

public class UserImplementation implements UserDeo {

	private static final String case1 = "INSERT INTO user VALUES(?,?,?,?,?,?,?);";
	private static final String case2 = "SELECT user_name,password FROM user WHERE user_name=? AND password=?;";
	private static final String case3 = "SELECT * FROM electronic_product;";
	private static final String case4_1 = "SELECT product_id,product_name,price FROM electronic_product WHERE product_id=?;";
	private static final String case4_2 = "INSERT INTO orders VALUES(?,?,?,?,?);";
	private static final String case6_1 = "SELECT user_name FROM user WHERE user_name=?;";
	private static final String case6_2 = "UPDATE orders SET user_name=? WHERE product_id=?;";
	private static final String case6_3 = "SELECT price,order_quantity FROM orders WHERE user_name=?;";
	
	@Override
	public int case1(User user) {
		try (PreparedStatement pre = DataSource.get().prepareStatement(case1)) {
			pre.setString(1, user.first_name);
			pre.setString(2, user.last_name);
			pre.setString(3, user.user_name);
			pre.setString(4, user.password);
			pre.setString(5, user.city);
			pre.setString(6, user.mail_id);
			pre.setLong(7, user.mobile_number);
			return pre.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public static int case2(String user_name, String password,int num) {
		try (PreparedStatement pre = DataSource.get().prepareStatement(case2)) {
			pre.setString(1, user_name);
			pre.setString(2, password);

			ResultSet result = pre.executeQuery();

			if (result.next()) {
				String userName = result.getString("user_name");
				String password1 = result.getString("password");
					System.out.println("3.User view Product item as Sorted Order");
					System.out.println("4.Buy Product");
					System.out.println("5.View Cart");
					System.out.println("6.Purchase the item");
					return num;
				} else {
					System.out.println("Enter Details Again!!");
				}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public static void case3() {
		// case 3
		try (PreparedStatement pre = DataSource.get().prepareStatement(case3)) {
			ResultSet result = pre.executeQuery();
			while (result.next()) {
				int productId = result.getInt("product_id");
				String description = result.getString("description");
				String productName = result.getString("product_name");
				int price = result.getInt("price");
				int quantity = result.getInt("quantity");

				System.out.println("Product Id>>" + productId);
				System.out.println("Product Name>>" + productName);
				System.out.println("Description>>" + description);
				System.out.println("available Quantity>>" + quantity);
				System.out.println("Price>>" + price);
				System.out.println();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void case4(int product_id, int order_quantity, String user_name) {
		try (PreparedStatement preStatement = DataSource.get().prepareStatement(case4_1);
				PreparedStatement preStatement1 = DataSource.get().prepareStatement(case4_2);) {
			preStatement.setInt(1, product_id);
			ResultSet result = preStatement.executeQuery();

			while (result.next()) {
				int productId = result.getInt("product_id");
				String productName1 = result.getString("product_name");
				int price = result.getInt("price");
				preStatement1.setInt(1, productId);
				preStatement1.setString(2, productName1);
				preStatement1.setInt(4, price);
			}
			preStatement1.setInt(3, order_quantity);
			preStatement1.setString(5, user_name);
			preStatement1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void case5(String input) {
		String input1 = "Yes";

		if (input.equals(input1)) {
			System.out.println("Product item has been added to cart");
		} else {
			System.out.println();
		}

	}

	public void case6(String user_name, int product_id) {
		try (PreparedStatement preStatement = DataSource.get().prepareStatement(case6_1);
				PreparedStatement preStatement1 = DataSource.get().prepareStatement(case6_2);
				PreparedStatement preStatement2 = DataSource.get().prepareStatement(case6_3)) {
			preStatement.setString(1, user_name);

			ResultSet result = preStatement.executeQuery();

			if (result.next()) {
				String userName1 = result.getString("user_name");
					preStatement1.setString(1, userName1);
					preStatement1.setInt(2, product_id);
					preStatement1.executeUpdate();
				} else {
					System.out.println("Enter User Name Again!!");
				}

				preStatement2.setString(1, user_name);
				ResultSet result1 = preStatement2.executeQuery();

				int totalAmount = 1;

				while (result1.next()) {
					int price = result1.getInt("price");
					int productQuantity = result1.getInt("order_quantity");
					totalAmount = price * productQuantity;

				}
				System.out.println("Total bill amount>>" + totalAmount);

			}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
