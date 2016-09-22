"use strict"

/**
 */
defineModule(
[
 _modules.base.container,
 _modules.util.flexigridX,
],

_modules.base.baseModule,

function(_super, container) {
	
    var that = {
    	rowId : "id",
        url_load : undefined,
    	colModel : [],
    	container : container,
    	editor : undefined,

    	edit : function(action) {
        	var bizId;
            if (action === "add") {
            } else if (action === "update") {
            	bizId = this.getBizId();
            	if (!bizId) {
            		myUtil.alert("请选择一行。");
            		return;
            	}
            }
            
            this.editor.load(bizId);
            this.editor.container.open();
        },
    	
    	load : function(params) {
    	    this.container.$getBody().flexOptions({ params: params }).flexReload();
    	},
    	
    	build : function() {
			_super.build.apply(this, arguments);

			var _that = this;
            this.container.$getBody().flexigrid({
                url: _CONTEXT_PATH + this.url_load,
                method: "POST",
                dataType: "json",
                autoload: false,
                rowId : this.rowId,
                searchitems : [
                             {display: "姓名", name : "Name", isdefault: true}
                ],
                buttons : [
                         { name: "添加", bclass: "add", onpress : function() {_that.edit("add");}},
                         { separator: true },
                         { name: "修改", bclass: "edit", onpress: function() {_that.edit("update");}},
                         { separator: true },
                         { name: "删除", bclass: "delete", onpress: function() {} },
                         { separator: true },
                         { name: "　", bclass: "pReload", onpress: function() {_that.load()} },
                         { separator: true },
                         ],
                colModel : this.colModel,
            });
            
    	},
    	
    	getBizId : function() {
    	    var vs = this.container.$getSingleElement(".trSelected");
    	    if (vs.length > 0) {
    	        return vs[0].id;
    	    }
    	},
    };
    
    return that;
});
