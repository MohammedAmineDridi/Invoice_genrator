import { Component, OnInit } from '@angular/core';
import {Service} from '../service' ;

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private service:Service) { }

  ngOnInit(): void {
  }

  btn_sign_click(f){

    var first_name = f.value['first_name'] ;
    var last_name = f.value['last_name'] ;
    var email = f.value['email'];
    var phone = f.value['phone'];
    var password = f.value['password'];
    var photo = f.value['photo'] ;

    
    alert( first_name + " / "+ last_name + " / " + email + " / " + phone
    +" / " + password + " / " + photo ) ;

    

  
  }

}
