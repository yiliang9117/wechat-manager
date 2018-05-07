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
                         所有用户列表
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>topicId</th>
                                        <th>微信号</th>
                                        <th>微信名称</th>
                                        <th>跳转链接</th>
                                        <th>调用次数</th>
                                        <th>创建时间</th>
                                        <th>到期时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
									<c:forEach items="${wegameOpenUrlTicketList}" var="wegameOpenUrlTicket">
	                                   <tr class="odd gradeX">
	                                       <td>${wegameOpenUrlTicket.wegameId}</td>
	                                       <td>${wegameOpenUrlTicket.wechatAccount}</td>
	                                       <td>${wegameOpenUrlTicket.wechatName}</td>
	                                       <td><a href="${basePath}/t/${wegameOpenUrlTicket.uuid}.html">${basePath}/t/${wegameOpenUrlTicket.uuid}.html</a></td>
	                                       <td>${wegameOpenUrlTicket.statisticsTimes}</td>
	                                       <td>
	                                      	 <fmt:formatDate value="${wegameOpenUrlTicket.createTime}" pattern="yyyy/MM/dd  HH:mm:ss" />
	                                       </td>
	                                       <td>
	                                      	 <fmt:formatDate value="${wegameOpenUrlTicket.endTime}" pattern="yyyy/MM/dd  HH:mm:ss" />
	                                       </td>
	                                       
	                                       <td class="center"><a href="/WegameOpenUrlTicket/delete/${wegameOpenUrlTicket.uuid}.html"><i class="fa fa-ban"></i>删除</a></td>
	                                   </tr>
									</c:forEach>
                                </tbody>
                            </table>
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
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>

</body>

</html>
