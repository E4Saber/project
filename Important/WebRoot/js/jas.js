
function subOnClick(){
	
	var name = document.getElementById("SName").value;
    var id = document.getElementById("SId").value;
    var url = window.location.href+"reg";
    alert(url);
	if(name == "" || id == ""){
		alert("请输入用户信息");
		document.getElementById("SName").focus();
	}else{
		//-----------------
		ajax(url,id,name);
	}
}
//confirm("1");