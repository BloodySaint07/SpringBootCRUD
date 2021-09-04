package com.pkg.HelloWorld.Demo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class FoodService {
	
	@Autowired
	private static JdbcTemplate jdbctemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(FoodService.class);

	static int updateOldFoodRecord(Integer fid) {
		
		logger.info("Inside updateOldFoodRecord  method of FoodService Class");
		

		String query = "update food_hub set record_updated_flag=? where food_id =?";
		int numOfrecsUpdated = jdbctemplate.update(query, "Y", fid);
		
		System.out.println("Value in query "+query);
		System.out.println("Number of Recs Hold to Updated "+numOfrecsUpdated);

		if (numOfrecsUpdated != 0) {
			System.out.println(numOfrecsUpdated+" Number of Records Updated");
			return numOfrecsUpdated;

		}

		return -1;

	}
	
}
