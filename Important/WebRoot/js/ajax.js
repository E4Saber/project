//AJAX   脚本

var http;

function ajax(url,id,name){
	
	if(window.ActiveXObject){
		http = new ActiveXObject("Microsoft.XMLHTTP");		
	
	}else if(window.XMLHttpRequest){
		http = new XMLHttpRequest();	
		
	}else{
		alert("create http error!");	
	}



	 

		//注册用于处理应答的函数
		//get
		/*
		http.open("GET",url + Math.random(),true);
		http.send();
		*/
		
		//post
		alert(url = url + "?SId=" + id + "&SName=" + name);
	
		http.open("post",url,true);
	
		
		http.setRequestHeader("Content-type","application/x-www-form-urlencoded");		
		http.send("SId=" + id + "&SName=" + name);
	    alert("open");
	

http.onreadystatechange=function(){
	  
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)	    
	    document.getElementById("div").innerHTML=xmlhttp.responseText;	
	   alert(xmlhttp.responseText);
	  };
	
	
}


















