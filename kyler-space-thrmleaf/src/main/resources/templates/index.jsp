<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>JY-Cloud</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <meta name="description" content="Developed By M Abdur Rokib Promy">
    <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
    <%@ include file="../common/taglibs.jsp"%>
	<%@ include file="../common/resources.jsp"%>
</head>
<body class="skin-black">
  <!-- header logo: style can be found in header.less -->
  <header class="header">
      <a href="#" class="logo">捷越联合
      </a>
      <!-- Header Navbar: style can be found in header.less -->
      <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
          </a>
          <div class="navbar-right">
              <ul class="nav navbar-nav">
                  <!-- Messages: style can be found in dropdown.less-->
                  <li class="dropdown messages-menu">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                          <i class="fa fa-envelope"></i>
                          <span class="label label-success">4</span>
                      </a>
                      <ul class="dropdown-menu">
                          <li class="header">消息</li>
                          <li>
                              <!-- inner menu: contains the actual data -->
                              <ul class="menu">
                                  <li>
                                      <a href="#">
                                          <div class="pull-left">
                                              <img src="../img/26115.jpg" class="../img-circle" alt="user image"/>
                                          </div>
                                          <h4>任务</h4>
                                          <p>xx任务执行成功</p>
                                          <small class="pull-right"><i class="fa fa-clock-o"></i> 昨天</small>
                                      </a>
                                  </li>
                                  <li>
                                      <a href="#">
                                          <div class="pull-left">
                                              <img src="../img/avatar.png" class="../img-circle" alt="user image"/>
                                          </div>
                                          <h4>操作成功 </h4>
                                          <p></p>
                                          <small class="pull-right"><i class="fa fa-clock-o"></i> 两天前</small>
                                      </a>
                                  </li>
                              </ul>
                          </li>
                          <li class="footer"><a href="#">查看全部</a></li>
                      </ul>
                  </li>
                  <li class="dropdown tasks-menu">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                          <i class="fa fa-tasks"></i>
                          <span class="label label-danger">9</span>
                      </a>
                      <ul class="dropdown-menu">
                          <li class="header">9个待办</li>
                          <li>
                              <!-- inner menu: contains the actual data -->
                              <ul class="menu">
                                  <li><!-- Task item -->
                                      <a href="#">
                                          <h3>
                                                                                                                                         进行中<small class="pull-right">20%</small>
                                          </h3>
                                          <div class="progress progress-striped xs">
                                              <div class="progress-bar progress-bar-success" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                  <span class="sr-only">20% Complete</span>
                                              </div>
                                          </div>
                                      </a>
                                  </li><!-- end task item -->
                              </ul>
                          </li>
                          <li class="footer">
                              <a href="#">查看全部</a>
                          </li>
                      </ul>
                  </li>
                  <!-- User Account: style can be found in dropdown.less -->
                  <li class="dropdown user user-menu">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                          <i class="fa fa-user"></i>
                          <span>jycloud <i class="caret"></i></span>
                      </a>
                      <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                          <li class="dropdown-header text-center">账号</li>

                          <li>
                              <a href="#">
                              <i class="fa fa-envelope-o fa-fw pull-right"></i>
                                  <span class="badge badge-danger pull-right">5</span> 消息</a>
                              <a href="#"><i class="fa fa-question fa-fw pull-right"></i> <span class=
                                  "badge pull-right">11</span>FAQ</a>
                          </li>

                          <li class="divider"></li>

                              <li>
                                  <a href="#">
                                  <i class="fa fa-user fa-fw pull-right"></i>
                                      	个人信息
                                  </a>
                                  <a data-toggle="modal" href="#modal-user-settings">
                                  <i class="fa fa-cog fa-fw pull-right"></i>
                                      	设置
                                  </a>
                                  </li>

                                  <li class="divider"></li>

                                  <li>
                                      <a href="#"><i class="fa fa-ban fa-fw pull-right"></i> 退出</a>
                                  </li>
                              </ul>
                          </li>
                      </ul>
                  </div>
              </nav>
          </header>
          <div class="wrapper row-offcanvas row-offcanvas-left">
              <!-- Left side column. contains the logo and sidebar -->
              <aside class="left-side sidebar-offcanvas">
                  <!-- sidebar: style can be found in sidebar.less -->
                  <section class="sidebar">
                      <!-- Sidebar user panel -->
                      <div class="user-panel">
                          <div class="pull-left image">
                              <img src="img/26115.jpg" class="img-circle" alt="User Image" />
                          </div>
                          <div class="pull-left info">
                              <p>Hello, jycloud</p>

                              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                          </div>
                      </div>
                      <!-- search form -->
                      <form action="#" method="get" class="sidebar-form">
                          <div class="input-group">
                              <input type="text" name="q" class="form-control" placeholder="Search..."/>
                              <span class="input-group-btn">
                                  <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                              </span>
                          </div>
                      </form>
                      <!-- /.search form -->
                      <!-- sidebar menu: : style can be found in sidebar.less -->
                      <ul class="sidebar-menu">
                          <li class="active">
                              <a href="#" onclick="iframeContent('/project/project-list.jsp')">
                                  <i class="fa fa-gavel"></i><span>项目管理</span></a>
                          </li>
                          <li>
                              <a href="#" onclick="iframeContent('/sys/user-list.jsp')">
                                  <i class="fa fa-gavel"></i><span>系统管理</span></a>
                          </li>
                          <!-- <li>
                              <a href="#" onclick="iframeContent('/sys/user-list.jsp')">
                                  <i class="fa fa-glass"></i><span>参数配置</span></a>
                          </li>
                          <li>
                              <a href="#" onclick="iframeContent('/project/project-list.jsp')">
                                  <i class="fa fa-dashboard"></i> <span>资源视图</span>
                              </a>
                          </li> -->

                      </ul>
                  </section>
                  <!-- /.sidebar -->
              </aside>
              <div class="copyrights"> <a href="http://www.cssmoban.com/" ></a></div>

              <aside class="right-side">

          <!-- Main content -->
          <section class="content">

              <div id="mainDiv"></div>
          </section>
          <!-- /.content -->
          
          <div class="footer-main">
              Copyright Beijing Jieyue Union <a href="http://www.jieyuechina.com/" title="捷越联合" target="_blank">捷越联合</a>
          </div>
      </aside><!-- /.right-side -->

  </div><!-- ./wrapper -->

   <!-- jQuery 2.0.2 -->

  <!-- Director for demo purposes -->
  <script type="text/javascript">
      $('input').on('ifChecked', function(event) {
          // var element = $(this).parent().find('input:checkbox:first');
          // element.parent().parent().parent().addClass('highlight');
          $(this).parents('li').addClass("task-done");
          console.log('ok');
      });
      $('input').on('ifUnchecked', function(event) {
          // var element = $(this).parent().find('input:checkbox:first');
          // element.parent().parent().parent().removeClass('highlight');
          $(this).parents('li').removeClass("task-done");
          console.log('not');
      });

  </script>
  <script>

      $('input[type="checkbox"].flat-grey, input[type="radio"].flat-grey').iCheck({
          checkboxClass: 'icheckbox_flat-grey',
          radioClass: 'iradio_flat-grey'
      });
      
      $('#mainDiv').html("<iframe src='http://192.168.67.98/assets/idc_list/' id='' style='width:100%;height:95.5%;background:#fff;margin:0px;padding:0px;overflow-y:auto' frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='yes'></iframe>");
      
          var bodyh = document.documentElement.clientHeight;
          document.getElementById("mainDiv").style.height = (parseInt(bodyh) - 151) + 'px';    
          window.onresize = function(){
			  var bodyh = document.documentElement.clientHeight;
			  document.getElementById("mainDiv").style.height = (parseInt(bodyh) - 151) + 'px';
		   };
   
           function iframeContent(jspUrl){
   	           $('#mainDiv').html("<iframe src='"+ws_url+"/pages"+jspUrl+"' id='' style='width:100%;height:95.5%;background:#fff;margin:0px;padding:0px;overflow-y:auto' frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='yes'></iframe>");
           }
   </script>

</body>
</html>