var Blog_Timeline = function(){
	var me = this;
    this.initBlog = function(){
    	$.ajax({
            type: "get",
            url: '/articles',
            async: false,
            success: function (result) {
            	var config = {url:'/articles/preview/'}
            	timeline._create_timeline(config,result)
            }
    	})
    	
    }
}