var _modules = {
    base : {
    	object : moduleUtil.getBaseJsPath("object"),
        baseContainer : moduleUtil.getBaseJsPath("container/baseContainer"),
        container : moduleUtil.getBaseJsPath("container/container"),
        win : moduleUtil.getBaseJsPath("container/win"),
        baseModule : moduleUtil.getBaseJsPath("baseModule"),
        baseCrud : moduleUtil.getBaseJsPath("baseCrud"),
        baseEditor : moduleUtil.getBaseJsPath("editor/baseEditor"),
        editor : moduleUtil.getBaseJsPath("editor/editor"),
        winEditor : moduleUtil.getBaseJsPath("editor/winEditor"),
        baseList : moduleUtil.getBaseJsPath("list/baseList"),
        pageList : moduleUtil.getBaseJsPath("list/pageList"),
        baseSearcher : moduleUtil.getBaseJsPath("searcher/baseSearcher"),
        searcher : moduleUtil.getBaseJsPath("searcher/searcher"),
        quickSearcher : moduleUtil.getBaseJsPath("searcher/quickSearcher"),
    },
    
    lib : {
        jquery : moduleUtil.getLibJsPath("jquery-1.11.1"),
        jquery_migrate : moduleUtil.getLibJsPath("jquery-migrate-1.1.1"),
        dimensions : moduleUtil.getLibJsPath("dimensions"),
        jqDnR : moduleUtil.getLibJsPath("jqDnR"),
        jqModal : moduleUtil.getLibJsPath("jqModal"),
        flexigrid : moduleUtil.getLibJsPath("flexigrid"),
    }, 
    
    util : {
        flexigridX : moduleUtil.getUtilJsPath("flexigridX"),
        myUtil : moduleUtil.getUtilJsPath("myUtil"),
        myFormUtil : moduleUtil.getUtilJsPath("myFormUtil"),
    },

    common : {
    	common : moduleUtil.getCommonJsPath("common"),
        sysContants : moduleUtil.getCommonJsPath("sysContants"),
    },
    
};
