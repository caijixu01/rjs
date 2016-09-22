"use strict"

/*
 * form工具类
 */
var myFormUtil = {
    serializeObject : function($form) {
        var o = {};
        $.each($form.serializeArray(), function() {
            if (o[this.name]) {
                if (!$.isArray(o[this.name])) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value);
            } else {
                o[this.name] = this.value;
            }
        });
        
        return o;
    },
};