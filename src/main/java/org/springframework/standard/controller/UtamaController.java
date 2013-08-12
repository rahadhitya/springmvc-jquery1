package org.springframework.standard.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.standard.model.Department;
import org.springframework.standard.dao.DepartmentDao;



/**
 * Handles requests for the application home page.
 */
@Controller
public class UtamaController {
	
	//private static final Logger logger = LoggerFactory.getLogger(UtamaController.class);
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "muka1";
		//return "redirect:muka1.php";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dialogmod", method = RequestMethod.GET)
	public String dialogm(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		return "dialogmodal";
		//return "redirect:muka1.php";
	}
	
	
	
	/**
	 * Handles and retrieves all persons and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public String getPersons(Model model) {
    	
    	logger.debug("Received request to show all persons");
    	
    	// Retrieve all persons by delegating the call to PersonService
    	List<Department> departement = departmentDao.getAllDepartment();
    	
    	// Attach persons to the Model
    	model.addAttribute("persons", departement);
    	
    	// This will resolve to /WEB-INF/jsp/personspage.jsp
    	return "login";
	}

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    @ResponseBody
    public String handleDepartment(@RequestParam("tit") String title, 
        @RequestParam("desc") String description, 
            HttpServletRequest request, HttpServletResponse response) {

    String json = null;        

    try {

        //1. Create 'jackson' object mapper
        ObjectMapper objectMapper = new ObjectMapper();  

        Department departement = new Department();
        departement.setTitle(title);
        departement.setDescription(description);

        Department dept = departmentDao.getSingleDepartment(departement);

        //2. Convert your 'bean' or 'dto' as 'json' string
        json = objectMapper.writeValueAsString(dept);            

    } catch (Exception ex) {
        //LOGGER.error(ex);
    	System.out.println(ex);
    }
    return json;
}
    
    /**
	 * Handles and retrieves all persons and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getCret(Model model) {
    	String currentTime = new java.util.Date().toString();
    	// Retrieve all persons by delegating the call to PersonService
    	List<Department> crets = departmentDao.getAllDepartment();
    	
    	// Attach persons to the Model
    	model.addAttribute("crets", crets);
    	model.addAttribute("dobol", currentTime);
    	return "hello";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdds(Model model) {
    	logger.debug("Received request to show add page");
    
    	// Create new Person and add to model
    	// This is the formBackingOBject
    	model.addAttribute("personAttribute", new Department());

    	// This will resolve to /WEB-INF/jsp/addpage.jsp
    	return "login";
	}
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String adds(@ModelAttribute("personAttribute") Department person) {
		logger.debug("Received request to add new person");
		
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "personAttribute" because the JSP uses that name
		
		// Call PersonService to do the actual adding
		departmentDao.saveDepartment(person);
		

    	// This will resolve to /WEB-INF/jsp/addedpage.jsp
		return "login";
	}
    
    /**
     * Retrieves the add page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/persons/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	logger.debug("Received request to show add page");
    
    	// Create new Person and add to model
    	// This is the formBackingOBject
    	model.addAttribute("personAttribute", new Department());

    	// This will resolve to /WEB-INF/jsp/addpage.jsp
    	return "addpage";
	}
 
    /**
     * Adds a new person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("personAttribute") Department person) {
		logger.debug("Received request to add new person");
		
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "personAttribute" because the JSP uses that name
		
		// Call PersonService to do the actual adding
		departmentDao.saveDepartment(person);
		

    	// This will resolve to /WEB-INF/jsp/addedpage.jsp
		return "login";
	}
    
    /**
     * Deletes an existing person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/persons/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, 
    										Model model) {
   
		logger.debug("Received request to delete existing person");
		
		// Call PersonService to do the actual deleting
		departmentDao.deleteDepartment(id);
		
		// Add id reference to Model
		model.addAttribute("id", id);
    	
    	// This will resolve to /WEB-INF/jsp/deletedpage.jsp
		return "deletedpage";
	}
    
    /**
     * Retrieves the edit page
     * 
     * @return the name of the JSP page
     */
    /*
    @RequestMapping(value = "/persons1/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	// Retrieve existing Person and add to model
    	// This is the formBackingOBject
    	model.addAttribute("personAttribute", departmentDao.findDepartmentById(id));
    	
    	// This will resolve to /WEB-INF/jsp/editpage.jsp
    	return "editpage";
	}
    */
    @RequestMapping(value="/persons/edit", method=RequestMethod.GET)
	public ModelAndView edit1(@RequestParam("id")Integer id)
	{
		ModelAndView mav = new ModelAndView("editpage");
		Department department = departmentDao.findDepartmentById(id);
		//Contact contact = contactsDAO.getById(id);
		mav.addObject("editpage", department);
		return mav;
	}
    
    /**
     * Edits an existing person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    
    
    @RequestMapping(value="/persons/edit", method=RequestMethod.POST)
	public String saveEdit(@ModelAttribute("editContact") Department person)
	{
    	departmentDao.updateDepartment(person);
		
		return "redirect:/department";
	}
    
    
    /*
    @RequestMapping(value = "/persons/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personAttribute") 
    	Department person, 
    	@RequestParam(value="id", required=true) Integer id, 
    	Model model) {
    	logger.debug("Received request to update person");
    
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "personAttribute" because the JSP uses that name
    	
    	// We manually assign the id because we disabled it in the JSP page
    	// When a field is disabled it will not be included in the ModelAttribute
    	departmentDao.findDepartmentById(id);
    	
    	// Delegate to PersonService for editing
    	departmentDao.updateDepartment(person);
    	
    	// Add id reference to Model
		model.addAttribute("id", id);
		
    	// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "editedpage";
	}
	*/
	
}
