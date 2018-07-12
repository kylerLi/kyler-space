/**
 * 文章管理
 */
var Articles = function(){
	var me = this;
    this.initDataTables = function(){
    	$('#article_lists').DataTable({
            bFilter: true,
            bSort: false,
            bInfo: false,
            bAutoWidth: false,
            sAjaxSource: "/articles",
    		sAjaxDataProp: "",
    		order: [[ 0, "asc" ]],
    		language: { // 中文支持
                sUrl: "/common/json/zh_CN.json"
            },
            /*dom: 'l<"toolbar">frtip',
            initComplete: function(){
                $("div.toolbar").html('<a class="btn btn-sm btn-primary" id="article_add_btn" th:href="@{\'/markdown/article_edit\'}"><i class="fa fa-plus"></i>写文章</a>');           
             },*/
             aoColumns: [
     			 {title:"文章标题",mData:'title'},
                  {title:"关键字",mData:'keywords'},
                  {title:"作者",mData:'author'},
                  {title:"写作时间",mData:'createDateTime'},
                  {title:"更新时间",mData:'updateDateTime'},
                  {title:"标签",mData:'tagId'},
                  {title:"状态",mData:'status'},
                  {title:"",mData:'',render: function ( data, type, row) {
                 	 var content =
                 		 "<a class='btn btn-sm btn-success pull-left' id='article_preview_btn' data-bind='"+ row.id +"'>预览</a>"+
                 		 "&nbsp;&nbsp;<a class='btn btn-sm btn-primary' id='article_edit_btn' data-bind='"+ JSON.stringify(row) +"'>编辑</a>"+
                 	     "&nbsp;&nbsp;<a class='btn btn-sm btn-danger' id='article_del_btn' data-bind='"+ JSON.stringify(row) +"'>删除</a>"
                      return content
                  } }
             ]
         })
         
         
         $('#article_lists').on('click', '#article_preview_btn', function(){
        	 var id = $(this).attr('data-bind');
        	 window.location.href = '/article/preview/' +id;
        	 
         });
     	
     	$('#article_lists').on('click', '#article_edit_btn', function(){
     		var article = JSON.parse($(this).attr('data-bind'))
     		window.location.href = '/articles/edit/' + article.id;
     		
     	})
     	$('#article_lists').on('click', '#article_del_btn', function(){
     		var article = JSON.parse($(this).attr('data-bind'))

     		modals.confirm('确认删除文章 ' + article.title, function() {
 	        	$.ajax({
 	        		url:'/articles/' +article.id,
 	        		type: "delete",
 	                async: false,
 	               success: function (result) {
 	            	  modals.info(result.message);
 	               }
 	            })
            })
         });
}

}