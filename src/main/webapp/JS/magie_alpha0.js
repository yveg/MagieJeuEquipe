/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var imgtete=["../image/tete/asssasin.png","../image/tete/bleu.png", "../image/tete/bleu_inv.png","../image/tete/blond.png",
    "../image/tete/brun.png","../image/tete/burren.png", "../image/tete/captain.png","../image/tete/chatt.png",  
"../image/tete/element.png","../image/tete/fleche.png", "../image/tete/francois.png","../image/tete/geule.png",
    "../image/tete/horus.png","../image/tete/inuit.png", "../image/tete/jinx.png","../image/tete/leadd.png" ];

var joueurs=["thomas","maxim","julien","abdullatif","sohab","jerome","edouard","amaury","francois","julien","marc","laurent","nordine","omar","nicolas","amon","julien"];
var ingredientimg=["../image/ingredient/batfinal.jpg","../image/ingredient/crapaud.jpg","../image/ingredient/lapiz.jpg","../image/ingredient/sand2vierge.jpg","../image/ingredient/unicorn.jpg"];
var sortimg=[];

function principal() {
    $(".champ").append(" <img src='../image/tete/asssasin.png' />");
    
   //   affichage avatar de moi
    var alea=Math.floor(Math.random()*imgtete.length);
    var avat=imgtete[alea];
$(".avatar").html("<img src="+avat+" /><br>");
    var n=imgtete.length;
      for (i = 0; i <n; i++) {
            $('.champ').append("<img src="+imgtete[i]+" /><br>");
        }
        
        //affichage des cartes  ingredients de moi
        //$('jcarte').append("<table align='center'><tr>");
           for (i = 0; i<27; i++) {
              // if (i%9==0) { $('jcarte').append("</tr></table><table><tr><br>"); alert("modulo"); }
                  if (i%9==0) { $('jcarte').append("<br>"); }

            //$('.jcarte').append(" <input type='image'  src='../image/dos2carte/01.png' onclick='setidcard' ></input> &nbsp;&nbsp; ");
            alea=Math.floor(Math.random()*ingredientimg.length);
            //$('.jcarte').append(" <td><input type='image'  src="+ingredientimg[alea]+" onclick='setidcard' ></input> </td>&nbsp;&nbsp; ");
                $('.jcarte').append(" <input type='image'  src="+ingredientimg[alea]+" onclick='setidcard' > &nbsp;&nbsp; ");

        }
          //$('jcarte').append("</tr></table>");
        
    }
$(document).ready(principal);