import { Component, OnInit } from '@angular/core';

import {Service} from '../service' ;

@Component({
  selector: 'app-meetings',
  templateUrl: './meetings.component.html',
  styleUrls: ['./meetings.component.css']
})
export class MeetingsComponent implements OnInit {


  clients ;

  constructor(private service:Service) { }


  ngOnInit(): void {

      this.service.getAllClients().subscribe( (clients)=>{
          console.log(clients) ;
          this.clients = clients ;
      });

  }

  add_meeting(){
    document.getElementById("meeting1").style.display = "block" ;
  }

  add_the_meeting(){
    // add to database 

    document.getElementById("meeting1").style.display = "none" ;

  }
  
  close_the_meeting(){
    document.getElementById("meeting1").style.display = "none" ;
  }

  add_client(f){
    var nom = f.value['nom'];
    var addresse = f.value['addresse'];
    var email = f.value['email'];

   //  alert(nom + " / " + addresse + " / " + email) ;

    this.service.add_client(nom,addresse,email).subscribe((data)=>{
      console.log(data);
    })
  }

  search_client(value_search){
      this.service.search_client(value_search).subscribe( (data)=>{
          console.log(data);
          this.clients = data ;
      });

  }

  // delete client 

  delete_client_byid(id){
    this.service.delete_client_by_id(id).subscribe( (data)=>{
        console.log(data) ;
    });
  }

  // update client 

  client_id ;
  client_nom ;
  client_email ;
  client_addresse ;

  update_client_by_id(id){
    this.service.get_client_by_id(id).subscribe( (client)=>{
        console.log(client) ;

        var old_client_id = client.id ;
        var old_client_nom = client.nom ;
        var old_client_addresse = client.addresse ;
        var old_client_email = client.email ;        

       // alert(old_client_id + " / " +old_client_nom+" / " + old_client_addresse + " / " + old_client_email) ;


        this.client_nom = old_client_nom ;
        this.client_addresse = old_client_addresse ;
        this.client_email = old_client_email ;
        this.client_id = old_client_id ;

    });   
  }


  // modifier un client 

  modifier_client(id_client,f){
    
    // alert(id_client) ;

    // new client data update .

    var new_nom = f.value['nom'];

    var new_addresse = f.value['addresse'] ;

    var new_email = f.value['email'] ;

   // alert(id_client + " / " + new_nom + " / " + new_addresse + " / " + new_email ) ;

    this.service.update_client( id_client.toString() , new_nom , new_addresse , new_email ).subscribe( (data)=>{
      //  alert(data);
    });

  }

}
