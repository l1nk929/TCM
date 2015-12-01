 <%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>TCM</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="çç¶è§èä¸»é¡µ">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.cxselect.js"></script>
  </head>
  
  <body>
  <h3>已有特征</h3>
    	<c:forEach items="${attrallVoList}" var="attrallListVo">
  			<c:forEach items="${attrallListVo.parents}" var="attrall">
  				${attrall.attr_name}>>
  			</c:forEach>
  			${attrallListVo.now.attr_name}
  			</p>
  	</c:forEach>
    	
    	
    	
    	
    	
    	
    	
    	</p>
    	
    	
    	
    	
    	
    	
    	
    	
    	 <h3>添加特征</h3>
    	
    	
    	<form action="">
    	
 <div id="element_id"> 
  <select class="level-1">
  	<option value="1">四诊</option>
  </select> 
  <select class="level-2">
  	<option value="1">望诊</option>
  	<option value="1">闻诊</option>
  	<option value="1">问诊</option>
  	<option value="1">切诊</option>
  </select> 
  <select class="level-3">
  	<option value="1">望神</option>
  	<option value="1">望色</option>
  	<option value="1">望头面</option>
  	<option value="1">望面部</option>
  	<option value="1">望目</option>
  </select>
  <select class="level-4">
  	<option value="1">目色</option>
  	<option value="1">目形</option>
  	<option value="1">目态</option>
  </select> 
  
  
</div> 
    	
    	
    	
    	
    	<input type="button" value="添加">
    	</form>
    	
    	
   
  </body>
<!--   <script type="text/javascript">
$('#element_id').cxSelect({ 
  selects: ['level-1', 'level-2', 'level-3', 'level-4', 'level-5'], 
  jsonName: 'name', 
  jsonValue: 'value', 
  jsonSub: 'sub', 
  url: [ 
    {name:'A', value: '1', sub: [ 
      {name: 'A-1', value: '2', sub: [ 
        {name: 'A-1-1', value: '11'} 
      ]},
      {name: 'A-2', value: '3', sub: [ 
        {name: 'A-2-1', value: '34'} 
      ]} 
    ]}, 
    {name:'B', value: '5', sub: [ 
      {name: 'B-1', value: '8', sub: [ 
        {name: 'B-1-1', value: '16'} 
      ]} 
    ]} 
  ] 
}); 
  </script>
   -->
</html>
