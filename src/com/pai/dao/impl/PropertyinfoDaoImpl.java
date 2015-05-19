package com.pai.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pai.dao.PropertyinfoDao;
import com.pai.entity.Pager;
import com.pai.entity.PropertyInfo;
/*import com.pai.entity.User;*/
import com.pai.util.DBUtil;

@Repository("PropertyinfoDao")
public class PropertyinfoDaoImpl implements PropertyinfoDao{

	@Override
	public List<PropertyInfo> listPropertyInfoByStatus(String STATUS) throws Exception {
		// TODO Auto-generated method stub
		
		List<PropertyInfo> propertyInfoS = new ArrayList<PropertyInfo>();
	    String SQL = "";
		Connection conn  = DBUtil.getConnection();
	  
	    SQL =  " select * from propertyinfo where STATUS = ? ORDER BY STARTDATE DESC";
    
	    PreparedStatement prep = conn.prepareStatement(SQL);  
	    prep.setString(1, STATUS);
        
		try {
			 
			ResultSet rst = prep.executeQuery(); 
			 while(rst.next()){
				 PropertyInfo propertyInfo = new PropertyInfo();
				 
				 propertyInfo.setBIANHAO(rst.getString("BIANHAO") ); 	
				 propertyInfo.setPINGPAI(rst.getString("PINGPAI") == null ? "-" : rst.getString("PINGPAI") ); 	
				 propertyInfo.setSHEBEIMINGCHEN(rst.getString("SHEBEIMINGCHEN") == null ? "-" : rst.getString("SHEBEIMINGCHEN") ); 			 	
				 propertyInfo.setJISHENGBIANHAO(rst.getString("JISHENGBIANHAO") == null ? "-" : rst.getString("JISHENGBIANHAO") ); 	
				 propertyInfo.setXINGHAO(rst.getString("XINGHAO") == null ? "-" : rst.getString("XINGHAO") ); 				
				 propertyInfo.setGOUMAIRIQI(rst.getString("GOUMAIRIQI") == null ? "-" : rst.getString("GOUMAIRIQI") ); 	
				 propertyInfo.setGOURUJIAGE(rst.getString("GOURUJIAGE") == null ? "-" : rst.getString("GOURUJIAGE") ); 				
				 propertyInfo.setSHIYONGKESHI(rst.getString("SHIYONGKESHI") == null ? "-" : rst.getString("SHIYONGKESHI") ); 	
				 propertyInfo.setBEIZHU(rst.getString("BEIZHU") == null ? "-" : rst.getString("BEIZHU") ); 				
				 propertyInfo.setSTATUS(rst.getString("STATUS") == null ? "-" : rst.getString("STATUS") ); 	
				 propertyInfo.setRESULT(rst.getString("RESULT") == null ? "-" : rst.getString("RESULT") ); 				
				 propertyInfo.setSTARTDATE(rst.getString("STARTDATE") == null ? "-" : rst.getString("STARTDATE") ); 	
				 propertyInfo.setENDDATE(rst.getString("ENDDATE") == null ? "-" : rst.getString("ENDDATE") ); 						
			     propertyInfo.setPRINCEINIT(rst.getString("PRINCEINIT") == null ? "-" : rst.getString("PRINCEINIT"));
			     propertyInfo.setTOPPRICE(rst.getString("TOPPRICE") == null ? "-" : rst.getString("TOPPRICE"));
			     
			     propertyInfoS.add(propertyInfo);
			 }
		 
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.close(conn);
		}
		DBUtil.close(conn);
		return propertyInfoS;
	}

