//vérification du numéro de téléphone. Attendre la saisie COMPLETE pour savoir si la réponse est bonne.    
var tel = document.querySelector("#tel");
var regexTel = /^(?:(?:\+|00)33|0)\s*[1-9](?:[\s.-]*\d{2}){4}$/;

tel.addEventListener("keyup", function() {
    if (!regexTel.test(tel.value)) {
        tel.focus();
        console.log("merde");
        document.querySelector("#errorTel").innerHTML = '<p style="color:red">Merci de ne pas saisir de lettres</p>';
        return false;
    }else {
        document.querySelector("#errorTel").innerHTML = '';
    }
})
 
//vérification du mail:
var email = document.querySelector("#email");
var regexMail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,6})+$/;

email.addEventListener("keyup", function () {
    if (!regexMail.test(email.value) ){
        email.focus();
        document.querySelector("#errorEmail").innerHTML = '<p style="color:red">Merci de saisir une adresse mail correcte</p>';
        return false;
    }else {
        document.querySelector("#errorEmail").innerHTML = '';
    }
})

//vérification des mots de passe
var pwd = document.querySelector("#pwd");
var pwdConfirmed = document.querySelector("#pwdConfirm");

pwdConfirmed.addEventListener("keyup", function (){
    if (!(pwd.value == pwdConfirmed.value)){
        pwdConfirmed.focus();
        document.querySelector("#pwdConfirmError").innerHTML = '<p style="color:red">Le mot de passe ne correspond pas.</p>';
        return false;
    }else {
        document.querySelector("#pwdConfirmError").innerHTML = '';
    }
})