<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="index-elements/index_top.jsp" />
<div id="container">
<!-- ��AJAX��� -->
 <%--
   <s:action name="propertyinfoAction!toListProcess" namespace="/" executeResult="true" />   
   <s:action name="propertyinfoAction!toListfinish" namespace="/" executeResult="true" />   
 --%>
 <div class="sidebar">
 <ul class ="side_list1">
    <li><a href="propertyinfoAction!toListProcessByPager" >���ڽ�����..</a></li>
    <li><a>�ҵľ�Ͷ��¼</a></li>
    <li><a>���н������</a></li>
 <%--    <s:if test="#session.user.admin==1">
		 <li><a href="propertyinfoAction!toListProcessByPager" >�½�</a></li>
    	<li><a>�޸�</a></li>
	</s:if>	 --%>
 </ul>
 </div>
 <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="��������" /> </div>
    <div class="content">
      <ul class="class_date">
      	<li id='class_month'>    
      	 <!-- ѭ����ʾ�����б� -->  	
      <%-- 	 <s:iterator id="topic" value="#request.topicList">
      	 	<a href="index?newsinfo.topic.id=${topic.id}"><b>${topic.name}</b></a>
      	 </s:iterator> --%>
      </ul>
      <ul class="classlist"> 
        <!-- ѭ����ʾ��ǰҳ�����б� -->     
        <s:iterator id="Progress" value="#request.listProgress">
         <li><a href="propertyinfoAction!getPropertyInfoByBianHao?BIANHAO=${Progress.BIANHAO}">${Progress.BIANHAO}-${Progress.PINGPAI}-${Progress.SHEBEIMINGCHEN}-��Ͷ����ʱ�䣺${propertyInfo.ENDDATE}  </a>
      	 <%--    <span> ${newsinfo.createDate}</span> --%>
      	 </li>
        </s:iterator>     
        <br> <br>
        
        <!-- ��ҳ�����Ӳ��� -->
	    <s:if test="pager.curPage == 1 and pager.pageCount !=1" > 
	     <p align="center">
		 	<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage+1}'>��һҳ</a>
			<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.pageCount}'>βҳ</a>
	     </p>
	    </s:if>	
		<s:if test="pager.curPage < pager.pageCount and pager.curPage>1">
		  <p align="center">
		    <a href='propertyinfoAction!toListProcessByPager?pager.curPage=1'>��ҳ</a>
		    <a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage-1 }'>��һҳ</a>
			<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage+1}'>��һҳ</a>
			<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.pageCount}'>βҳ</a>
		   </p>
		</s:if>
		<s:if test="pager.curPage == pager.pageCount and pager.curPage != 1">
		  <p align="center">
		    <a href='propertyinfoAction!toListProcessByPager?pager.curPage=1'>��ҳ</a>
		    <a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage-1 }'>��һҳ</a>
 
		   </p>
		</s:if>
       </ul>
    </div>   
  </div> 
   
  </div>
 
