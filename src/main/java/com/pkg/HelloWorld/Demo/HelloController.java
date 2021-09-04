package com.pkg.HelloWorld.Demo;

import java.net.URI;
import java.sql.Timestamp;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.sql.Timestamp;
import java.util.Date;
import com.pkg.HelloWorld.Demo.FoodService;


@RestController
public class HelloController {

	// Dependencies

	@Autowired
	private PlayerService service;

	@Autowired
	private PlayerRepo repo;

	@Autowired
	private IErrorLogger errlogger;
	
	@Autowired
	private FoodRepo foodreposerv;
	
	@Autowired
	private FoodService foodservice;

	// Endpoints

	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String Hello() {

		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	/// hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	@GetMapping("/players/all")
	public List<PlayerInfo> GetAllPlayers() {

		return service.findall();

	}

	@GetMapping("/players/player/{id}")
	public PlayerInfo GetAllPlayers(@PathVariable int id) throws UserNotFoundException {

		return service.findPlayer(id);

	}

	@GetMapping("/players/player/entity/{id}")
	public EntityModel<PlayerInfo> GetAllEntityPlayers(@PathVariable int id) throws UserNotFoundException {

		PlayerInfo info = service.findPlayer(id);

		if (info == null) {

			throw new UserNotFoundException();
		}

		@SuppressWarnings("rawtypes")
		EntityModel model = EntityModel.of(info);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).GetAllPlayers());
		model.add(link.withRel("all-Players"));
		return model;

	}

	@PostMapping("/players/add")
	public void addPlayer(@Valid @RequestBody PlayerInfo pl) {

		PlayerInfo savedplayer = service.save(pl);

		// return savedplayer;

	}

	@PostMapping("/players/addloc")
	public ResponseEntity<Object> addPlayerloc(@RequestBody PlayerInfo pl) {

		PlayerInfo savedplayer = service.save(pl);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
				.buildAndExpand(savedplayer.getName()).toUri();
		// return savedplayer;
		return ResponseEntity.created(location).build();

	}



	@GetMapping(value = "/hello2", headers = "X_VAL=7")
	public String Hello2() {

		return "Hello Soumyajit";
	}

	@GetMapping(value = "/hello2", headers = "X_VAL=10")
	public String Hello3() {

		return "You can have any girl you want!! Just Pray .";
	}

	@GetMapping(value = "/hello2", params = "X_VAL=1")
	public String Hello4() {

		return "You are Healthy ,Wealthy ,Lucky & Protected by God.";
	}

	@PostMapping("/players/jpa/addloc")
	public void addPlayerJPA(@RequestBody PlayerInfo pl) {

		// Timestamp Logic

		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);

		PlayerInfo savedplayer;
		try {
			savedplayer = repo.save(pl);
			ErrorLogger err = new ErrorLogger(date, "Data Saved", savedplayer.getName().toString());
			errlogger.save(err);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			System.out.println("Inside addPlayerJPA method of " + this.getClass().getName().toString());
			ErrorLogger err = new ErrorLogger(ts, e.getCause().toString() + "Could Not Save Data ",
					e.getMessage().toString());
			errlogger.save(err);

		}

	}
	
	
	@PostMapping("/players/jpa/addfoodloc")
	public void addFoodJPA(@RequestBody FoodHub fl) {

		// TimeStamp Logic

		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);

		FoodHub fooddata;

		try {

			fooddata = foodreposerv.save(fl);
			ErrorLogger err = new ErrorLogger(date, "Food Data Saved", fooddata.getFood_name().toString());
			errlogger.save(err);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			System.out.println("Inside addFoodJPA method of " + this.getClass().getName().toString());
			ErrorLogger err = new ErrorLogger(ts, e.getCause().toString() + " Could Not Save Data ",
					e.getMessage().toString());
			errlogger.save(err);
			e.printStackTrace();

		}

	}
	
	
	@PutMapping("/players/jpa/updatefood/{fid}")
	public ResponseEntity<Object> UpdateFoodJPA(@RequestBody FoodHub fl, @PathVariable Integer fid) {

		// TimeStamp Logic

		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);

		try {
			Optional<FoodHub> existfoodrec = foodreposerv.findById(fid);

			if (existfoodrec != null) {
				foodreposerv.save(fl);
				ErrorLogger err = new ErrorLogger(date, "Food Data Updated", fl.getFood_name().toString());
				errlogger.save(err);

				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
			{
				
				throw new UserNotFoundException("Did not find user");
			}

		} catch (Exception e) {

			System.out.println("Inside UpdateFoodJPA method of " + this.getClass().getName().toString());
			ErrorLogger err = new ErrorLogger(ts, e.getCause().toString() + " Could Not Update Data ",
					e.getMessage().toString());
			errlogger.save(err);
			e.printStackTrace();

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	

	}
	
	
	@PutMapping("/players/jpa/updatefoodanddelete/{fid}")
	public ResponseEntity<Object> UpdateFoodJPAandDeleteOldRecord(@RequestBody FoodHub fl, @PathVariable Integer fid) {

		// TimeStamp Logic

		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);

		try {
			Optional<FoodHub> existfoodrec = foodreposerv.findById(fid);

			if (existfoodrec != null) {
				
				FoodService.updateOldFoodRecord(fid);
				foodreposerv.save(fl);
				ErrorLogger err = new ErrorLogger(date, "Food Data Updated", fl.getFood_name().toString());
				errlogger.save(err);

				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
			{
				
				throw new UserNotFoundException("Did not find user");
			}

		} catch (Exception e) {

			System.out.println("Inside UpdateFoodJPA method of " + this.getClass().getName().toString());
			ErrorLogger err = new ErrorLogger(ts, e.getCause().toString() + " Could Not Update Data ",
					e.getMessage().toString());
			errlogger.save(err);
			e.printStackTrace();

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	

	}

	
	
	}


