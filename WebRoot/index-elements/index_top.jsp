<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%-- <%@ taglib uri='/struts-tags' prefix='s' %> --%>
 <%@ taglib uri='/struts-tags' prefix='s' %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<title>�����й�</title>
	
	<link href="CSS/main.css" rel="stylesheet" type="text/css" />
	<script language="javascript">
		function check(){
			var loginName = document.getElementById("userName");
			var loginPwd = document.getElementById("passWord");
			if(loginName.value == ""){
				alert("�û�������Ϊ�գ����������룡");
				loginName.focus();	
				loginName.focus();
				return false;
			}else if(loginPwd.value == ""){
				alert("���벻��Ϊ�գ����������룡");
				loginPwd.focus();
				return false;
			}
			return true;
		}
		
		function focusOnLogin(){
			var loginPwd = document.getElementById("passWord");
			if( loginPwd != null )
				loginPwd.focus();	
		}
	</script>
</head>
<body onload="focusOnLogin()">
<div id="header">
	<div id="top_login">	
	<s:if test="#session.user==null">
		<form action="UserAction!doLogin" method="post" onsubmit="return check()">
		    <label>�û���</label>
			<input type="text" id="userName"  name="userName" value="" class="login_input" />
			<label> ��&#160;&#160;�� </label>
			<input type="password" id="passWord" name="passWord" value="" class="login_input" />
			<input type="submit" class="login_sub" value="��¼" />
			<label id="error"> </label>			
		</form>
	</s:if>
	<s:if test="#session.user!=null">
		��ӭ�� ��<s:property value="#session.user.userName" />  &nbsp; &nbsp; &nbsp;
	<s:if test="#session.user.admin==1">
		<a href="admin.jsp">��¼����̨</a>
	</s:if>	
		 &nbsp; <a  href="propertyinfoAction!toListProcessByPager">��ҳ</a>
		 &nbsp; <a  href="UserAction!doLoginout">�˳�</a>
	</s:if>
  </div>
  <div id="nav">
	  <table>
	    <tr>
	    	<td><div id="logo"> <img src="Images/logo.jpg" alt="����" /> </div></td>
	    	<td><img src="Images/a_b01.gif" alt="" /></td>
	    </tr>
	  </table>
    <!--mainnav end-->
  </div>
</div>
</body>
</html>

