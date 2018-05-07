<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

		<jsp:include page="../pages/leftIndex.jsp"></jsp:include>


    
        <div id="page-wrapper">
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        	新增用户
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                     				   <form role="form" method="post" action="/Users/add.html">
                                        <div class="form-group">
                                            <label for="userQq">登录QQ</label>
                                            <input class="form-control" name="userQq" id="userQq">
                                        </div>
                                    
                                        <div class="form-group">
                                            <label for="userName">用户名</label>
                                            <input class="form-control" id="disabledInput" type="text" name="userName" > 
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>密码</label>
                                            <input class="form-control" name="password">
                                            <p class="help-block">请输入四位数以上密码....接口用户不需要密码。</p>
                                        </div>
                                        
                                        

								<div class="form-group">
									<label for="endTime">到期时间</label> <input type="text"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})"
										id="endTime" name="endTimeStr" class="input-text Wdate"
										style="width: 400px;">
								</div>

                                        
                                        
                                        <div class="form-group">
                                            <label for="user_role">用户角色</label>
                                            <select id="user_role" class="form-control" name="userRole">
                                                <option>超级管理员</option>
                                                <option>接口用户</option>
                                                <option>后台用户</option>
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
