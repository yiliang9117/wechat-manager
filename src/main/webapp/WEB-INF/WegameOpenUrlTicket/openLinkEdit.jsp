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
                                            <input class="form-control" id="userName" type="text" name="userName" placeholder="${user.userName}" >
                                              <%-- <p class="form-control-static">${user.userName}</p> --%>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>密码</label>
                                            <input class="form-control" name="password"  placeholder="${user.password}" >
                                            <p class="help-block">请输入四位数以上密码....</p>
                                        </div>
                                        
                                        
                                        
                                        <div class="form-group">
                                            <label for="userRole">用户角色</label>
                                            <select id="userRole" class="form-control" name="userRole"  placeholder="${user.userRole}">
                                                <option>超级管理员</option>
                                                <option>普通代理商</option>
                                                <option>单个用户</option>
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
