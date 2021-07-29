import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vaccations',
  templateUrl: './vaccations.component.html',
  styleUrls: ['./vaccations.component.css']
})
export class VaccationsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  class_accept = "nav-link " ;

  class_reject = "nav-link ";

  leave(){
   this. class_accept = "nav-link " ;

   this.class_reject = "nav-link ";

  }


  test_active(id){

    if(id=="accept"){
      this.class_accept = "nav-link active" ;
      this.class_reject = "nav-link" ;
    }
    else if (id == "reject"){
      this.class_reject = "nav-link active";
      this.class_accept = "nav-link";
    }
    else{
      alert("eror");
    }

  }

}
