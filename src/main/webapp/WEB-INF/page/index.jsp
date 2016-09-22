<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>index</title>
<%@ include file="/WEB-INF/page/common/head.jsp" %> 
</head>
<body>
    <div id="animalDiv">
    	<div id="animalDivHead"><div id="animalDivTitle"></div>X</div>
    	<div id="animalDivBody"></div>
    </div>
    
    <div>
	   <div id="listBody">
	   </div>
    </div>
    
    <div id="editForm">
        <div id="editFormBody"></div>
    </div>
</body>
</html>
<%@ include file="/WEB-INF/page/common/baseFoot.jsp" %> 
<script>
	var b = "<div>neilongneilongneilongneilongneilongneilong<div>";
	
		
// 	require([ _JS_PATH + "/common/require-config.js" ], function() {
// 	    require([ _modules.util.myUtil ], function() {
// 	        require([_modules.base.baseList, _modules.base.baseEditor,  _modules.base.container, _modules.base.win, 
// 		              _modules.common.common], function(m, e, c, w) {
	        	
// 	        	e = e.extend(function(_super) {
// 	        		return {
// 		        		url_load : "/dog/query",
// 		        		url_save : "/dog/save",
// 		        		saveButtonSelector : "[save]",
// 		        		afterSave : function(result) {
// 		        			_super.afterSave.apply(this, arguments);
		        			
// 		                	console.log("extend after save");
// 		                	console.log("reload list");
// 		                	m.reload();
// 		        		},
// 		        		container : w.build(),
// 		        	};
// 	        	});
	        	
// 	        	m = m.extend(function(_super) {
// 	        		return {
// 	        			url_load : "/dog/queryPage",
// 	        			container : c.extend({$body : $("#listBody")}),
// 	        			editor : e,
// 		                colModel : [ {
// 		                    "display" : "姓名",
// 		                    "name" : "name",
// 		                    "width" : 100,
// 		                    "sortable" : true,
// 		                    "align" : "left",
// 		                    "dataAlign" : "left",
// 		                    "showTdTitle" : false,
// 		                }, {
// 		                    "display" : "年龄",
// 		                    "name" : "age",
// 		                    "width" : 100,
// 		                    "sortable" : false,
// 		                    "align" : "left",
// 		                    "dataAlign" : "left",
// 		                    "customValue" : function(v) {
// 		                        return v + "岁";
// 		                    }
// 		                }, {
// 		                    "display" : "Option",
// 		                    "name" : "Option",
// 		                    "width" : 300,
// 		                    "sortable" : false,
// 		                    "align" : "left",
// 		                    "dataAlign" : "left"
// 		                } ],
// 		        	};
// 	        	});
// 	        	m.load();
// 	        });
// 	    });
// 	});
	
	
	
	
// 	require([ _JS_PATH + "/common/require-config.js" ], function() {
// 	    require([ _modules.util.myUtil ], function() {
// 	        require([_modules.base.container, 
// 		              _modules.common.common], function(m) {
// 				m.init({
// 						container : "animalDiv",
// 						body : "animalDivBody",
// 						head : "animalDivHead",
// 						title : "animalDivTitle",
// 						titleValue : "hahah"
// 					});
				
// 				m.load(b);
				
// 				m.open();
// 			});
// 		});
// 	});




// 		require([ _JS_PATH + "/common/require-config.js" ], function() {
// 		    require([ _modules.util.myUtil ], function() {
// 		        require([_modules.base.win, 
// 		              _modules.common.common], function(m) {
// 		        	m.init({titleValue : "hahah"});
		        	
// 		        	m.load(b);
		        	
// 		            m.open();
// 		        });
// 		    });
// 		});
</script>