<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>
<div class="sidebar">
    <h1> <img src="Images/title_1.gif" alt="��������" /> </h1>
    <div class="side_list">
      <ul>    
        <!-- ѭ����ʾ5����������  -->  	  
      	<s:iterator id="Progress" value="#request.listProgress">
      		<li> <a href='newsread?id=${Progress.BIANHAO}'><b> ${Progress.SHEBEIMINGCHEN}</b></a> </li>
      		<br>
      	</s:iterator>
      </ul>
<%--          <s:if test="pager.curPage>1">
            <p align="center">
			    <a href='index?pager.curPage=1&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>��ҳ</a>
			    <a href='index?pager.curPage=${pager.curPage-1 }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>��һҳ</a>
		    </p>
		</s:if>		
--%>
		<s:if test="pager.curPage < pager.pageCount">
		  <p align="center">
		   <a href='propertyinfoAction!toListProcessByPager?pager.curPage=1'>��ҳ</a>
		   <a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage-1 }'>��һҳ</a>
			<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.curPage+1}'>��һҳ</a>
			<a href='propertyinfoAction!toListProcessByPager?pager.curPage=${pager.pageCount}'>βҳ</a>
		  </p>
		</s:if>
    </div>
    
  </div>

