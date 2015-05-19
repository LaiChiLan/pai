package com.pai.action;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/*import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

 
import com.opensymphony.xwork2.ActionSupport;*/
import java.util.Date;
import java.text.Format;
import com.pai.entity.Pager;
import com.pai.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pai.biz.PropertyinfoBiz;
import com.pai.entity.PropertyInfo;

/*@RequestMapping("/PropertyinfoAction") */
@Controller
@Scope("prototype")
@Action(value = "propertyinfoAction", results = {
 
		@Result(name = "index_sidebar_Progress", location = "/index.jsp"),
		@Result(name = "pro_read", location = "/pro_read.jsp"),
		@Result(name = "admin_new", location = "/admin_new.jsp")
		}
	 
		)
public class PropertyinfoAction extends ActionSupport implements RequestAware,SessionAware {
 //��ñ��
   String BIANHAO;
   public void setBIANHAO(String bIANHAO) {
		BIANHAO = bIANHAO;
	}
   
	public String getBIANHAO() {
	return BIANHAO;
}

	//�м�
	Integer takeprice;
	public Integer getTakeprice() {
		return takeprice;
	}

	public void setTakeprice(Integer takeprice) {
		this.takeprice = takeprice;
	}

	//ҳ��״̬
	private Pager pager;
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
  
	 
	


	@Autowired
	 private PropertyinfoBiz propertyinfoBiz;
		public void setPropertyinfoBiz(PropertyinfoBiz propertyinfoBiz) {
			this.propertyinfoBiz = propertyinfoBiz;
		}

	
	public String toListProcess( ) throws Exception {

		System.out.println("111");
		List listProgress =  (List) propertyinfoBiz.listPropertyInfoByStatus("��ʼ");
		 
 
		System.out.println("111");
		request.put("listProgress",listProgress);
	   
	    System.out.println("111");
	    return "index_sidebar_Progress"; 
	 
	}
	

	public String toListfinish( ) throws Exception {

		System.out.println("222");
		 
		List listFinished=  (List) propertyinfoBiz.listPropertyInfoByStatus("����");
		 
		System.out.println("222");
 
	    request.put("listFinished",listFinished);
	    System.out.println("222");
	    return "index_sidebar_finished"; 
	   
	}

	public String toListProcessByPager() throws Exception{
		int curPage=1;
		
		List listProgress =  null;
		
		if(pager!=null){
			curPage=pager.getCurPage();}
		
		if(pager==null){
	        //���û��ָ����ѯ��������ȡָ��ҳ��������б�
		//	newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage,10);
			  listProgress =  (List) propertyinfoBiz.listPropertyInfoLimtByStatus("��ʼ", 0, 5);
			//�ٻ����������������������ʼ����ҳ��Pager����
			pager=propertyinfoBiz.getPagerOfAllPropertyInfo(5, "��ʼ") ;	
			//pager=newsinfoBiz.getPagerOfAllNewsinfo(10);			
		}else{
			//���ָ���˲�ѯ����������������ȡָ��ҳ��������б�
			listProgress= (List) propertyinfoBiz.listPropertyInfoLimtByStatus("��ʼ", curPage, 5);
			//�ٸ������������������������������ʼ����ҳ��Pager����
			 
			pager=propertyinfoBiz.getPagerOfAllPropertyInfo(5, "��ʼ") ;
		}
		//����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		//������ʾ�ĵ�ǰҳ�����б����request��Χ
	 
		//��ȡ��������
		//List topicList=topicBiz.getAllTopics();
		//�������б����request��Χ
		//request.put("topicList", topicList);
		request.put("listProgress",listProgress);
		return "index_sidebar_Progress";
		
		
	}
	//����Ǹ��˿���
	public String getPropertyInfoByBianHao() throws Exception{
		PropertyInfo propertyInfo = new PropertyInfo();
		
		propertyInfo = propertyinfoBiz.getPropertyInfoByBianHao(BIANHAO);
		 
		session.put("BIANHAO", BIANHAO );
		request.put("propertyInfo",propertyInfo);
		return "pro_read";
	}
//����ǽм۵ģ�����Ѿ��м���PAIMAI���ڼ�¼���͸���PAIMAI	
	public String dotakePrice() throws Exception{
		 User user =(User) session.get("user");
	 	 BIANHAO =(String) session.get("BIANHAO");
	 
		 Format format = new SimpleDateFormat("yyyy-MM-dd");
		 format.format(new Date());
		  
		 //����Ѿ����ڵĻ���UPDATE �����INSERT
		 if(propertyinfoBiz.isTakePrice(BIANHAO, user.getUserId())){
			propertyinfoBiz.doUpdatesubmit(BIANHAO,   takeprice ,format.format(new Date()), user.getUserId())   ; 
		 }else{
		    propertyinfoBiz.doAddsubmit(BIANHAO, takeprice,  format.format(new Date()),  user.getUserId()) ;
		 }
		 //�ҳ����ģ����Ҹ��µ�PROPERTYINFO����
		 propertyinfoBiz.setPropertyInfoByBianHao(BIANHAO );
		 return "index_sidebar_Progress"; 
	}
//������޸ļ۸��	
	public String doUpdatePrice() throws Exception{
		 User user =(User) session.get("user");
	 	 BIANHAO =(String) session.get("BIANHAO");
	 
		 Format format = new SimpleDateFormat("yyyy-MM-dd");
		 format.format(new Date());
		 propertyinfoBiz.doUpdatesubmit(BIANHAO, takeprice,  format.format(new Date()),  user.getUserId()) ;
	  
		 return "index_sidebar_Progress"; 
	}
	
