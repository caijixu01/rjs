"use strict"

/**
 * 容器 基类
 * @auth caijx
 */
defineModule(
[
],

_modules.base.object,

function(_super) {
	
    var that = {
		/**
		 * 外观参数
		 */
		features : {},
		
		$container : undefined,
		
		$head : undefined,
		
		$title : undefined,
		
		$body : undefined,
		
        openAction : "show",
        
        closeAction : "hide",
        
        /**
         * container 或 body
         */
        openCloseActOn : "container",
        // -------------------------------------------
		$getContainer : function() {
			return this.$container;
		},
        
        $getHead : function() {
        	if (!this.$head) {
        		this.$head = this.$getSingleElement("[containerHead]");
        	}
        	
        	return this.$head;
        },
        
        $getTitle : function() {
        	if (!this.$title) {
        		this.$title = this.$getSingleElement("[containerTitle]");
        	}
        	
        	return this.$title;
        },
        
        $getBody : function() {
        	if (!this.$body) {
        		this.$body = this.$getSingleElement("[containerBody]");
        	}
        	
        	return this.$body;
        },
        
        /**
         * 打开
         */
        open : function(p) {
        	this.getOpenCloseTarget()[this.openAction]();  
        },
        
        /**
         * 关闭
         */       
        close : function() {
        	this.getOpenCloseTarget()[this.closeAction]();   
        },

        load : function(content) {
        	this.$getBody().html(content);
        },
        
		getOpenCloseTarget : function() {
	    	var t;
	    	if (this.openCloseActOn === "body") {
	    		t = this.$getBody();
	    	} else {
	    		t = this.$getContainer();
	    	}
	    	return t;
		},
		
		$getElementById : function(id) {
			return this.$getElements("#" + id);
		},
		
        $getSingleElement : function(selector) {
        	return this.$getElements(selector + ":first");
        },
        
        $getElements : function(selector) {
        	if (!this.$getContainer()) {
        		throw new Error("容器不能为空");
        	}
    		return $(selector, this.$getContainer());
        }
    };
    
    return that;
});