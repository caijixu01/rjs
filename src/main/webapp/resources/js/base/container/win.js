"use strict"

/**
 * 弹窗
 */
defineModule(
[
 _modules.lib.jqModal,
 _modules.lib.jqDnR,
], 
_modules.base.container, 
function(_super) {
	var that = {
		/**
		 * 限制输入（鼠标点击，按键）
		 */
		isModal : true,
			
		openAction : "jqmShow",
		
		closeAction : "jqmHide",
		// ----------------------------------------------------------------------
		$getContainer : function() {
			if (!this.$container) {
				this.$container = this.createContainer();
			}
			return this.$container;
		},
		
		/**
		 * 生成弹窗DOM对象, 添加到body尾部.
		 */
		createContainer : function() {
			var html = '<div class="jqmWindow" style="width: 800px;">'
					+ '    <div class="drag">'
					+ '        <span containerTitle/>'
					+ '        <div class="close"/>'
					+ '    </div>' 
					+ '    <div containerBody/>' 
					+ '</div>';
		
			// 弹窗添加到body尾部.
			var d = $(html).appendTo("body");
		
			d.jqm({
				modal : this.isModal,// 限制输入（鼠标点击，按键）的对话
				overlay : 20, // 遮罩程度%
				onShow : function(h) {
					h.w.fadeIn(200);
				},
				onHide : function(h) {
					h.o ? h.o.remove() : undefined; // remove overlay
					h.w.fadeOut(200); // fadeOut slideDown
				}
			})
			.jqDrag('.drag');// 添加拖拽的selector
		
			var _that = this;
			$(".close", d).click(function() {
				_that.close();
			});
			
			return d;
		},
	};
	
	return that;
});