	@Override
	public PropertyInfo getPropertyInfoByBianHao(String BIANHAO) throws Exception{
		// TODO Auto-generated method stub
		PropertyInfo propertyInfo = new PropertyInfo();
	    String SQL = "";
		Connection conn  = DBUtil.getConnection();
	  
	    SQL =  " select * from propertyinfo where BIANHAO = ? ";
    
	    PreparedStatement prep = conn.prepareStatement(SQL);  
	    prep.setString(1, BIANHAO);
        
		try {
			 
			ResultSet rst = prep.executeQuery(); 
			 while(rst.next()){
				 
				 propertyInfo.setBIANHAO(rst.getString("BIANHAO") ); 	
				 propertyInfo.setPINGPAI(rst.getString("PINGPAI") == null ? "-" : rst.getString("PINGPAI") ); 	
				 propertyInfo.setSHEBEIMINGCHEN(rst.getString("SHEBEIMINGCHEN") == null ? "-" : rst.getString("SHEBEIMINGCHEN") ); 			 	
				 propertyInfo.setJISHENGBIANHAO(rst.getString("JISHENGBIANHAO") == null ? "-" : rst.getString("JISHENGBIANHAO") ); 	
				 propertyInfo.setXINGHAO(rst.getString("XINGHAO") == null ? "-" : rst.getString("XINGHAO") ); 				
				 propertyInfo.setGOUMAIRIQI(rst.getString("GOUMAIRIQI") == null ? "-" : rst.getString("GOUMAIRIQI") ); 	
				 propertyInfo.setGOURUJIAGE(rst.getString("GOURUJIAGE") == null ? "-" : rst.getString("GOURUJIAGE") ); 				
				 propertyInfo.setSHIYONGKESHI(rst.getString("SHIYONGKESHI") == null ? "-" : rst.getString("SHIYONGKESHI") ); 	
				 propertyInfo.setBEIZHU(rst.getString("BEIZHU") == null ? "-" : rst.getString("BEIZHU") ); 				
				 propertyInfo.setSTATUS(rst.getString("STATUS") == null ? "-" : rst.getString("STATUS") ); 	
				 propertyInfo.setRESULT(rst.getString("RESULT") == null ? "-" : rst.getString("RESULT") ); 				
				 propertyInfo.setSTARTDATE(rst.getString("STARTDATE") == null ? "-" : rst.getString("STARTDATE") ); 	
				 propertyInfo.setENDDATE(rst.getString("ENDDATE") == null ? "-" : rst.getString("ENDDATE") ); 						
			     propertyInfo.setPRINCEINIT(rst.getString("PRINCEINIT") == null ? "-" : rst.getString("PRINCEINIT"));
			     propertyInfo.setTOPPRICE(rst.getString("TOPPRICE") == null ? "-" : rst.getString("TOPPRICE"));
			   
			    }
		 
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.close(conn);
		}
		DBUtil.close(conn);
		return propertyInfo; 
	}

	@Override
	public boolean setPropertyInfoByBianHao(String BIANHAO     )
			throws Exception {
		// TODO Auto-generated method stub
	
		  int rows;
		  String userName = null;
		  String topPrice = null;
		  
		  boolean is = true;
		    String SQL = "";
		
				Connection conn  = DBUtil.getConnection();
			    
				SQL = "SELECT  username, max(offer) as offer   FROM paimai.paimai ,user where user.userid = paimai.userid "
                   + " and bianhao =  ? ";
			    PreparedStatement prep = conn.prepareStatement(SQL);  
			    prep.setString(1, BIANHAO);
				try {
					 
					ResultSet rst = prep.executeQuery(); 
					 while(rst.next()){
						 userName = rst.getString("username") == null ? "-" : rst.getString("username");
						 topPrice = rst.getString("offer") == null ? "-" : rst.getString("offer");
					 }
					 }catch (Exception e) {
							e.printStackTrace();
							DBUtil.close(conn);
					}

				 SQL =  " update propertyinfo  set      TOPPRICE = ? ,  result = ?  "
		            		+ "  where BIANHAO = ? ";
	            prep = conn.prepareStatement(SQL); 
		        
		     
		        prep.setString(1,topPrice);
		        prep.setString(2,userName);
		        prep.setString(3,BIANHAO);
		 
		    
			try {
			    rows = prep.executeUpdate(); 
				   if (rows > 0) {
					    is =  true;
	     			    DBUtil.close(conn);
				   }else
				   {
					    is =  false;
	       		    	DBUtil.close(conn);
				   }
			} catch (Exception e) {
				e.printStackTrace();
				DBUtil.close(conn);
			} 
			
			
			
			return is; 

	}

