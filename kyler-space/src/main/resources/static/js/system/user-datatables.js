/**
 * 文章管理
 */
var SysUsers = function(){
	var me = this;
    this.initDataTables = function(){
    	$('#user_lists').DataTable({
            bFilter: true,
            bSort: false,
            bInfo: false,
            bAutoWidth: false,
            sAjaxSource: "/users",
    		sAjaxDataProp: "",
    		order: [[ 0, "asc" ]],
    		language: { // 中文支持
                sUrl: "/common/json/zh_CN.json"
            },
            "searching": false, // 过滤
            "ordering": true, // 排序
            "autoWidth": false,
            //"stateSave" : true,// 这样就可以在删除返回时，保留在同一页上
            "processing": true,// 是否显示取数据时的那个等待提示
            "pagingType": "full_numbers",// 分页样式
           
            "serverSide": true,
            "ajaxDataProp": "data",
            "singleSelect": true,  //单选
            /*dom: 'l<"toolbar">frtip',
            initComplete: function(){
                $("div.toolbar").html('<a class="btn btn-sm btn-primary" id="article_add_btn" th:href="@{\'/markdown/article_edit\'}"><i class="fa fa-plus"></i>写文章</a>');           
             },*/
             aoColumns: [
     			 {title:"账号",mData:'account'},
                  {title:"用户名",mData:'realName'},
                  {title:"性别",mData:'sex'},
                  {title:"邮箱",mData:'email'},
                  {title:"电话",mData:'mobile'},
                  {title:"状态",mData:'status'},
                  {title:"创建时间",mData:'createdDt',type:'date',"render": function (data) {
                      var date = new Date(data);
                      var month = date.getMonth() + 1;
                      return date.getFullYear()+"-" + (month.length > 1 ? month : "0" + month) + "-" + date.getDate();
                  }},

                  {title:"",mData:'',render: function ( data, type, row) {
                 	 var content =
                 		 "&nbsp;&nbsp;<a class='btn btn-sm btn-primary' id='user_edit_btn' data-btn-type='edit' data-bind='"+ row.userSid +"'>编辑</a>"+
             	         "&nbsp;&nbsp;<a class='btn btn-sm btn-danger' id='user_del_btn' data-btn-type='delete' data-bind='"+ JSON.stringify(row)  +"'>删除</a>"
                         return content
                  } }
             ]
         })
         
     	
     	$('#user_lists').on('click', '#user_edit_btn', function(){
     		var id = $(this).attr('data-bind');
     		$.ajax({
	        		url:'/users/'+ id,
	        		type: "get",
	                async: false,
	               success: function (result) {
	            	  var form = $("#user-form").form();
	            	  form.initFormData(result.data);
                  $('#nav-tab-edit').click();
	               }
	            })
     		
     	})
     	$('#user_lists').on('click', '#user_del_btn', function(){
     		var user = JSON.parse($(this).attr('data-bind'))
     		modals.confirm('确认删除用户 ' + user.account, function() {
 	        	$.ajax({
 	        		url:'/users/' +user.userSid,
 	        		type: "delete",
 	                async: false,
 	               success: function (result) {
 	            	  modals.info(result.message);
                      $('#user_lists').dataTable().fnDraw(false)
 	               }
 	            })
            })
         });
    }
    
    this.initFormValidator = function(){
		//表单验证根据所需进行配置,在此只进行简单验证
	    var form = $("#user-form").form();
	    $("#user-form").bootstrapValidator({
	        message: '请输入有效值',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        submitHandler: function(validator, userform, submitButton) {
	            modals.confirm('确认保存？', function() {
	                //Save Data，对应'submit-保存'
	                var params = form.getFormSimpleData();
	                if(params.userSid == null|| params.userSid =='' ){
	                	$.ajax({
    	 	        		url:'/users/',
    	 	        		data:params,
    	 	        		type: "post",
    	 	                async: false,
    	 	                success: function (result) {
    	 	                	/*if (form.data('bootstrapValidator'))
	                                form.data('bootstrapValidator').resetForm();*/
	                            $('#nav-tab-list').click();
	                            $('#user_lists').dataTable().fnDraw(false)

    	 	                }
    	 	            })
	                }else{
	                	$.ajax({
	    	        		url:'/users/'+ params.userSid,
	    	        		type: "put",
	    	                async: false,
	    	                data:params,
	    	                success: function (result) {
	    	                	modals.info(result.message)
	    	                	if('success' == result.status){
		                            $('#nav-tab-list').click();
		                            $('#user_lists').dataTable().fnDraw(false)

	    	                	}
	    	                	
	    	                }
	    	             })
	                }
	                
	            });
	        },
	        fields: {
	            name: {
	                validators: {
	                    notEmpty: { message: '请输入姓名' }
	                }
	            },
	            sex: {
	                validators: { notEmpty: { message: '请选择性别' } }
	            },
	            birthday: {
	                validators: {
	                    notEmpty: { message: '请输入出生日期' },
	                    date: { format: 'YYYY/DD/MM' },
	                    callback: {
	                        message: '请输入有效日期',
	                        callback: function(value, validator) {
	                            var res = new Date(value)!='Invalid Date';
	                            if (res) validator.updateStatus('birthday', 'VALID');

	                            return res;
	                        }
	                    }
	                }
	            },
	            loginName: {
	                validators: {
	                    notEmpty: { message: '请输入登录名' }
	                }
	            }
	        }
	    });
	    form.initComponent();
	}
	
	this.initBtnBind = function(){
	    $('button[data-btn-type]').click(function() {
	        var action = $(this).attr('data-btn-type');
	        switch (action) {
	            case 'add':
	                form.clearForm();
	                //form.data('bootstrapValidator').resetForm();
	                $('#nav-tab-edit').click();
	                break;
	            case 'edit':
	            	var row = $("#user_lists").dataTable().api().row('.select');
	            	var userSid;
	                if(row) {
	                    userSid = row.data().userSid;
	                }else{
	                	return;
	                }
	                $.ajax({
	 	        		url:'/users/'+ userSid,
	 	        		type: "get",
	 	                async: false,
	 	               success: function (result) {
	 	            	  form.initFormData(result.data);
	                      $('#nav-tab-edit').click();
	 	               }
	 	            })
	                break;
	            /*case 'delete':
	            	var row = $("#user_lists").dataTable().api().row('.select');
	            	var userSid;
	                if(row) {
	                    userSid = row.data().userSid;
	                }else{
	                	return;
	                }
	                modals.confirm('确认删除用户 ' + user.account, function() {
	     	        	$.ajax({
	     	        		url:'/users/' +user.userSid,
	     	        		type: "delete",
	     	                async: false,
	     	               success: function (result) {
	     	            	  modals.info(result.message);
	     	               }
	     	            })
	                })
	                break;*/
	            /*case 'save':
	                form.bootstrapValidator('validate');
	                if (form.data('bootstrapValidator').isValid()) {
	                    var params = form.getFormSimpleData();

	                    modals.confirm('确认保存ssss？', function() {
	                    	$.ajax({
	    	 	        		url:'/users/',
	    	 	        		data:params,
	    	 	        		type: "post",
	    	 	                async: false,
	    	 	                success: function (result) {
	    	 	                	if (form.data('bootstrapValidator'))
		                                form.data('bootstrapValidator').resetForm();
		                            $('#nav-tab-list').click();
		                            $('#user_lists').dataTable().fnDraw(false)

	    	 	                }
	    	 	            })
	                    });
	                }
	                break;*/
	            case 'cancel':
	                form.clearForm();
	                $('#nav-tab-list').click();
	                break;
	        }
	    });
	}
}