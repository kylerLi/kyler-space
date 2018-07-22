/**
 * Time line 
 * 
 */

(function ($, window, document, undefined) {
    window.timeline = window.timeline||{};
    
    function _timeline_structure(config,datas) {
        var timeline = document.createElement('UL');
        timeline.className = 'timeline';
        for (var i = 0; i < datas.length; i++) {
        	if(i == 0){
        		timeline.appendChild(timeline_label_structure(datas[i]['createdDt']));
        		timeline.appendChild(timeline_content_structure(config,datas[i]));
        	}else{
        		var dt1 = datas[i]['createdDt']
        		var dt2 = datas[i-1]['createdDt']
        		if(!compareTime(dt1,dt2))
        			timeline.appendChild(timeline_label_structure(datas[i]['createdDt']));
        		timeline.appendChild(timeline_content_structure(config,datas[i]));
        			
        	}
        	
		}
        /*datas.forEach(function(data){
        	timeline.appendChild(timeline_label_structure(data.createDt));
            timeline.appendChild(timeline_content_structure(data));
        })*/
    	return timeline
    }
    
    //左侧时间
    function timeline_label_structure(createDt){
    	var date = new Date(createDt);
        var dt = date.format('dd/MM/yyyy')

    	var timelabel = document.createElement('LI');
        timelabel.className = 'time-label';
        timelabel.innerHTML = '<span class="bg-red"> ' + dt + ' </span>';
        return timelabel
    }
    
    //右侧内容
    function timeline_content_structure(config,data){
    	var date = new Date(data['updatedDt']);
        var updateDT = date.format('yyyy-MM-dd')
         
         var timelabel_content = document.createElement('LI');
         timelabel_content.innerHTML= '<i class="fa fa-envelope bg-blue"></i>';
         
         var timeline_item = document.createElement('DIV');
         timeline_item.className = 'timeline-item';
      
         if(data['updatedDt'])
        	 timeline_item.innerHTML = '<span class="time">更新于: '+ updateDT + '</span>'
         
         //标题
         var timeline_header = document.createElement('H3');
         timeline_header.className = 'timeline-header text-center';
         timeline_header.innerHTML = '<a href="'+ config.url + data['id'] + '" >' + data['title'] + '</a>'
        // timeline_header.innerHTML = '<a th:href="@{'+ config.url + data['id'] + '}" >' + data['title'] + '</a>' 

         
         //概要
         var timeline_body = document.createElement('DIV');
         timeline_body.className = 'timeline-body';
         var title_length = data['title'].length
         timeline_body.innerHTML = data['content'].substring(title_length+3,300)
        	 
         //评论标签
         var tags = ''
         var keywords = data["keywords"].split(',')
         
         for (var j = 0; j < keywords.length; j++) {
        	 tags += '<span class="label label-danger pull-right" style="padding:5px;margin-right:12px">' + keywords[j] + '</span>'
		 }
         
         var timeline_footer = document.createElement('DIV');
         timeline_footer.className = 'timeline-footer';
         timeline_footer.innerHTML = 
        	 '<a class="fa fa-user">'+ data['author']+'</a>&nbsp;'
        	 +'<a class="fa fa-eye">100</a>' + tags
         
     	 timeline_item.appendChild(timeline_header)
     	 timeline_item.appendChild(timeline_body)
     	 timeline_item.appendChild(timeline_footer)
         timelabel_content.appendChild(timeline_item);
         return timelabel_content
    }
    
    function compareTime(dt1,dt2){
    	var date1 = new Date(dt1)
    	var date2 = new Date(dt2)
    	var month1 = date1.getMonth() + 1;
    	var year1 = date1.getFullYear();
    	var month2 = date2.getMonth() + 1;
    	var year2 = date2.getFullYear();
    	if(month1 == month2 && year1 == year2)
    		return true
		else
			return false

    }

    timeline._create_timeline = function(config, datas) {
        var timeline = _timeline_structure(config,datas);
        $('#blog-timeline').append(timeline);
        return timeline;
    }
})(jQuery, window, document);
