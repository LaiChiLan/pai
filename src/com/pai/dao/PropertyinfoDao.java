package com.pai.dao;

import java.util.List;

import com.pai.entity.Pager;
import com.pai.entity.PropertyInfo;

public interface PropertyinfoDao {
//对资产可以完成以下功能
/*	
    1.把他设为可以拍卖，底价，开始时间，结束时间
	2.进度(结果公布，正在处理)
	
*/
	//按进度列出的
	public List<PropertyInfo> listPropertyInfoByStatus(String STATUS) throws Exception;	//列出所有选的
    //public PropertyInfo getPropertyInfoByStatus(String STATUS) throws  Exception;
	public PropertyInfo getPropertyInfoByBianHao(String BIANHAO) throws Exception;
	//STATUS ,startdate ,enddate,priceInit  这个是admin里设的。
	public boolean setPropertyInfoByBianHao(String BIANHAO     ) throws Exception ;
	//这个是到时间后要设的
	
	public boolean setPropertyInfoStatus(String BIANHAO,String STATUS  ) throws Exception;

	//总数
	public int getPropertyInfoSumByStatus(String STATUS) throws Exception;
	//返回有限制的
	public List<PropertyInfo> listPropertyInfoLimtByStatus(String STATUS,Integer start , Integer rows) throws Exception;	//列出所有选的
	
	public boolean doAddsubmit(String bianhao, Integer offer ,String time , Integer userid)   throws Exception;
   
	public boolean doUpdatesubmit(String bianhao, Integer offer ,String time , Integer userid)   throws Exception;

	public boolean doAddPropertyInfoByBianHao_adminNew
	(String BIANHAO,String SHIYONGKESHI,String JISHENGBIANHAO,String GOUMAIRIQI,String GOURUJIAGE,
			Integer PRINCEINIT,String  STARTDATE,String  ENDDATE,String status,String BEIZHU)   throws Exception ;
	//查找是否存在已经PAIMAI的记录
	public boolean isTakePrice(String BIANHAO, Integer userId) throws Exception; 
}
