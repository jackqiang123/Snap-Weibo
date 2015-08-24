package web;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import model.AccountDAOJdbcImpl;
import model.BlahDAOJdbcImpl;
import model.UserService;

/**
 * Application Lifecycle Listener implementation class WeiboListener
 *
 */
@WebListener
public class WeiboListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public WeiboListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    		Context initContext;
			try {
				
				initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:/comp/env");
				DataSource dataSource = (DataSource) envContext.lookup("jdbc/weibo");
				
				
				
//				System.out.print("i am here!!!!!=--------=====！");
//				try {
//					java.sql.Connection temp =  dataSource.getConnection();
//					Statement stmt = temp.createStatement(); //创建Statement对象
//		            System.out.print("成功连接到数据库！");
//		            //rs = stmt.executeQuery("select * from mysql");  
//		            
//		           
//		            
//		            stmt = temp.createStatement();
//		            ResultSet rs = stmt.executeQuery("select * from user");
//		            while (rs.next()) {
//		                System.out.println(rs.getString("name") + "," + rs.getString("password"));
//		              }
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
				
				
				
				
				
				ServletContext context = sce.getServletContext();
				context.setAttribute("userService", new UserService(new AccountDAOJdbcImpl(dataSource), new BlahDAOJdbcImpl(dataSource)));
						
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
    	
        	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
