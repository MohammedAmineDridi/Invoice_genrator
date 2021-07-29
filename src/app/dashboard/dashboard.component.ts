import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import{Service} from "../service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  clients ;


  prix_unitaire ;
  quantite ;

  text_facture ="";

  text_quantite="";
  text_designation="" ;
  text_prix_unitaire="";
  text_prix_totale = "";
  text_client_choosen="";

  constructor(private service:Service) { }

  ngOnInit(): void {

    this.clients = this.service.getAllClients().subscribe( (clients)=>{
        this.clients = clients ;
    });
  }

  btn_facture(f){
    alert("btn facture");
  }

  onEnter_prix_unitaire(f,event){
    
    var quantite = f.value['quantite'];

  var prix_unitaire = event.target.value ;

  var text_prix_totale = (prix_unitaire * quantite).toString() ;


  this.text_prix_totale =  text_prix_totale ;
/*
    alert(" quantite = " + quantite + " // pu = " + prix_unitaire
     +  " // prix tot = " + text_prix_totale ) ;
*/
  (<HTMLInputElement>document. getElementById("prix_totale") ).value = text_prix_totale.toString()  ;

  
  this.text_facture ="";
 
  this.text_prix_unitaire =  "<div style='display: flex;' >  <h4 style='color:#0290a2;'> prix unitaire =  </h4> " + "&nbsp;&nbsp;  <h4 style='color:#3c4858;'> " + prix_unitaire  + " DT </h4>  </div>";

    this.text_prix_totale = "<div style='display: flex;' >  <h4 style='color:#0290a2;'> prix totale =  </h4> " + "&nbsp;&nbsp;  <h4 style='color:#3c4858;'> " + this.text_prix_totale + " DT </h4>  </div>" ;

    this.text_facture += ( this.text_quantite + "" + this.text_designation +  ""  + this.text_prix_unitaire
      
     + ""  + this.text_prix_totale + "" + this.text_client_choosen )  ;


  }


  onEnter_quantite(f,event){

    var quantite = event.target.value ;
    
    var prix_unitaire = f.value['prix_unitaire'];

  var text_prix_totale = (prix_unitaire * quantite).toString() ;


  this.text_prix_totale = "<div style='display: flex;' >  <h4 style='color:#0290a2;'> prix totale =  </h4> " + "&nbsp;&nbsp;  <h4 style='color:#3c4858;'> " + text_prix_totale  + " DT </h4>  </div>" ;
/*
  alert(" quantite = " + quantite + " // pu = " + prix_unitaire
     +  " // prix tot = " + text_prix_totale ) ;
*/
    (<HTMLInputElement>document. getElementById("prix_totale") ).value = text_prix_totale.toString() + " DT " ;

    this.text_facture ="";

      this.text_quantite = "<div style='display: flex;' >  <h4 style='color:#0290a2;'> quantite =  </h4> " + "&nbsp;&nbsp;  <h4 style='color:#3c4858;'> " + quantite + "</h4>  </div>"  ;

      this.text_facture += ( this.text_quantite +  "" + this.text_designation +  ""  + this.text_prix_unitaire +  ""  + this.text_prix_totale
      + this.text_client_choosen ) ;
  }
  onEnter_designation(event){

    var designation = event.target.value

    this.text_facture ="";

    this.text_designation = "<div style='display: flex;' >  <h4 style='color:#0290a2;'> designation =  </h4> " + "&nbsp;&nbsp;  <h4 style='color:#3c4858;'> " + designation + "</h4>  </div>" ;

      this.text_facture += ( this.text_quantite +  "" + this.text_designation +  ""  + this.text_prix_unitaire +  ""  + this.text_prix_totale
      + this.text_client_choosen ) ;
  }
  


  // select client function 

  nom_client ;
  
  select_client(value){

    this.nom_client = value ; 
    
    var client_choosen = value ; 

    this.text_client_choosen = "<div style='display: flex;' >  <h4 style='color:#0290a2;'> client =  </h4> " + "&nbsp;&nbsp;  <h4 style='color:#3c4858;'> " + client_choosen + "</h4>  </div>" ;

    this.text_facture = "" ;
    this.text_facture = ( this.text_quantite + this.text_designation +
      this.text_prix_unitaire + this.text_prix_totale );

      this.text_facture +=  "<div style='display: flex;' >  <h4 style='color:#0290a2;'> client =  </h4> " + "&nbsp;&nbsp;  <h4 style='color:#3c4858;'> " + client_choosen + "</h4>  </div>" ;



  }


  add_product(f){

  var quantite = f.value['quantite'];

  var designation = f.value['designation'];

  var prix_unitaire = f.value['prix_unitaire'] ;

  var prix_totale = (<HTMLInputElement>document. getElementById("prix_totale") ).value ;

  var prix_totale_tva =( parseFloat(prix_totale) - ( parseFloat(prix_totale)*20/100) ).toString() ;

  var nom_client = this.nom_client ;

   // this.service.add_facture()
   /*
   alert("quantite = " + quantite + " / designation " + designation +
   " / prix_unitaire = " + prix_unitaire + " / prix totale =  " +prix_totale+
   " / prix totale tva = " + prix_totale_tva + " / nom_client  = " + this.nom_client ) ;
*/
    this.service.add_facture(quantite,designation,prix_unitaire,
      prix_totale,prix_totale_tva,nom_client).subscribe((data)=>{
        console.log(data);
      });

  }




}
