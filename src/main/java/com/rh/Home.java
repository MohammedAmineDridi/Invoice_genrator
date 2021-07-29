package com.rh;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.itextpdf.html2pdf.HtmlConverter;

//it's the main 'rest controller' .

// @CrossOrigin(origins="http://localhost:4200")

@RestController
@RequestMapping(value="/api/v2")
public class Home {

	
	@Autowired
	private EmployeeService emp_service ;
	
	@Autowired
	private Rh_managerService rh_service ;
	
	@Autowired
	private MeetingService meeting_service ;
	
	@Autowired
	private VaccationService vaccation_service ;
	
	
	// @CrossOrigin(origins="http://localhost:4200")
	
	@GetMapping(value={"/",""} )
	public ArrayList<String> test() {
		
		ArrayList<String> list1 = new ArrayList<String>();
		
		list1.add("amine");
		
		list1.add("barhoum");
		
		return list1 ;
		
	}
	
	// part 1 : employye crud
	
	
	// route 2  : get all employees 
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/employees_list")
	public List<Employee> get_emps(){
		return emp_service.getAllEmployees();
	}
	
	
	
	
	// test : customize query  : get employee with first name .
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/get_emp_fname/{first_name}")
	public List<Employee> getEmpsByFirstName(@PathVariable String first_name){
		return emp_service.getEmployeeByFirstName(first_name) ;
	}
	
	
	// part 1 : employees
	
	// route1  : employee search dynamic by first_name or last_name .
	
