function validateString(str,exp){
    return exp.test(str);
}
function showError(id,msg) {
    document.getElementById(id).innerHTML=msg;
    document.getElementById(id).style.visibility='visible';
}

function formv(){
    //event.preventDefault();
    let nameExp=/^[a-zA-Z ]+$/;
    let numExp=/^[0-9]+$/;
    
    let bcode=document.getElementById('bcode');
    let bname=document.getElementById('bname');
    let author=document.getElementById('author');
    let flag=true;
    console.log(author.value);
    console.log("inside form");

    //validate code
    if (validateString(bcode.value,numExp)) {
        document.getElementById('bcodeerror').style.visibility='hidden';
    }else{
        showError('bcodeerror','* invalid');
        flag=false;
    }
    
    //validate name
    if (validateString(bname.value,nameExp)) {
        document.getElementById('bnameerror').style.visibility='hidden';
    }else{
        showError('bnameerror','* invalid');
        flag=false;
    }
    console.log(author.value.length);
    //return false;
    //validate author
    if(author.value.length>0){
		document.getElementById('authorerror').style.visibility='hidden';
	}else{
		 showError('authorerror','* selection mandatory');
        flag=false;
	}
    
       return flag;

       
}