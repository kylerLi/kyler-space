/**
 * 文章管理
 */
jQuery().ready(function() {

	var tab = $('#article_lists').DataTable({
        "bFilter": true,
        "bSort": false,
        "bInfo": false,
        "bAutoWidth": false,
        "sAjaxSource": "/articles/list",
		"sAjaxDataProp": "",
		"order": [[ 0, "asc" ]],
		"language": { // 中文支持
            "sUrl": "/common/json/zh_CN.json"
        },
        "aoColumns": [
			 {"mData":'title'},
             {"mData":'keywords'},
             {"mData":'author'},
             {"mData":'createDateTime'},
             {"mData":'updateDateTime'},
             {"mData":'tagId'},
             {"mData":'status'},
             {"mData":'status'}
        ] 
    })
})