	@CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="/getEmployeeByAll/{search}")
    public List<Employee> search(@PathVariable String search){
    	return this.emp_service.getEmployeeByAll(search);
    }
	
    // route 2 :get non archived employees
    
	@CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="/getNonArchivedEmployees")
    public List<Employee> getNonArchived(){
    	return this.emp_service.getNonArchivedEmployees("no");
    }
    
   // route 3 : get archived employees 
    
	@CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="/getArchivedEmployees")
    public List<Employee> getArchived(){
    	return this.emp_service.getNonArchivedEmployees("yes");
    }
    
    
    // route 4 : add employee 
	@CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="/add_employee")
    
	public void add_employee(@RequestBody Employee emp ){
	
			this.emp_service.saveEmployee(emp);
	}
    
    
    // route 5 : get employee by id 
    
	@CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="/getEmployeeById/{id}")
    public Employee getEmplById(@PathVariable int id){
    	return this.emp_service.getEmployeeById(id);
    }
    
    
    // route 6 : delete employee by id 
    
	@CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="/deleteEmployeeById/{id}")
    public void deleteEmployeeById(@PathVariable int id){
    	 this.emp_service.deleteEmployeeById(id);
    }
    
    // route : update employee
    
	@CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value="/update_emp/{id}")
    public Employee update_employee(@PathVariable long id ,@RequestBody Employee old_emp) {
    	return this.emp_service.update_employee(id, old_emp) ;
    }
    
    
    
    // part 2 : vaccation crud
    
	
	// route 7 : get coordinates of employee with vaccation (emp_id)
    
    @GetMapping(value="/getAllVaccations")
    public List<Vaccation> getAllVacations(){
    	return this.vaccation_service.getAllVacations();
    }
    
    
    // with join req  .
    
    @GetMapping(value="/getVaccations")
    public List<String> getVaccations(){
    	
    	return this.vaccation_service.getVaccation_join() ;
    }
	
    
    // route 8 : getVaccationByid
    
    @GetMapping(value="/getVaccationById/{id}")
    public Vaccation getVaccationById(@PathVariable int id) {
    	return this.vaccation_service.getVaccationById(id);
    }
    
    // route 9 : add vaccation .
    
    @PostMapping(value="/add_vaccation")
    public void addVaccation(@RequestBody Vaccation vaccation) {
    	this.vaccation_service.saveVaccation(vaccation);
    }
    
    // route 10 : delete vaccation 
    
    @GetMapping(value="/delete_vaccationbyid/{id}")
    public void deletevaccationbyid(@PathVariable int id) {
    	this.vaccation_service.deleteVaccationById(id);
    }
    
    
    
    
    
    
    
    // part 3 : vacation request crud .
    
    // route 8 : get list of vaccation requests .
    
    @GetMapping(value="/getVaccationRequests")
    public List<String> getVaccationReq(){
    	return this.emp_service.getVaccation_requests();
    }
    
    // get vaccation req by id 
    
    @GetMapping(value="/getVaccationRequests/{id}")
    public List<String> getVaccationReqById( @PathVariable String id ){
    	return this.emp_service.getVaccation_requestsById(id);
    }
    
    
    
    
    
    // part 4 : meeting crud .
    
    // route 9 : get all meetings
    
    @GetMapping(value="/getAllMettings")
    public List<Meeting> getAllMettings(){
    	return this.meeting_service.getAllMeetings();
    }
    
    // route 10 : get meeting by title (search meeting)
    
    @GetMapping(value="/getMettingByTitle/{title}")
    public List<Meeting> getMeetingByTitle(@PathVariable String title){
    	return this.meeting_service.getMeetingByTitle(title);
    }
    
    // route 11 : add meeting 
    
    @PostMapping(value="/add_meeting")
	public void add_meeting(@RequestBody Meeting meeting ){
	
			this.meeting_service.saveMeeting(meeting);
	}
    
    
    // route 12 : delete meeting by id
    
    @GetMapping(value="/deleteMeetingById/{id}")
    public void deleteMeetingById(@PathVariable int id ) {
    	this.meeting_service.deleteMeetingById(id);
    }
    
    // route 13 : update meeting
    
    @PostMapping(value="/update_meeting/{id}")
    public Meeting update_meeting( @PathVariable long id , @RequestBody Meeting meeting ) {
    	return this.meeting_service.update_meeting(id, meeting) ;
    }
    
    
    
    
	
	// part 2 : rh managers 
	
	
	// login route 'rh_manager'
    @CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="/login_rh")
	public List<Rh_manager> LoginManager(@RequestBody Rh_manager manager ){
		return rh_service.loginRHmanager(manager.getEmail() , manager.getPassword() );
	}
	
	
	// sign in route 'rh_manager'
	
	@PostMapping(value="/signin_rh")
	public List<String> RegisterManager(@RequestBody Rh_manager manager ){
		ArrayList<String> list = new ArrayList<String>();
		list.clear();
		 rh_service.saveRHmanager(manager);
		list.add("insert " + manager.getFirst_name() + " succ ");
		return list ; 
	}
	
	
	// html2pdf 
	
	// test file location 
	
	@GetMapping(value="/pdf")
	public List<String> pdf() throws IOException{
		 
		ClassPathResource  file_html = new ClassPathResource("C:/Users/dridi family/Desktop/VS_CODE/project_gestion_rh/GestionRH/src/app/employees/employees.component.html");
		List<String> a = new ArrayList<String>() ;
		a.add(file_html.getFilename()) ;
		
		HtmlConverter.convertToPdf(new File(file_html.getPath()),new File("demo-html-amine.pdf"));
		return a ;
	}
	
	// client part 
	
	@Autowired
	private ClientService client_service ;
	
	// get all client
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/getAllClients")
	public List<Client> getClients(){
		return this.client_service.getAllClients();
	}
	
	// get client by id 
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/getClientById/{id}")
	public Client getClientById(@PathVariable long id) {
			return this.client_service.getClientById(id);
	}
	
	
	
	// get client by nom_client 'SearchClientbyNom'
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/SearchClientbyNom/{nom}")
	public List<Client> SearchClientbyNom(@PathVariable String nom) {
			return this.client_service.SearchClientbyNom(nom);
	}
	
	
	
	// search client 
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/searchclient/{search}")
	public List<Client> getClients(@PathVariable String search){
		return this.client_service.searchClient(search);
	}
	
	// add client 
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="/add_client")
	public void add_client(@RequestBody Client client) {
		this.client_service.saveClient(client);
	}
	
	// delete client by id 
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/deleteClientById/{id}")
	public void delete_client_by_id(@PathVariable long id) {
		 this.client_service.deleteClientById(id);
	}
	
	// modifier un client 
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="/update_client/{id}")
	public ArrayList<String> update_clinet_by_id(@PathVariable long id , @RequestBody Client client) {
		 this.client_service.modifier_client(id, client) ;
		 ArrayList<String> list = new ArrayList<String>();
		 list.add( client.getNom() + " modifier avec succés") ;
		 return list ;
	}
	
	
	
	// partie 2 : facture 
	
	// ajouter une facture 
	

	@Autowired
	private FactureService facture_service ;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="/add_facture")
	public void add_facture(@RequestBody Facture facture) {
		this.facture_service.saveFacture(facture);
	}
	
	// get facture by client nom .
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/get_facture_by_client_nom/{nom_client}")
	public List<Facture> get_facture_by_nom_client(@PathVariable String nom_client) {
		return this.facture_service.getFactureByNomClient(nom_client);
	}
	
	// get sum of : prix totale des produits 
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/get_somme_facture/{nom_client}")
	public List<String> get_somme_facture_by_nom(@PathVariable String nom_client) {
		return this.facture_service.getSumFactureByNomClient(nom_client);
	}
	
	
	// function delete file 'pdf file' .
	
	@GetMapping(value="/delete_pdf_file")
	public void deletePdfFile() {
		File fileToDelete = new File("C://Users/dridi family/Downloads/facture.pdf");
		fileToDelete.delete();
		
	}
	
	
	// email part 
	
	@Autowired
	private sendEmailService email_service ;
	
	
	// send facture pdf .
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/send_mail/{from}/{to}/{msg}/{subject}")
	public List<String> sendMail(@PathVariable String from , @PathVariable String to , 
			@PathVariable String msg , @PathVariable String subject) throws MessagingException {
		// topic = subject // body = msg .
		
		 this.email_service.sendEmail(from, to, subject, msg);
		 
		 List<String> res = new ArrayList<String>() ;
		 
		 res.add("email sent succ to " + to) ;
		 
		 return res ;
	}
	
	
	
}
