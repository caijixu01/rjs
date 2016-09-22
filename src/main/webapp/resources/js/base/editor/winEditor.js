"use strict"

/**
 * @auth caijx
 */
defineModule(
[
 _modules.base.win
], 

_modules.base.baseEditor, 

function(_super, win) {
    var that = {
		container : win,
		
		build : function() {
			_super.build.apply(this, arguments);
		},
    		
    };
    
    return that;
});
