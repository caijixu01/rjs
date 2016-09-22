"use strict"

/**
 */
defineModule(
[
 _modules.base.container,
],

_modules.base.baseModule,

function(_super, container) {
    var that = {
        code : "baseSearcher",
        container : container,
        list : undefined,
        searchButtonSelector : "[search]",
        
        search : function() {
        	var $form = this.container.$getSingleElement("form");
        	var formData = myUtil.serializeObject($form);
        	this.list.load(formData);
        },
        
        build : function() {
        	_super.build.apply(this, arguments);
        	
        	var _that = this;
        	if (this.searchButtonSelector) {
        		this.container.$getElements(this.searchButtonSelector).click(function() {
        			_that.search();
            	});
        	}
        },
    };
    
    return that;
});
