import { Component, OnInit } from '@angular/core';
import {Service} from '../service' ;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  nom ;
  constructor(private service:Service ) { }

  ngOnInit(): void {
  }

  login_btn_function(f){
    var email = f.value["email"];
    var password = f.value["password"];
     this.service.login(email,password).subscribe((data)=>{
       if(data != ""){
        alert("welcome " + data[0]['first_name']);
        this.nom = data[0]['first_name']  ;
       }
       else{
         alert("email or password wrong !!");
         this.nom="";
       }
       this.nom = data[0]['first_name']  ;
     });    

     alert("nom = " + this.nom ) ;
  }


}
