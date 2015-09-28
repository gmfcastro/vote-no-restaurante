$(document).ready(function(){
var restaurants;
var avalibleOptions;
var option1;
var option2;
var doneOptions = [];

$.get( "restaurants", function( data ) {
	  avalibleOptions = data;
	  console.log(JSON.stringify(data));
	  
	  buildOption();
});

var buildOption = function(){
	
	if(avalibleOptions.length > 0){
		var index;
	
		if(!option2){
			index = Math.floor((Math.random() * avalibleOptions.length) + 0);
			option1 = avalibleOptions[index];
			avalibleOptions.splice(index,1);
			doneOptions.push(option1);
			
			index = Math.floor((Math.random() * avalibleOptions.length) + 0);
			option2 = avalibleOptions[index];
			avalibleOptions.splice(index,1);
			doneOptions.push(option2);
		}else{
			index = Math.floor((Math.random() * avalibleOptions.length) + 0);
			option2 = avalibleOptions[index];
			avalibleOptions.splice(index,1);
			doneOptions.push(option2);
		}
		
		
		$("#option1").text(option1.name);
		document.getElementById("box1").onclick = function(){vote(option1)};
		
		$("#option2").text(option2.name);
		document.getElementById("box2").onclick = function(){vote(option2)};
	}else{
		window.location.replace('user');
	}
};

//EVENTS

var vote = function(option){
	$.ajax({
        
        type: "POST",
        data: JSON.stringify(option),
        contentType: "application/json",
        url: "vote",
        dataType: "json",
        success: function(data){
        	option1 = option;
        	buildOption();
        }
    });
}


});