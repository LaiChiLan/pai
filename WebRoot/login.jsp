<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
  <head>  
    <title>ע��</title>
	
  </head>
  
  <body>
 
    <form action="user/doLogin.do" method="get">  
 <c:choose>
  <c:when test="${!empty loginFlag}">
  	 ${loginFlag}
  </c:when>
  <c:otherwise>
               ����EKP�ʺŵ�½
  </c:otherwise>	
 </c:choose>
   
        <table>
        	<tr>
        		<td>�û�����</td>
        		<td><input type="text" name="userName" value="${user.userName}"/></td>
        	</tr>
        	<tr>
        		<td>���룺</td>
        		<td><input type="text" name="passWord" value="${user.passWord}"/></td>
        	</tr>
        	<tr>
        		<td></td>
        		<td><input type="submit" value="�� ½"> </td>
        	</tr>
        </table>

    </form>
  </body>
</html>
