"use strict"

/**
 * 模块基类
 */
defineModule(
[
 _modules.base.baseContainer,
],

_modules.base.object,

function(_super, baseContainer) {
    var that = {
    	isDomain : undefined,
    	
        code : undefined,
        
        name : undefined,
        
        loadOnInit : false,

        container : undefined,
        
        modules : {},
        
//        newInstance4component : function() {
//        	// 解决requirejs单例问题
//        	for (var key in this.modules) {
//				this.modules[key].container = this.modules[key].container.newInstance();
//        		this.modules[key] = this.modules[key].newInstance();
//        		this.modules[key].newInstance4component();
//			}
//        },
        
        initContainer : function() {
        	if (this.isDomain) {
        		this.container = myUtil.extend(baseContainer, {$container : $("body")});
        	}
        },
        
        build : function() {
        	_super.build.apply(this, arguments);
        	
        	for (var key in this.modules) {
				this.modules[key].build();
			}
        	
        },
        
        init : function() {
//        	this.doNewInstance();
//        	this.doExtend();
        	this.initContainer();
            this.build();
            if (this.loadOnInit) {
            	this.load();
            }
        },
        
        load : function() {},
        
        afterLoad : function() {},
    };
    
    return that;
});
