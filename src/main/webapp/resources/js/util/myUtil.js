"use strict"

/*
 * 工具类
 */
var myUtil = {
    alert : function(arg) {
        alert(arg);
    },
        
    /**
     * 获取Event事件
     */
    getEvent : function () {
        var e = window.event;
        if (e) {
            return e;
        }

        var c = this.getEvent.caller;
        while (c) {
            e = c.arguments[0];
            if (e instanceof Event) {
                break;
            }   
            c = c.caller;
        }

        return e;
    },

    /**
     * 获取事件目标
     */
    getEventTarget : function () {
        var e = this.getEvent();
        return e.target || e.srcElement;
    },
    
    /**
     * ajax
     */
    ajax : function(url, p) {
        p = $.extend({
            url : _CONTEXT_PATH + url,
            type : "post",
            contentType : "application/json; charset=utf-8",
            datatype : "json",
        }, p);
        
        if (p.data && p.type.toLowerCase() === "post") {
            p.data = JSON.stringify(p.data);
        }
        
        var _result;
        $.ajax(p).done(function(result) {
            _result = result;
            
            if ($.isFunction(p.callback)) {
                p.callback(result);
            }
        });
        
        return _result;
    },
    
    /**
     * ajax
     */
    ajax_1 : function(url, data, callback) {
        this.ajax(url, {
            data : data,
            callback : callback,
        });
    },
    
    /**
     * ajax 提交 form
     */
    ajaxSubmitForm : function(url, $form, callback) {
    	this.ajax_1(url, this.serializeObject($form), callback);
    },
    
    /**
     * 异步getData
     */
    asyncGetData : function(url, data, callback) {
        this.ajax(url, {
            data : data,
            callback : callback
        });
    },
    
    /**
     * 异步赋值
     */
    asyncSetValue : function(url, reqData, $input) {
        this.asyncGetData(url, reqData, function(result) {
            $input.val(result.object);
        });
    },    
    
    /**
     * 同步方式getData
     */
    syncGetData : function(url, jsonData) {
        return this.ajax(url, {
            data : jsonData,
            async : false
        });
    },
    
    /**
     * form 序列化成对象
     */
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
    
    /**
     * 添加url参数
     */
    addUrlParam : function(url, name, value) {
        var str = "";
        if (/\?/g.test(url)) {
            str = "&";
        } else {
            str = "?";
        }
        url += (str + name + "=" + value);
        
        return url;
    },
    
    /**
     * 获取url参数
     */
    getUrlParam : function(url, name) {
        var match = RegExp('[?&]' + name + '=([^&]*)').exec(url);  
        return match && decodeURIComponent(match[1].replace(/\+/g, ' ')); // unescape 
    },

    /**
     * 对象继承, 父对象不会被修改 添加_super属性, 用于保存父对象
     * 
     * @param parent父对象, 可以是数组
     * @param child 子对象
     */
    extend : function(parent, child, deep) {
        if ($.isArray(parent)) {
            var p = {}
            for (var i in parent) {
                $.extend(p, parent[i]);
            }
            return this.extend(p, child, deep);
        }
        
        if ($.isFunction(child)) {
        	child = child(parent);
        }
        
        var v = $.extend(deep, {}, parent, child);
        v._super = parent;

        return v;
    },

    /**
     * 深度克隆
     * @param o
     * @returns
     */
    deepClone : function(o) {
    	return $.extend(true, {}, o);
    },
    
    /**
     * 合并两个数组, arr1不会被修改
     */
    mergeArray : function(arr1, arr2) {
        var arr = [];
        $.merge(arr, arr1);
        $.merge(arr, arr2);
        return arr;
    },    
};