import { Component } from '@angular/core';
import { OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit  {
  title = 'GestionRH';

  //login + meeting + dash + emps .
  class_header_login ="nav-item ";
  class_header_dashboard = "nav-item  " ;
  class_header_employees = "nav-item  ";
  class_header_meetings = "nav-item  " ;
 

  constructor() { }
  
  ngOnInit(): void {
  }

  

  test_active(id){
   // alert("id === " + id);
    var li = document.getElementById("filter");
var a_elements = li.getElementsByClassName("li1");
for (var i = 0, len = a_elements.length; i < len; i++ ) {
   if(a_elements[ i ].innerHTML == id){

  //  alert("id = " + id);
     
    if(id == 'login'){
     // alert(id + " // " + "login");
      this.class_header_login = 'nav-item active' ;
      this.class_header_dashboard = 'nav-item';
      this.class_header_employees = 'nav-item' ;
      this.class_header_meetings = 'nav-item';
  

    }
    else if (id == 'Ajouter facture'){

     // alert(id + "/" + "dashboard");
    
      this.class_header_login = 'nav-item' ;
      this.class_header_dashboard = 'nav-item active';
      this.class_header_employees = 'nav-item' ;
      this.class_header_meetings = 'nav-item';
      

    
    }
    else if (id == 'Facture'){
     

      this.class_header_login = 'nav-item' ;
      this.class_header_dashboard = 'nav-item';
      this.class_header_employees = 'nav-item active' ;
      this.class_header_meetings = 'nav-item';
      


    }
    
    else if (id == 'Ajouter client' ){
     

      this.class_header_login = 'nav-item' ;
      this.class_header_dashboard = 'nav-item';
      this.class_header_employees = 'nav-item ' ;
      this.class_header_meetings = 'nav-item active';


    }



    else{
      alert('error');
    }

   }
   
   
}

  }


}
