"use strict"

/**
 */
defineModule(
[
_modules.base.winEditor,
_modules.base.pageList,
_modules.base.searcher,
_modules.base.quickSearcher,
], 

_modules.base.baseModule, 

function(
	  _super,
	  winEditor, 
	  pageList,
	  searcher, 
	  quickSearcher
	  ) {
	
    var that = {
        code : "baseCrud",
        loadOnInit : true,
        modules : {
        	editor : winEditor,
        	list : pageList,
	    	searcher : searcher,
	    	quickSearcher : quickSearcher,
        },
        
        initContainer : function() {
        	_super.initContainer.apply(this, arguments);
        	this.modules.list.container.$container = this.container.$getElementById("listContainer");
        	this.modules.searcher.container.$container = this.container.$getElementById("searcherContainer");
        	this.modules.quickSearcher.container.$container = this.container.$getElementById("quickSearcherContainer");
        },
        
        build : function() {
        	_super.build.apply(this, arguments);
        	
        	this.modules.list.extend({
        		editor : this.modules.editor,
        	});
        	
        	this.modules.searcher.extend({
        		list : this.modules.list,
        	});
        	
        	this.modules.quickSearcher.extend({
        		list : this.modules.list,
        	});
        },
        
//        init : function() {
//        	_super.init.apply(this, arguments);
//        },
        
        load : function() {
        	this.modules.list.load();
        },

    };
    
    return that;
});
