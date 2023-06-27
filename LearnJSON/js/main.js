var start = '{"Arvind":{"id":"101", "age":"29", "degree":"MCA"}, "Rajat":{"id":"102", "age":"23", "degree":"BCA"}}';
var myObj = JSON.parse(start);

document.getElementById("pId").innerHTML = myObj;
console.log(myObj);




/*var xhr = new XMLHttpRequest();
xhr.open('GET', 'https://systran-systran-platform-for-language-processing-v1.p.rapidapi.com/translation/text/translate', true);



xhr.onload = function(){
    if(xhr.status ===200){
        var myStuff = JSON.parse(xhr.responseText);
        console.log(myStuff);    
    }
    
}

xhr.send();*/

//e04797e6e1msh0f45d2e129f741dp10bc5cjsnd40be2d71f27

/*var data = null;

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function () {
    /*if (xhr.status ==='200') {
        console.log(xhr.responseText);
    }*/
    /*if (this.readyState === this.DONE) {
		console.log(this.responseText);
	}*/
});

/*xhr.open("GET", "http://systran-systran-platform-for-language-processing-v1.p.rapidapi.com/translation/text/translate?source=auto&target=hi&input=survive");
xhr.setRequestHeader("x-rapidapi-host", "systran-systran-platform-for-language-processing-v1.p.rapidapi.com");
xhr.setRequestHeader("x-rapidapi-key", "e04797e6e1msh0f45d2e129f741dp10bc5cjsnd40be2d71f27");

xhr.send(data);*/