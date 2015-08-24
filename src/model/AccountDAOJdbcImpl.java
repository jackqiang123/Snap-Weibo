package model;

import java.sql.*;

import javax.sql.DataSource;

public class AccountDAOJdbcImpl implements AccountDAO {

	private DataSource dataSource;

	public AccountDAOJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean isUserExisted(Account account) {
		Connection conn = null;
		PreparedStatement stmt = null;
		// SQLException ex = null;
		boolean existed = false;

		try {

			conn = dataSource.getConnection();

			stmt = conn
					.prepareStatement("Select COUNT(1) FROM t_account WHERE name = ?");
			stmt.setString(1, account.getName());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				existed = (rs.getInt(1) == 1);
			}
		} catch (SQLException e) {
			// ex = e;
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}

		return existed;
	}

	@Override
	public void addAccount(Account account) {
		Connection conn = null;
		PreparedStatement stmt = null;
		// SQLException ex = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn
					.prepareStatement("Insert into t_account(name,password,email) values(?,?,?)");
			stmt.setString(1, account.getName());
			stmt.setString(2, account.getPassword());
			stmt.setString(3, account.getEmail());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// ex = e;
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}

	}

	@Override
	public Account getAccount(Account account) {
		Connection conn = null;
		PreparedStatement stmt = null;
		// SQLException ex = null;
		Account acct = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn
					.prepareStatement("select password, email from t_account where name = ?");
			stmt.setString(1, account.getName());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				acct = new Account(account.getName(), rs.getString(1),
						rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// ex = e;
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return acct;

	}

}
