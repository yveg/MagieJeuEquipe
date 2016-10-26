/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var imgtete = ["Images/tete/asssasin.png", "Images/tete/bleu.png", "Images/tete/bleu_inv.png", "Images/tete/blond.png",
    "Images/tete/brun.png", "Images/tete/burren.png", "Images/tete/captain.png", "Images/tete/chatt.png",
    "Images/tete/element.png", "Images/tete/fleche.png", "Images/tete/francois.png", "Images/tete/geule.png",
    "Images/tete/horus.png", "Images/tete/inuit.png", "Images/tete/jinx.png", "Images/tete/leadd.png"];

var joueurs = ["thomas", "maxim", "julien", "abdullatif", "sohab", "jerome", "edouard", "amaury", "francois", "julien", "marc", "laurent", "nordine", "omar", "nicolas", "amon", "julien"];
var ingredientimg = ["Images/ingredient/batfinal.jpg", "Images/ingredient/crapaud.jpg", "Images/ingredient/lapiz.jpg", "Images/ingredient/sand2vierge.jpg", "Images/ingredient/unicorn.jpg"];
var sortimg = [];

function chargeZoneCartesJoueurAct(){
   
    $('.jcarte').load("ajax_zone_cartes_joueur_act");
}

function avatar() {


    //   affichage avatar de moi
    var alea = Math.floor(Math.random() * imgtete.length);
    var avat = imgtete[alea];
    $(".avatar").html("<img src=" + avat + " /><br>");
    var n = imgtete.length;
    for (i = 0; i < n; i++) {
        $('.champ').append("<img src=" + imgtete[i] + " /><br>");
    }
}
 avatar();
    // Charger ponctuellement les cartes du joueur act et autre joueurs
    //setInterval( chargeZoneCartesJoueurAct(), 1000 );
