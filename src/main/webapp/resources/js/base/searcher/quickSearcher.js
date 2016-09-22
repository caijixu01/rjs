"use strict"

/**
 */
defineModule(
[
 
],

_modules.base.baseSearcher, 

function(_super) {
    var that = {
        code : "quickSearcher",
        quickSearchButtonSelector : "[quickSearch]",
        
        build : function() {
        	_super.build.apply(this, arguments);
        	
        	var _that = this;
        	if (this.quickSearchButtonSelector) {
        		this.container.$getElements(this.quickSearchButtonSelector).change(function() {
        			_that.search();
            	});
        	}
        },
    };
    
    return that;
});
