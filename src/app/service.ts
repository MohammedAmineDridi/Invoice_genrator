import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

 import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root',  // le service partagable dans tt l'app .
  })


  export class Service {


    constructor(private http: HttpClient) { }

     // test route 
     test(){

      const url_test_route = "http://localhost:8088/api/v1/etudiant2" ;
  
        return this.http.get<any>(url_test_route) ; // observable object
     }

     login(email,password) : Observable<any>  {

      // let postData_user = {email : email ,password :password};
       
      const url_login = "http://localhost:8022/api/v2/login_rh" ;
       return  this.http.post(url_login,{
        email:email,
        password:password
       });
      }

      // employees  crud

      // 1 - get list of employees .

      getListEmployees(){

        const url_list_employees = "http://localhost:8022/api/v2/employees_list" ;
    
          return this.http.get<any>(url_list_employees) ; // observable object
       }

       add_employee(first_name , last_name ,age , email , phone , post , hiring_date , department , salary , end_date , cin , type_contrat
        , archived , photo){
        const url_add_employee = "http://localhost:8022/api/v2/add_employee" ;
        return  this.http.post(url_add_employee,{
          first_name:first_name,
          last_name:last_name,
          age:age,
          email:email,
          phone:phone,
          post:post,
          hiring_date:hiring_date,
          department:department,
          salary:salary,
          end_date:end_date,
          cin:cin,
          type_contrat:type_contrat,
          archived:archived,
          photo:photo
        });
       }

       // update employee

       update_employee(id , first_name , last_name ,age , email , phone , post , hiring_date , department , salary , end_date , cin , type_contrat
        , archived , photo){
        const url_add_employee = "http://localhost:8022/api/v2/update_emp/"+id ;
        return  this.http.post(url_add_employee,{
          first_name:first_name,
          last_name:last_name,
          age:age,
          email:email,
          phone:phone,
          post:post,
          hiring_date:hiring_date,
          department:department,
          salary:salary,
          end_date:end_date,
          cin:cin,
          type_contrat:type_contrat,
          archived:archived,
          photo:photo
        });
       }




       // delete employee by id .

       deleteEmployee(id){

        const url_delete_emp = "http://localhost:8022/api/v2/deleteEmployeeById/"+id ;
    
          return this.http.get<any>(url_delete_emp) ; // observable object
       }

       // get employee by id 

       getEmployeeById(id){

        const url_getemployee_by_id = "http://localhost:8022/api/v2/getEmployeeById/"+id ;
    
          return this.http.get<any>(url_getemployee_by_id) ; // observable object
       }
        
       
       // recherche dynamique d'employee 

       search_employee(search){
        const url_search_employee = "http://localhost:8022/api/v2/getEmployeeByAll/"+search ;
    
        return this.http.get<any>(url_search_employee) ;
       }


       // part 2 : RH Manager


       add_rh_manager( first_name , last_name , email ,phone , password , photo ){

        const url_add_employee = "http://localhost:8022/api/v2/signin_rh" ;
        return  this.http.post(url_add_employee,{
          first_name:first_name,
          last_name:last_name,
          email:email,
          phone:phone,
          password:password,
          photo:photo
        
        });
       }


       // add client . 

       add_client( nom_client , addresse_client , email_client  ){

        const url_add_employee = "http://localhost:8022/api/v2/add_client" ;
        return  this.http.post(url_add_employee,{
          nom:nom_client,
          addresse:addresse_client,
          email:email_client,
          
        });
       }

     
       getAllClients(){
        const url_get_all_clients = "http://localhost:8022/api/v2/getAllClients" ;
    
        return this.http.get<any>(url_get_all_clients) ;
       }


       // dynamic search 

       search_client(search){
        const url_search_client = "http://localhost:8022/api/v2/searchclient/"+search ;
    
        return this.http.get<any>(url_search_client) ;

       }


       //  delete client by id .value

       delete_client_by_id(id){
        const url_delete = "http://localhost:8022/api/v2/deleteClientById/"+id ;
        return this.http.get<any>(url_delete) ;
       }

       // get client by id . 

       get_client_by_id(id){
        const url_get_client_by_id = "http://localhost:8022/api/v2/getClientById/"+id ;
        return this.http.get<any>(url_get_client_by_id) ;
       }

       // update client 

       update_client(id,nom,addresse,email) {

        const url_update_client = "http://localhost:8022/api/v2/update_client/"+id ;
        return  this.http.post(url_update_client,{
          nom:nom,
          addresse:addresse,
          email:email,
          
        });
       }


       // part 2 : facture 

       // add facture 


       add_facture(quantite,designation,prix_unitaire,prix_totale,prix_totale_tva
        ,nom_client) {

        const url_add_facture = "http://localhost:8022/api/v2/add_facture" ;
        return  this.http.post(url_add_facture,{
          quantite:quantite,
          designation:designation,
          prix_unitaire:prix_unitaire,
          prix_totale:prix_totale,
          prix_totale_tva:prix_totale_tva,
          nom_client:nom_client
        });
       }

       get_facture_by_client_nom(nom_client){
        const url_facture_by_client_nom = "http://localhost:8022/api/v2/get_facture_by_client_nom/"+nom_client ;
        return this.http.get<any>(url_facture_by_client_nom) ;
       }

       // get somme des produits tot dans facture 

       get_somme_totale_facture(nom_client){
        const url_somme_tot_produit_facture = "http://localhost:8022/api/v2/get_somme_facture/"+nom_client ;
        return this.http.get<any>(url_somme_tot_produit_facture) ;
       }

       // /send_mail/{from}/{to}/{msg}/{subject}


       send_facture_pdf_mail(from,to,msg,subject){

        const url_mail_facture = "http://localhost:8022/api/v2/send_mail/"+from+"/"+to+"/"+msg+"/"+subject ;
        return this.http.get<any>(url_mail_facture) ;

       }

       // get client by nom_client : SearchClientbyNom


       
       getClientBynom(nom_client){

        const url_client = "http://localhost:8022/api/v2/SearchClientbyNom/"+nom_client;
        return this.http.get<any>(url_client) ;

       }


       // delete the pdf file /delete_pdf_file 

       delete_pdf_file(){

       const url_delete_file = "http://localhost:8022/api/v2/delete_pdf_file";
       return this.http.get<any>(url_delete_file) ;

        }




      }

  