	@Override
	public boolean setPropertyInfoStatus(String BIANHAO, String STATUS)
			throws Exception {
		// TODO Auto-generated method stub
		  int rows;
		  boolean is = true;
		    String SQL = "";
		
				Connection conn  = DBUtil.getConnection();
			    
	            SQL =  " update propertyinfo  set    STATUS =  ?  "
	            		+ "  where BIANHAO = ? ";
	            PreparedStatement prep = conn.prepareStatement(SQL); 
		        
		        prep.setString(1,BIANHAO);
		 
		    
			try {
			    rows = prep.executeUpdate(); 
				   if (rows > 0) {
					    is =  true;
	     			    DBUtil.close(conn);
				   }else
				   {
					    is =  false;
	       		    	DBUtil.close(conn);
				   }
			} catch (Exception e) {
				e.printStackTrace();
				DBUtil.close(conn);
			} 
			return is; 
	}
  
	
	public int getPropertyInfoSumByStatus(String STATUS) throws Exception{
		 int tempInt = 0;
	    String SQL = "";
		Connection conn  = DBUtil.getConnection();
	  
	    SQL =  " select count(*)  as sum1 from propertyinfo where STATUS = ? ";

	    PreparedStatement prep = conn.prepareStatement(SQL);  
	    prep.setString(1, STATUS);
	    
		try {
			 
			ResultSet rst = prep.executeQuery(); 
			 while(rst.next()){
				 tempInt = rst.getInt("sum1")  ;
			 }
	         }catch (Exception e) {
	        	e.printStackTrace();
		        DBUtil.close(conn);
   	          }   
			 
		return tempInt;
		}

	@Override
	public List<PropertyInfo> listPropertyInfoLimtByStatus(String STATUS,
			Integer start, Integer rows) throws Exception {

		List<PropertyInfo> propertyInfoS = new ArrayList<PropertyInfo>();
	    String SQL = "";
		Connection conn  = DBUtil.getConnection();
	  
	    SQL =  " select * from propertyinfo where STATUS = ? ORDER BY STARTDATE " +
	    		" limit ? , ?  ";
    
	    PreparedStatement prep = conn.prepareStatement(SQL);  
	    prep.setString(1, STATUS);
	    prep.setInt(2, start);
	    prep.setInt(3, rows);
	    //这里是计算开始数,如果是第一页的话就跳过。
	    if (start > 1 ){
	    	 start = rows * (start-1);
	    }  
	
		try {
			 
			ResultSet rst = prep.executeQuery(); 
			 while(rst.next()){
				 PropertyInfo propertyInfo = new PropertyInfo();
				 
				 propertyInfo.setBIANHAO(rst.getString("BIANHAO") ); 	
				 propertyInfo.setPINGPAI(rst.getString("PINGPAI") == null ? "-" : rst.getString("PINGPAI") ); 	
				 propertyInfo.setSHEBEIMINGCHEN(rst.getString("SHEBEIMINGCHEN") == null ? "-" : rst.getString("SHEBEIMINGCHEN") ); 			 	
				 propertyInfo.setJISHENGBIANHAO(rst.getString("JISHENGBIANHAO") == null ? "-" : rst.getString("JISHENGBIANHAO") ); 	
				 propertyInfo.setXINGHAO(rst.getString("XINGHAO") == null ? "-" : rst.getString("XINGHAO") ); 				
				 propertyInfo.setGOUMAIRIQI(rst.getString("GOUMAIRIQI") == null ? "-" : rst.getString("GOUMAIRIQI") ); 	
				 propertyInfo.setGOURUJIAGE(rst.getString("GOURUJIAGE") == null ? "-" : rst.getString("GOURUJIAGE") ); 				
				 propertyInfo.setSHIYONGKESHI(rst.getString("SHIYONGKESHI") == null ? "-" : rst.getString("SHIYONGKESHI") ); 	
				 propertyInfo.setBEIZHU(rst.getString("BEIZHU") == null ? "-" : rst.getString("BEIZHU") ); 				
				 propertyInfo.setSTATUS(rst.getString("STATUS") == null ? "-" : rst.getString("STATUS") ); 	
				 propertyInfo.setRESULT(rst.getString("RESULT") == null ? "-" : rst.getString("RESULT") ); 				
				 propertyInfo.setSTARTDATE(rst.getString("STARTDATE") == null ? "-" : rst.getString("STARTDATE") ); 	
				 propertyInfo.setENDDATE(rst.getString("ENDDATE") == null ? "-" : rst.getString("ENDDATE") ); 						
			     propertyInfo.setPRINCEINIT(rst.getString("PRINCEINIT") == null ? "-" : rst.getString("PRINCEINIT"));
			     propertyInfo.setTOPPRICE(rst.getString("TOPPRICE") == null ? "-" : rst.getString("TOPPRICE"));
			   
			     propertyInfoS.add(propertyInfo);
			 }
		 
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.close(conn);
		}
		DBUtil.close(conn);
		return propertyInfoS;
	}

