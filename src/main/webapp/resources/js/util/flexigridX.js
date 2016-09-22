"use strict"

/**
 * flexigrid默认配置
 */
var _flexigrid_p = {
//        resizable: true, //resizable table是否可伸缩
//        url: false, //ajax url,ajax方式对应的url地址
//        method: "POST", // data sending method,数据发送方式
        dataType: "json", // type of data loaded,数据加载的类型，xml,json
//        width : 400, //宽度值，auto表示根据每列的宽度自动计算，在IE6下建议设置具体值否则会有问题
        height: 220, //flexigrid插件的高度，单位为px
//        title: "Countries",
        usepager : true, //是否分页
//        minwidth: 30, //列的最小宽度
//        minheight: 80, //列的最小高度
//        nowrap: true, //是否不换行
//        page: 1, //current page,默认当前页
//        total: 1, //total pages,总页面数
        rp : 10, // results per page,每页默认的结果数
//        useRp: true, //use the results per page select box,是否可以动态设置每页显示的结果数
//        rpOptions: [10, 15, 20, 25, 40, 100], //可选择设定的每页结果数
        showTableToggleBtn: true, //是否显示【显示隐藏Grid】的按钮
//        pagestat: "显示记录从{from}到{to}，总数 {total} 条",
//        procmsg: "正在处理数据，请稍候 ...",
//        errormsg: "发生错误", //错误提升信息
//        nomsg: "没有符合条件的记录存在", //无结果的提示信息
//        showToggleBtn: true, //是否允许显示隐藏列，该属性有bug设置成false点击头脚本报错。
//        hideOnSubmit: true, //是否在回调时显示遮盖
//        autoload: true, //自动加载，即第一次发起ajax请求
        checkbox : true,// 是否要多选框
//        gridClass : "bbit-grid", //样式 
//        onSuccess: function() {alert(333)}, //成功后执行
//        onSubmit: function() {alert(444)}, // 调用自定义的计算函数，基本没用    
//      singleSelect : true,
//        striped: true, //是否显示斑纹效果，默认是奇偶交互的形式
//        ajaxSetting : {
//        	getData : function() {
//        		return JSON.stringify({});
//        	},
//        	contentType : "application/json"
//        },
        
//        searchitems : [
//                       {display: "姓名", name : "Name", isdefault: true}
//                       ],
//        buttons : [
//                 { name: "添加", bclass: "add", onpress: $.noop },
//                 { name: "修改", bclass: "edit", onpress: $.noop },
//                 { name: "删除", bclass: "delete", onpress: $.noop },
//                 { separator: true }
//                 ],   
//     Flexigrid——colModel:
//          属性名    类型    描述
//          display    string    显示的列名
//          name    string    绑定的列名
//          sortable bool    是否可以排序
//          align    string    对其方式
//          width    int    列的宽度
//          hide    bool    是否隐藏该列
//          pk    bool    是否为主键标识、如果是则隐藏该列，值存入隐藏域中
//          process    function    
//          customValue function    自定义显示值。(如性别：数据库为Bit类型，通过customValue方法返回“男/女”)参数：value,i
//        colModel : [ {
//            "display" : "姓名",
//            "name" : "Name",
//            "width" : 100,
//            "sortable" : false,
//            "align" : "left",
//            "dataAlign" : "left"
//        }, {
//            "display" : "年龄",
//            "name" : "Age",
//            "width" : 100,
//            "sortable" : false,
//            "align" : "left",
//            "dataAlign" : "left"
//        }, {
//            "display" : "Option",
//            "name" : "Option",
//            "width" : 300,
//            "sortable" : false,
//            "align" : "left",
//            "dataAlign" : "left"
//        } ],
//        preProcess : function(data) {
//            return data;
//        },
//        doDbClick : function() {
//            alert("dbclick");
//        }
//        Flexigrid——事件
//        事件名        参数                    描述            返回值
//        onDragCol    dcoln,dcolt                拖动列后触发         无
//        onToggleCol    cid,visible                隐藏/显示列后触发    无
//        onChangeSort    sortname,sortorder            自定义排序事件        无
//        onChangePage    newp                    自定义翻页事件        无
//        onSuccess    无                    数据获取成功时触发    无
//        onError        XMLHttpRequest,textStatus,errorThrown   出现错误时触发        无
//        onSubmit    无                    在获取数据前时触发    bool
//        onRowSelect    this                    行选中事件        无
};

/*
 * flexigrid的扩展
 */
define([_modules.lib.flexigrid], function() {
	
	var _flexigrid = $.fn.flexigrid;
	$.fn.flexigrid = function(p) {
	    p = $.extend({}, _flexigrid_p, p);
	    
	    // 改造1：改造p.preProcess函数
		var _preProcess = p.preProcess;
		p.preProcess = function(jsonData) {
            if (_preProcess) {
            	jsonData = _preProcess.call(p, jsonData) || {};
            }
            
//            jsonData.total = jsonData.total;
            jsonData.page = jsonData.pageNum;
            jsonData.rows = jsonData.list;
            
			return jsonData;
		};
		
		return _flexigrid.call(this, p);
		
//		var g = this[0].grid;
//		p = this[0].p;
	};
	
    $.fn.flexGetParams = function () {
        // 插件 获取flexigrid的params
        var p, params;
        this.each(function () {
            if (this.grid) p = this.p;
        });
        
        params = {
            page: p.newp,
            rp: p.rp,
            sortname: p.sortname,
            sortorder: p.sortorder,
            qtype: p.qtype,
            query: p.query
        };
         
        return params;
    };
	
});
