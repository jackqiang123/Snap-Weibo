package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

public class BlahDAOJdbcImpl implements BlahDAO {

	private DataSource dataSource;

	public BlahDAOJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Blah> getBlahs(Blah blah) {
		Connection conn = null;
		PreparedStatement stmt = null;
		SQLException ex = null;
		List<Blah> blahs = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn
					.prepareStatement("Select date, txt FROM t_blah where name = ?");
			stmt.setString(1, blah.getUsername());
			ResultSet rs = stmt.executeQuery();
			blahs = new LinkedList<Blah>();
			while (rs.next()) {
				blahs.add(new Blah(blah.getUsername(), rs.getTimestamp(1), rs
						.getString(2)));
			}
		} catch (SQLException e) {
			ex = e;
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(ex);
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
		return blahs;
	}

	@Override
	public void addBlah(Blah blah) {
		Connection conn = null;
		PreparedStatement stmt = null;
		SQLException ex = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn
					.prepareStatement("insert into t_blah(name,date,txt) values(?,?,?)");
			stmt.setString(1, blah.getUsername());
			stmt.setTimestamp(2, new Timestamp(blah.getDate().getTime()));
			stmt.setString(3, blah.getTxt());
			stmt.executeUpdate();
		} catch (SQLException e) {
			ex = e;
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(ex);
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
	public void deleteBlah(Blah blah) {
		Connection conn = null;
		PreparedStatement stmt = null;
		SQLException ex = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("delete from t_blah where date = ?");
			stmt.setTimestamp(1, new Timestamp(blah.getDate().getTime()));
			stmt.executeUpdate();
		} catch (SQLException e) {
			ex = e;
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(ex);
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

	public List<Blah> getSnapBlahs(int minute) {
		Connection conn = null;
		PreparedStatement stmt = null;
		SQLException ex = null;
		List<Blah> blahs = null;
		Long timelimit = (long) (minute * 60 * 1000);
		try {
			conn = dataSource.getConnection();
			stmt = conn
					.prepareStatement("Select date, name, txt From t_blah Where date > ?");
			stmt.setTimestamp(1, new Timestamp(System.currentTimeMillis() - timelimit));
			ResultSet rs = stmt.executeQuery();
			blahs = new LinkedList<Blah>();
			while (rs.next()) {
			
				blahs.add(new Blah(rs.getString(2), rs.getTimestamp(1), rs
						.getString(3)));
			}
		} catch (SQLException e) {
			ex = e;
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(ex);
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

		return blahs;
	}

}
