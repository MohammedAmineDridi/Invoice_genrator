package com.rh;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ManagerServiceImpl implements  Rh_managerService {


	@Autowired
	private Rh_managerRepository rep ;

	@Override
	public List<Rh_manager> getAllRHManager() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}
	
	@Override
	public void saveRHmanager(Rh_manager manager) {
		this.rep.save(manager);
	}

	@Override
	public Rh_manager getManagerById(long id) {
		
		Optional<Rh_manager> optional = rep.findById(id);
		
		Rh_manager manager = null ;
		
		if(optional.isPresent()) {
			
			manager = optional.get();
		}
		
		else {
			
			throw new RuntimeException( " manager d'id =  " + id + " is not found !! " ) ;
		}
		
		return manager ;
	}

	@Override
	public void deleteManagerById(long id) {
		
		
		this.rep.deleteById(id);
		
	}
	
	// login function 'rh manager' override .
	
	@Override
    public List<Rh_manager> loginRHmanager(String email,String password){
    	return this.rep.loginRHmanager(email, password) ;
    }
    
    @Override
    public List<Rh_manager> RegisterRHmanager(Rh_manager manager){
    	return this.rep.RegisterRHmanager(manager.getFirst_name(), manager.getLast_name(),
    			manager.getEmail(), manager.getPhone() , manager.getPassword()) ;
    }
    
    
    @Override
    public List<Object> getAllMeetings(){
    	return this.rep.getAllMeetings();
    }
    
	
}
