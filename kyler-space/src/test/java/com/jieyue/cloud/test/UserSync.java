package com.jieyue.cloud.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class UserSync {
	
	@Test
	public void syncUserByMasterData(){
		Map<String,Object> map = null;
		try{
			map.put("test", "yes");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("1");
		
	}

}