	public boolean doAddsubmit(String bianhao, Integer offer ,String time , Integer userid)   throws Exception {
		    int rows;
		    boolean is  = true;
		    String SQL = "";
			Connection conn  = DBUtil.getConnection();
		  
		    SQL =  " insert into paimai(bianhao,offer,time,userid) value (?,?,?,?) "; 
		    PreparedStatement prep = conn.prepareStatement(SQL);  
		    prep.setString(1, bianhao);
		    prep.setInt(2, offer);
		    prep.setString(3, time);
		    prep.setInt(4, userid);
	        
		    try {
			    rows = prep.executeUpdate(); 
				   if (rows > 0) {
					    is =  true;
	     			    DBUtil.close(conn);
				   }else
				   {
					    is =  false;
	       		    	DBUtil.close(conn);
				   }
			} catch (Exception e) {
				e.printStackTrace();
				DBUtil.close(conn);
			} 
			return is; 		 	
	 
	}
	 
	public boolean doUpdatesubmit(String bianhao, Integer offer ,String time , Integer userid)   throws Exception {
	
		    int rows;
		    boolean is  = true;
		    String SQL = "";
			Connection conn  = DBUtil.getConnection();
		  
		 SQL = 	 "update paimai  set    offer =  ? , time = ? "
	            		+ "  where BIANHAO = ? and userid = ? ";
		
		   
		    PreparedStatement prep = conn.prepareStatement(SQL);  
		    prep.setInt(1, offer);
		    prep.setString(2, time);
		    prep.setString(3, bianhao);
		    prep.setInt(4, userid);
	        
		    try {
			    rows = prep.executeUpdate(); 
				   if (rows > 0) {
					    is =  true;
	     			    DBUtil.close(conn);
				   }else
				   {
					    is =  false;
	       		    	DBUtil.close(conn);
				   }
			} catch (Exception e) {
				e.printStackTrace();
				DBUtil.close(conn);
			} 
			return is; 	
	}
	
	public boolean doAddPropertyInfoByBianHao_adminNew
	(String BIANHAO,String SHIYONGKESHI,String JISHENGBIANHAO,String GOUMAIRIQI,String GOURUJIAGE,
			Integer PRINCEINIT,String  STARTDATE,String  ENDDATE,String status,String BEIZHU)   throws Exception {
	 
		
		  int rows;
		  boolean is = true;
		    String SQL = "";
		
				Connection conn  = DBUtil.getConnection();
			    
	            SQL =  " update propertyinfo  set    SHIYONGKESHI =  ?  , JISHENGBIANHAO = ? ,  GOUMAIRIQI = ? ,GOURUJIAGE = ? ," +
	            		" PRINCEINIT = ? , STARTDATE =? ,ENDDATE = ? , status = ? ,BEIZHU = ?"
	            		+ "  where BIANHAO = ? ";
	            PreparedStatement prep = conn.prepareStatement(SQL); 
		        
		        prep.setString(1,SHIYONGKESHI);
		        prep.setString(2,JISHENGBIANHAO);
		        prep.setString(3,GOUMAIRIQI);
		        prep.setString(4,GOURUJIAGE);
		        prep.setInt(5,PRINCEINIT);
		        prep.setString(6,STARTDATE);
		        prep.setString(7,ENDDATE);
		        prep.setString(8,status);
		        prep.setString(9,BEIZHU);
		        prep.setString(10,BIANHAO);
		       
		        
		 
		    
			try {
			    rows = prep.executeUpdate(); 
				   if (rows > 0) {
					    is =  true;
	     			    DBUtil.close(conn);
				   }else
				   {
					    is =  false;
	       		    	DBUtil.close(conn);
				   }
			} catch (Exception e) {
				e.printStackTrace();
				DBUtil.close(conn);
			} 
			return is; 
 
	}
	//查找是否已经叫价了
	public boolean isTakePrice(String BIANHAO, Integer userId) throws Exception{

		  int rows;
		  String userName = null;
		  String topPrice = null;
		  
		  boolean is = false;
		    String SQL = "";
		
				Connection conn  = DBUtil.getConnection();
			    
				SQL = "SELECT  *   FROM paimai.paimai   "
                 + " where  bianhao =  ? and userId = ? ";
			    PreparedStatement prep = conn.prepareStatement(SQL);  
			    prep.setString(1, BIANHAO);
			    prep.setInt(2, userId);
				try {
					 
					ResultSet rst = prep.executeQuery(); 
					 while(rst.next()){
						 is = true;
					 }
					 }catch (Exception e) {
							e.printStackTrace();
							DBUtil.close(conn);
					}
		
		return is;
	}
 
}
 
 
