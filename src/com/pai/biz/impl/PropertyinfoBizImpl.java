package com.pai.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pai.entity.Pager;
/* 
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
*/
import com.pai.biz.PropertyinfoBiz;
import com.pai.dao.PropertyinfoDao;

import com.pai.entity.PropertyInfo;
           
@Service("PropertyinfoBiz")
public class PropertyinfoBizImpl implements PropertyinfoBiz {
	@Autowired
	PropertyinfoDao propertyinfoDao;
	public void setPropertyinfoDao(PropertyinfoDao propertyinfoDao) {
		this.propertyinfoDao = propertyinfoDao;
	}
	

	public List<PropertyInfo> listPropertyInfoByStatus(String STATUS)
			throws Exception {
		// TODO Auto-generated method stub
		return propertyinfoDao.listPropertyInfoByStatus(STATUS);
	}

 
	public PropertyInfo getPropertyInfoByBianHao(String BIANHAO) throws Exception {
		// TODO Auto-generated method stub
		return propertyinfoDao.getPropertyInfoByBianHao(BIANHAO);
	}

 
	public boolean setPropertyInfoByBianHao(String BIANHAO     ) throws Exception 
	 {
		// TODO Auto-generated method stub
		return propertyinfoDao.setPropertyInfoByBianHao(BIANHAO   );
	}

 
	public boolean setPropertyInfoStatus(String BIANHAO, String STATUS)
			throws Exception {
		// TODO Auto-generated method stub
		return propertyinfoDao.setPropertyInfoStatus(BIANHAO, STATUS);
	}


	@Override
	public int getPropertyInfoSumByStatus(String STATUS) throws Exception {
		// TODO Auto-generated method stub
		return propertyinfoDao.getPropertyInfoSumByStatus(STATUS)  ;
	}


	@Override
	public List<PropertyInfo> listPropertyInfoLimtByStatus(String STATUS,
			Integer start, Integer rows) throws Exception {
		return propertyinfoDao.listPropertyInfoLimtByStatus(STATUS,start,rows)  ; 
	}

	//����ҳ��
	 public Pager getPagerOfAllPropertyInfo(int pageSize,String STATUS) throws Exception{
 
		 int count= propertyinfoDao.getPropertyInfoSumByStatus(STATUS);
			//ʹ�÷�ҳ��Pager�������
			Pager pager=new Pager();
			//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
			pager.setPerPageRows(pageSize);
			//����pager�����е�rowCount���ԣ���ʾ��¼����
			pager.setRowCount(count);
		    //����pager����
			return pager;
	 }


	@Override
	public boolean doAddsubmit(String bianhao, Integer offer, String time,
			Integer userid) throws Exception {
		// TODO Auto-generated method stub
		return propertyinfoDao.doAddsubmit(bianhao,offer,time,userid );
	}


	@Override
	public boolean doUpdatesubmit(String bianhao, Integer offer, String time,
			Integer userid) throws Exception {
		// TODO Auto-generated method stub
		return propertyinfoDao.doUpdatesubmit(bianhao, offer, time, userid) ;
	}


	@Override
	public boolean doAddPropertyInfoByBianHao_adminNew(String BIANHAO,
			String SHIYONGKESHI, String JISHENGBIANHAO, String GOUMAIRIQI,
			String GOURUJIAGE, Integer PRINCEINIT, String STARTDATE,
			String ENDDATE, String status,String BEIZHU) throws Exception {
		// TODO Auto-generated method stub
		return propertyinfoDao.doAddPropertyInfoByBianHao_adminNew(BIANHAO, SHIYONGKESHI, JISHENGBIANHAO, GOUMAIRIQI, GOURUJIAGE, PRINCEINIT, STARTDATE, ENDDATE, status,BEIZHU);	}


	@Override
	public boolean isTakePrice(String BIANHAO, Integer userId) throws Exception {
		// TODO Auto-generated method stub
		return  propertyinfoDao.isTakePrice(BIANHAO, userId) ;
	}
	
	
}
