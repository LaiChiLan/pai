<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>
<div class="sidebar1">
    <h1> <img src="Images/title_2.gif" alt="��������" /> </h1>
    <div class="side_list1">
      <ul>    
        <!-- ѭ����ʾ5����������  -->  	  
      	<s:iterator id="finished" value="#request.listFinished">
      		<li> <a href='newsread?id=${finished.BIANHAO}'><b> ${finished.SHEBEIMINGCHEN}</b></a> </li>
      		<br>
      	</s:iterator>
      </ul>
    </div>
   
  </div>

