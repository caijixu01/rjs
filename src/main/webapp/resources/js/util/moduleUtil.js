/*
 * requirejs的扩展
 */
(function() {
    "use strict"
    
	window.moduleUtil = {
		getCssPath : function(css) {
			return "css!" + _CSS_PATH + "/" + css + ".css";
		},
		
		getLibJsPath : function (js) {
			return this.getJsPath(js, "lib");
		},
		
		getUtilJsPath : function (js) {
			return this.getJsPath(js, "util");
		},

		getBaseJsPath : function getBaseJs(js) {
			return this.getJsPath(js, "base");
		},
		
		getCommonJsPath : function (js) {
			return this.getJsPath(js, "common");
		},
		
		getJsPath : function (js, pre) {
			if (!pre) {
				pre = "";
			} else {
				pre += "/";
			}
			return _JS_PATH + "/" + pre + js + ".js";
		},
	};
	
    /**
     * 定义 模块
     */
	window.defineModule = function(deps, parent, childFun) {
		if (arguments.length === 2) {
			childFun = parent;
			if (typeof deps === "string") {
				parent = deps;
				deps = [];
			} else {
				parent = undefined;
			}
		} else if (arguments.length === 1) {
			childFun = deps;
			deps = [];
			parent = undefined;
		}
		
        define([parent].concat(deps), function() {
        	var m = myUtil.extend(arguments[0], childFun.apply($.noop, arguments), true);
        	
//    		m.newInstance4component();
        	
        	return m;
        });
    };
    
    /**
     * 初始化 模块
     */
    window.initModule = function(modulePath) {
		require([ _JS_PATH + "/common/require-config.js" ], function() {
		    require([ _modules.util.myUtil, 
		              _modules.common.common], function() {
		        require([modulePath], function(module) {
		            module.isDomain = true;
		            module.init();
		        });
		    });
		});
	};
})();
