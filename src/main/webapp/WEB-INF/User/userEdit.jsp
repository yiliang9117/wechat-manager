<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

		<jsp:include page="../pages/leftIndex.jsp"></jsp:include>


    
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">修改用户信息</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        	修改${user.userName}
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                     				   <form role="form" method="post" action="/Users/update.html">
                     				   <input type="hidden" name ="id" value="${user.id}">
                                        <div class="form-group">
                                            <label>登录QQ:${user.userQq}</label>
                                        </div>
                                    
                                        <div class="form-group">
                                            <label for="userName">用户名</label>
                                            <input class="form-control" id="userName" type="text" name="userName" value="${user.userName}" >
                                              <%-- <p class="form-control-static">${user.userName}</p> --%>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>密码</label>
                                            <input class="form-control" name="password"  placeholder="${user.password}" >
                                            <p class="help-block">请输入四位数以上密码....</p>
                                        </div>
                                        
                                        
                                                          

								<div class="form-group">
									<label for="endTime">到期时间</label> <input type="text"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})"
										id="endTime" name="endTimeStr" value="<fmt:formatDate value="${user.endTime}" pattern="yyyy-MM-dd  HH:mm:ss" />" class="input-text Wdate"
										style="width: 400px;">
								</div>
                                        
                                        
                                        
                                        <div class="form-group">
                                            <label for="userRole">用户角色</label>
                                            <select id="userRole" class="form-control" name="userRole" value="${user.userRole}">
                                               
                                                <option value ="超级管理员" <c:if test="${'超级管理员' eq user.userRole}">selected</c:if> >超级管理员</option>
                                                <option value ="接口用户" <c:if test="${'接口用户' eq user.userRole}">selected</c:if> >接口用户</option>
                                                <option value ="后台用户" <c:if test="${'后台用户' eq user.userRole}">selected</c:if> >后台用户</option>   
  
                                            </select>
                                        </div>
                                        
                                        
                                        
                                        
                                        
                                        <button type="submit" class="btn btn-default">保存</button>
                                        <button type="reset" class="btn btn-default">重置</button>
                                    </form>
                                </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
    
<script type="text/javascript" src="/My97DatePicker/4.8/WdatePicker.js"></script>

    <!-- jQuery -->
    <script src="${proPath}/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${proPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${proPath}/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${proPath}/dist/js/sb-admin-2.js"></script>

</body>

</html>
