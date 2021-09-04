package com.pkg.HelloWorld.Demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {

	

	 static JdbcTemplate jdbctemplate =new JdbcTemplate() ;
	
	private static final Logger logger = LoggerFactory.getLogger(FoodService.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			Integer fid=17;
			logger.info("Inside Main");
			

			String query = "update food_hub set record_updated_flag=? where food_id =?";
			int numOfrecsUpdated = jdbctemplate.update(query, 'Y', fid);
			
			System.out.println("Value in query "+query);
			System.out.println("Number of Recs Hold to Updated "+numOfrecsUpdated);

			if (numOfrecsUpdated != 0) {
			System.out.println(numOfrecsUpdated+" Number of Records Updated");
			
	          }
			else
			{
				System.out.println(numOfrecsUpdated+"Count Zero");
				
			}

}}
