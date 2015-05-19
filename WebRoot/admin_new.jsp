<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<meta   http-equiv="Content-Type"   content="text/html;   charset=UTF-8">
<script src="js/laydate/laydate.js"></script>
<script>
;!function(){

//laydate.skin('molv');

laydate({
   elem: '#demo'
});

}();
</script>
<jsp:include page="index-elements/index_top.jsp" />
<div id="container">
<!-- 用AJAX解决 -->
 
 <div class="sidebar">
 <ul class ="side_list1">
    <li><a href="propertyinfoAction!getPropertyInfoByBianHao_adminNew" >新建</a></li>
    <li><a>修改</a></li>
 
 </ul>
 </div>
 <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
		<table width="80%" align="center">
		<tr width="100%">
		<td colspan="2" align="center">
		<tr>
		    <form   action="propertyinfoAction!getPropertyInfoByBianHao_adminNew" method="get"  >  
				<p>请输入资产:&nbsp;&nbsp;
				<input type="text" name="BIANHAO" value="${propertyInfo.BIANHAO}"/>
				<input type="submit" value="查  询" style="height: 54px; width: 105px; vertical-align: middle;"/>
				</p>
			</form>
		</tr>
         <s:if test="#request.propertyInfo!=null">
         <form   action="propertyinfoAction!doAddPropertyInfoByBianHao_adminNew" method="get"  >  
             <p>使用科室：&nbsp;&nbsp;
             <input type="text" name="SHIYONGKESHI" value="${propertyInfo.SHIYONGKESHI}"/>
             </p>
             <p>型号：&nbsp;&nbsp; &nbsp;&nbsp;    &nbsp;&nbsp; 
             <input type="text" name="XINGHAO" value="${propertyInfo.XINGHAO}"/>
             </p>
             <p>机身编号： &nbsp;&nbsp;
             <input type="text" name="JISHENGBIANHAO" value="${propertyInfo.JISHENGBIANHAO}"/>
             </p>
             <p>购买时间： &nbsp;&nbsp; 
             <input type="text" name="GOUMAIRIQI" value="${propertyInfo.GOUMAIRIQI}"/>
             </p>  
             <p>购买价格：   &nbsp;&nbsp;  
             <input type="text" name="GOURUJIAGE" value="${propertyInfo.GOURUJIAGE}"/>
             </p>    
             <p>底价：  &nbsp;&nbsp;  &nbsp;&nbsp;   &nbsp;&nbsp;   
             <input type="text" name="PRINCEINIT" value="${propertyInfo.PRINCEINIT}"/>
             
                  <p>竞投开始时间：  &nbsp;&nbsp;  
          <%--    <input type="text" name="PRINCEINIT" value="${propertyInfo.PRINCEINIT}"/> --%>
           
                  <input placeholder="请输入日期" class="laydate-icon" onclick="laydate()" name="STARTDATE" value="${propertyInfo.STARTDATE}"/>
      
              <p>竞投结束时间：  &nbsp;&nbsp;    
             <input placeholder="请输入日期" class="laydate-icon" onclick="laydate()" name="ENDDATE" value="${propertyInfo.ENDDATE}"/>
             </p>
               <p>
           <%--   <s:textarea label="备注:" name="BEIZHU" cols="40" rows="3" value="#request.propertyInfo.BEIZHU"/>
             --%><p>
            备注： &nbsp;&nbsp;    &nbsp;&nbsp;
            </p>   
            <p>
             <textarea name="BEIZHU"  cols="40" rows="3"  >${propertyInfo.BEIZHU}</textarea>
              </p>
             <p>
             <input type="submit" value="提 交" style="height: 54px; width: 105px; vertical-align: middle;"/>  
             </p>
             </form>    
	   	</s:if>	  
 
       </td>
       </tr>
       </table>
    </div>   
  </div> 
   
  </div>
  
 
