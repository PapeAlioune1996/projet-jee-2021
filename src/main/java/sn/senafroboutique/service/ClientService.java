package sn.senafroboutique.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sn.senafroboutique.dao.ClientRepository;
import sn.senafroboutique.dao.ParametreRepository;
import sn.senafroboutique.dao.UserRepository;
import sn.senafroboutique.model.Client;
import sn.senafroboutique.model.Parametre;
import sn.senafroboutique.model.User;

@Service
@Transactional
public class ClientService {
	@Autowired 	ClientRepository repository;
	@Autowired 	ParametreRepository paramRepository;
	@Autowired 	UserRepository userRepository;
	public List<Client> getAll() {
		System.out.println("Get all Clients 11111...");
    	return repository.findAll(Sort.by("libelle").ascending());	    	
    }
	
	
    public Optional<Client> findByCode(int id) {
        return repository.findByCode(id);
    }
    
    public long save(Client Client) {
    	 long id = 1;
		 Optional<Parametre> ParamInfo = paramRepository.findById(id);
	 	    if (ParamInfo.isPresent()) {
		    	Parametre param = ParamInfo.get();
		           param.setNumc(param.getNumc()+1);
		           param = paramRepository.save(param);
		    }
	 	   User user = new User();
	        user.setUsername(Client.getEmail());
	        user.setEmail(Client.getEmail());
	        user.setPassword(Client.getPwd());
	        user.setRole("CLIENT");
	        user.setActive(true);
	        userRepository.save(user);
        return repository.save(Client)
                             .getId();
    }
    public void update(int code, Client Client) {
        Optional<Client> cli = repository.findByCode(code);
        if (cli.isPresent()) {
            Client cl = cli.get();
            cl.setLibelle(Client.getLibelle());
            cl.setAdresse(Client.getAdresse());
            repository.save(cl);
        }
    }
    
    
  

    public List<Client> findByLibelle(String libelle) {
        return repository.findAllByLibelleContaining(libelle);
    }
    
    public List<Client> findByEmail(String email) {
        return repository.findAllByEmail(email);
    }
    
    public void delete(int code) {
        Optional<Client> cat = repository.findByCode(code);
        cat.ifPresent(repository::delete);
    }
	


}
