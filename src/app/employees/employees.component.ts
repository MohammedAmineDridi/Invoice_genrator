import { Component, OnInit } from '@angular/core';

import{Service} from '../service' ;

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  nom_client;
  clients ;
  constructor(private service:Service) { }

  ngOnInit(): void {
    this.clients = this.service.getAllClients().subscribe( (clients)=>{
      this.clients = clients ;
  });

   // document.getElementById("container_facture").style.display = "none" ;

  }

  facture_data;
  somme_totale;
  select_client(value){
  // alert("nom client = " + this.nom_client);
   this.nom_client = value ; 

  
   this.service.get_facture_by_client_nom(this.nom_client).subscribe((data)=>{
      this.facture_data = data ;
      // alert( data[0]['quantite'] ) ;
   });

   this.service.get_somme_totale_facture(this.nom_client).subscribe((somme_tot)=>{
     // alert(somme_tot);
      this.somme_totale = somme_tot ;
   });
   

  }



  btn_facure_mail(){
    var from_source = "mohammedamine.dridi.esprit@gmail.com";
    var client_name = this.nom_client ;
    // alert(client_name) ;
    this.service.getClientBynom(client_name).subscribe( (client)=>{

      var to_client = client[0]['email'];
      var msg = "Bonjour , c'est la facture de " + client_name ;
      var subject = "facture de sotuiaa" ;
      
      /*
      alert("source_mail = " + from_source + " / destination_email = " +
      
      to_client + " / msg = " + msg + " / subject = " + subject);


      */

        // send email 

        this.service.send_facture_pdf_mail(from_source,to_client,subject,msg).subscribe((email)=>{
            console.log(email);
            alert(email);

            // after send mail -> delete facture.pdf

            // delete the facture pdf file .
            if(email){
              this.service.delete_pdf_file().subscribe( (data)=>{
                console.log(data);
                alert("file deleted succ");
                            });
            }else{
              alert("no");
            }
     

        });

       

    });

     

  }

}
