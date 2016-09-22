<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
    // 工程路径
    String _CONTEXT_PATH = request.getContextPath();
    // resources路径
    String _RESOURCES_PATH = _CONTEXT_PATH + "/resources";
    // js路径
    String _JS_PATH = _RESOURCES_PATH + "/js";
    // js-biz路径
    String _JS_BIZ_PATH = _RESOURCES_PATH + "/js-biz";
    // css路径
    String _CSS_PATH = _RESOURCES_PATH + "/css";
    
    // 当前页面js脚本路径
    String _JS_FILE_PATH = request.getRequestURI().substring(0, request.getRequestURI().lastIndexOf("/")).replace("/WEB-INF/page/", "/resources/js-biz/") + "/module.js";
%>
<script>
    var _CONTEXT_PATH = "<%=_CONTEXT_PATH%>";
    var _RESOURCES_PATH = "<%=_RESOURCES_PATH%>";
    var _JS_PATH = "<%=_JS_PATH%>";
    var _JS_BIZ_PATH = "<%=_JS_BIZ_PATH%>";
    var _CSS_PATH = "<%=_CSS_PATH%>";
</script>
