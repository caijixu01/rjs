"use strict"

defineModule(
[
],
_modules.base.baseCrud,
function(_super) {
	
    var that = {
        code : "dog",
        
        modules : {
        	editor : {
        		url_load : "/dog/query",
        		url_save : "/dog/save",
        	},
        	
        	list : {
            	url_load : "/dog/queryPage",
            	colModel : [ {
                    "display" : "姓名",
                    "name" : "name",
                    "width" : 100,
                    "sortable" : true,
                    "align" : "left",
                    "dataAlign" : "left",
                    "showTdTitle" : false,
                }, {
                    "display" : "年龄",
                    "name" : "age",
                    "width" : 100,
                    "sortable" : false,
                    "align" : "left",
                    "dataAlign" : "left",
                    "customValue" : function(v) {
                        return v + "岁";
                    }
                }, {
                    "display" : "Option",
                    "name" : "Option",
                    "width" : 300,
                    "sortable" : false,
                    "align" : "left",
                    "dataAlign" : "left"
                } ],
        	},
        },

//        doExtend : function() {
//        	_super.doExtend.apply(this, arguments);
//        	
//        	this.modules.editor.extend({
//        		url_load : "/dog/query",
//        		url_save : "/dog/save",
//        	});  
//            
//            this.modules.list.extend({
//            	url_load : "/dog/queryPage",
//            	colModel : [ {
//                    "display" : "姓名",
//                    "name" : "name",
//                    "width" : 100,
//                    "sortable" : true,
//                    "align" : "left",
//                    "dataAlign" : "left",
//                    "showTdTitle" : false,
//                }, {
//                    "display" : "年龄",
//                    "name" : "age",
//                    "width" : 100,
//                    "sortable" : false,
//                    "align" : "left",
//                    "dataAlign" : "left",
//                    "customValue" : function(v) {
//                        return v + "岁";
//                    }
//                }, {
//                    "display" : "Option",
//                    "name" : "Option",
//                    "width" : 300,
//                    "sortable" : false,
//                    "align" : "left",
//                    "dataAlign" : "left"
//                } ],
//            });
//        },
        
        build : function() {
            _super.build.apply(this, arguments);
        },
        
    };
    
	return that;
});
