"use strict"

/**
 */
defineModule(
[_modules.base.container,
 _modules.util.myFormUtil],
 
_modules.base.baseModule,

function(_super, container) {
    var that = {
    	url_load : undefined,
    	
    	url_save : undefined,
    	
    	saveButtonSelector : "[save]", 
    	container : container,
    	bizId : undefined,
    	
        load : function(bizId) {
            var _that = this;
            myUtil.ajax_1(this.url_load, {id : bizId}, function(html) {
                _that.container.load(html);
                
                _that.afterLoad();
            });
        },
        
        afterLoad : function() {
        	_super.afterLoad.apply(this, arguments);
        	
        	var _that = this;
        	if (this.saveButtonSelector) {
        		this.container.$getElements(this.saveButtonSelector).click(function() {
        			_that.save();
            	});
        	}
        },
        
        save : function() {
        	var $form = this.container.$getSingleElement("form");
        	
        	var _that = this;
        	myUtil.ajaxSubmitForm(this.url_save, $form, function(result) {
        		_that.afterSave(result);
        	});
        },
        
        afterSave : function(result) {
        	console.log("old after save");
        	this.container.close();
        },
    };
    
    return that;
});