	public String getPropertyInfoByBianHao_adminNew() throws Exception{
		PropertyInfo propertyInfo = new PropertyInfo();
		
		propertyInfo = propertyinfoBiz.getPropertyInfoByBianHao(BIANHAO);
		 
		session.put("BIANHAO", BIANHAO );
		request.put("propertyInfo",propertyInfo);
		return "admin_new";
	}	 
	
	public String doAddPropertyInfoByBianHao_adminNew() throws Exception{
		BIANHAO =(String) session.get("BIANHAO");
		propertyinfoBiz.doAddPropertyInfoByBianHao_adminNew(BIANHAO, SHIYONGKESHI, JISHENGBIANHAO, GOUMAIRIQI, GOURUJIAGE, PRINCEINIT, STARTDATE, ENDDATE, "��ʼ",BEIZHU);
	  return "admin_new";
	}
	
	
	
	String SHIYONGKESHI;
	String JISHENGBIANHAO;
	String GOUMAIRIQI;
	String GOURUJIAGE;
	Integer PRINCEINIT;
	String  STARTDATE;
	String  ENDDATE;
	String status;
	String BEIZHU;
	
	
	
public String getBEIZHU() {
		return BEIZHU;
	}

	public void setBEIZHU(String bEIZHU) {
		BEIZHU = bEIZHU;
	}

public String getSHIYONGKESHI() {
		return SHIYONGKESHI;
	}

	public void setSHIYONGKESHI(String sHIYONGKESHI) {
		SHIYONGKESHI = sHIYONGKESHI;
	}

	public String getJISHENGBIANHAO() {
		return JISHENGBIANHAO;
	}

	public void setJISHENGBIANHAO(String jISHENGBIANHAO) {
		JISHENGBIANHAO = jISHENGBIANHAO;
	}

	public String getGOUMAIRIQI() {
		return GOUMAIRIQI;
	}

	public void setGOUMAIRIQI(String gOUMAIRIQI) {
		GOUMAIRIQI = gOUMAIRIQI;
	}

	public String getGOURUJIAGE() {
		return GOURUJIAGE;
	}

	public void setGOURUJIAGE(String gOURUJIAGE) {
		GOURUJIAGE = gOURUJIAGE;
	}

	public Integer getPRINCEINIT() {
		return PRINCEINIT;
	}

	public void setPRINCEINIT(Integer pRINCEINIT) {
		PRINCEINIT = pRINCEINIT;
	}

	public String getSTARTDATE() {
		return STARTDATE;
	}

	public void setSTARTDATE(String sTARTDATE) {
		STARTDATE = sTARTDATE;
	}

	public String getENDDATE() {
		return ENDDATE;
	}

	public void setENDDATE(String eNDDATE) {
		ENDDATE = eNDDATE;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

Map<String, Object> request;
@Override
public void setRequest(Map<String, Object> request) {
	this.request=request;		
}

Map<String, Object> session;
@Override
public void setSession(Map<String, Object> session) {
	this.session=session;				
}	
	
}
