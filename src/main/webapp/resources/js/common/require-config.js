require.config({
    baseUrl : _RESOURCES_PATH,
//	paths : {},
//    urlArgs : "ver=" + (new Date()).getTime(),
    waitSeconds : 15,
    map : {
        "*" : {
            "css" : _JS_PATH + "/lib/css.js"
        }
    },
    // 依赖关系
    shim : (function() {
        var p = {};
        
        p[_modules.lib.jquery_migrate] = [ _modules.lib.jquery ];
        
        p[_modules.lib.dimensions] = [ _modules.lib.jquery ];
        
        p[_modules.lib.jqDnR] = [ _modules.lib.jquery ];
        
        p[_modules.lib.jqModal] = [ _modules.lib.jquery_migrate,
                                moduleUtil.getCssPath("jqModal/jqModal_blue") ];
        
        p[_modules.lib.flexigrid] = [ _modules.lib.jquery_migrate,
                                  moduleUtil.getCssPath("flexigrid/flexigrid_blue") ];
        
        p[_modules.util.myUtil] = [ _modules.lib.jquery ];
        
        p[_modules.common.common] = [ _modules.util.myUtil ];
        
        return p;
    })(),
});
