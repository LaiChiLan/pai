package com.pai.dao;

import java.util.List;

import com.pai.entity.Pager;
import com.pai.entity.PropertyInfo;

public interface PropertyinfoDao {
//���ʲ�����������¹���
/*	
    1.������Ϊ�����������׼ۣ���ʼʱ�䣬����ʱ��
	2.����(������������ڴ���)
	
*/
	//�������г���
	public List<PropertyInfo> listPropertyInfoByStatus(String STATUS) throws Exception;	//�г�����ѡ��
    //public PropertyInfo getPropertyInfoByStatus(String STATUS) throws  Exception;
	public PropertyInfo getPropertyInfoByBianHao(String BIANHAO) throws Exception;
	//STATUS ,startdate ,enddate,priceInit  �����admin����ġ�
	public boolean setPropertyInfoByBianHao(String BIANHAO     ) throws Exception ;
	//����ǵ�ʱ���Ҫ���
	
	public boolean setPropertyInfoStatus(String BIANHAO,String STATUS  ) throws Exception;

	//����
	public int getPropertyInfoSumByStatus(String STATUS) throws Exception;
	//���������Ƶ�
	public List<PropertyInfo> listPropertyInfoLimtByStatus(String STATUS,Integer start , Integer rows) throws Exception;	//�г�����ѡ��
	
	public boolean doAddsubmit(String bianhao, Integer offer ,String time , Integer userid)   throws Exception;
   
	public boolean doUpdatesubmit(String bianhao, Integer offer ,String time , Integer userid)   throws Exception;

	public boolean doAddPropertyInfoByBianHao_adminNew
	(String BIANHAO,String SHIYONGKESHI,String JISHENGBIANHAO,String GOUMAIRIQI,String GOURUJIAGE,
			Integer PRINCEINIT,String  STARTDATE,String  ENDDATE,String status,String BEIZHU)   throws Exception ;
	//�����Ƿ�����Ѿ�PAIMAI�ļ�¼
	public boolean isTakePrice(String BIANHAO, Integer userId) throws Exception; 
}
