package sn.senafroboutique.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.senafroboutique.dto.ListCategorie;
import sn.senafroboutique.model.Scategorie;
import sn.senafroboutique.service.ScategorieService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ScategorieController {
		 @Autowired
		    private ScategorieService scatService;
		 @GetMapping("/scategories/7/{code}")
		 public  int getCode(@PathVariable String code) {
			 System.out.println("Get Numbers...");
			 int  x = scatService.nbre(code);
			 System.out.println(x);
			 if (x == 0)
			 {
				 return 0;
			 }
			 else
			 {
				 return scatService.max(code);
			 }
		 }
		 
		
		 @GetMapping("/scategories")
		    public List<ListCategorie> list() {
			 System.out.println("Get all Categories...");
		             return scatService.getAll();
		   }
		
		 	 
		 @GetMapping("/scategories/{code}")
		 public ResponseEntity<Scategorie> post(@PathVariable String code) {
		        Optional<Scategorie> scat = scatService.findByCode(code);
		        return scat.map(ResponseEntity::ok)
		                   .orElseGet(() -> ResponseEntity.notFound()
	                                                  .build());
		    }
		    
		 @PostMapping("/scategories")
		    public long save(@RequestBody Scategorie Scategorie) {
			
		        return scatService.save(Scategorie);
		    }

		 @PutMapping("/scategories/{code}")
		    public void update(@PathVariable String code, @RequestBody Scategorie scategorie) {
		        Optional<Scategorie> scat = scatService.findByCode(code);
		        if (scat.isPresent()) {
		            scatService.update(code, scategorie);
		        } else {
		            scatService.save(scategorie);
		        }
		    }

		    @DeleteMapping("/scategories/{code}")
		    public void delete(@PathVariable String code) {
		        scatService.delete(code);
		    }

		    @GetMapping("/scategories/5/{code}")
			 public ResponseEntity<List<Scategorie>> listCateg(@PathVariable String code) {
					List<Scategorie> scategories = scatService.findByCcateg(code);
			        return new ResponseEntity<List<Scategorie>>(scategories, HttpStatus.OK);
			    }
		    

		  
}
