<!DOCTYPE html>
<html>
<head>
<title>index</title>
<%@ include file="/WEB-INF/page/common/head.jsp"%>
</head>
<body>
	<h1 onclick="">dog</h1>
	<div id="searcherContainer">
		<div containerHead>
			<div containerTitle>searcher title</div>
			X
		</div>
		<div containerBody>
			<form>
				name <input name="name" value=""><br> 
				age <input name="age" value=""><br>
			</form>
			<input search type="button" value="search">
		</div>
	</div>
	
	<div id="quickSearcherContainer">
		quickSearcher
		<input quickSearch placeholder="quicksearch">
	</div>
	
	<div id="listContainer">
		<table containerBody>
		</table>
	</div>
</body>
</html>
<%@ include file="/WEB-INF/page/common/foot.jsp"%>
