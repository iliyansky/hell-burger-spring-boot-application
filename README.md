# hell-burger-spring-boot-application

I've created a new Maven project with Spring Initializr. First made the configuration, added needed dependencies and connected it with the database.
I've created those packages and filled them: 
   - controllers
   - entities
   - repositories
   - services

The main conception of the project is to create a burger with 5 simple steps:

    1. Choose bread
    2. Choose meat
    3. Choose ingredients
    4. Choose sauce
    5. Give a name 
    
In the future when my friend is done with the frontend, everything will happen with 1 click each.

The entities:

    - Bread
    - Meat
    - Ingredients
    - Sauce
    - Burger
    
Each entity contains:

    - ID
    - name
    - price
    - Set<Burger> with @ManyToMany relation with @JoinTable // except Burger entity
    - Empty constructor
    - Filled constructor
    - Getters and Setters
    
Burger entity contains few more properties:

    - Set<Bread>
    - Set<Meat>
    - Set<Ingredient>
    - Set<Sauce>
    
    and there are @ManyToMany relations with @JoinTable
    
Every repository implements Jpa Repository

// Example:

    @Repository
    public interface BurgerRepository extends JpaRepository<Burger,Long> {
    }

Services:

Every service template except BurgerService example:

    @Service
    public class BreadService {

        @Autowired
        private BreadRepository breadRepository;
    
        public List<Bread> getBreads (){
            return breadRepository.findAll();
        }
    
        public void addBread(Bread bread){
            breadRepository.save(bread);
        }
    
        @Transactional
        public void delete(Long id){
            breadRepository.deleteById(id);
        }
    
        public void edit(Long id, Bread bread){
            breadRepository.getOne(id).setName(bread.getName());
            breadRepository.getOne(id).setPrice(bread.getPrice());
            breadRepository.flush();
        }
    }
    
BurgerService:

            private double calculateThePrice(Burger burger) {
                double price = 0;
                price += burger.getBreads().stream().mapToDouble(Bread::getPrice).sum();
                price += burger.getMeats().stream().mapToDouble(Meat::getPrice).sum();
                price += burger.getIngredients().stream().mapToDouble(Ingredient::getPrice).sum();
                price += burger.getSauces().stream().mapToDouble(Sauce::getPrice).sum();
                return price;
            }
        
            public Burger review(Burger burger){
                burger.setPrice(calculateThePrice(burger));
                return burger;
            }
            public Burger createBurger(Burger burger) {
                burger.setPrice(calculateThePrice(burger));
                return burgerRepository.save(burger);
            }
        
            public List<Burger> displayBurger(){
                return burgerRepository.findAll();
            }
        
            public void deleteBurger(long id){
                burgerRepository.deleteById(id);
            }
    
InsideController:

Implementation of the Services with an added endpoint for every method.

// Example:
        
        @RequestMapping(value = "/add/bread")
        public void addBread(@RequestBody Bread bread){
            breadService.addBread(bread);
        }
        
        @GetMapping(value = "/get/breads")
        public List<Bread> getBreads(){
           return breadService.getBreads();
        }
        
        @RequestMapping(value = "/edit/bread/{id}")
        public void editBreadById(@PathVariable("id") Long id, @RequestBody Bread bread){
            breadService.edit(id,bread);
        }
        
        @RequestMapping(value = "/delete/bread/{id}")
        public void deleteBreadById(@PathVariable("id") Long id){
            breadService.delete(id);
        }
        
HomeController:

I'm using it for burger creation. I named it "HomeController" because the starting point is on the main page when the frontend is added;

There are 3 methods with endpoints inside which are BurgerService's methods

        @RequestMapping("/display")
        public List<Burger> displayBurger(){
            return burgerService.displayBurger();
        }
    
        @RequestMapping(value = "/review")
        public Burger theStateBeforeCreating(@RequestBody Burger burger){
            return this.burgerService.review(burger);
        }
    
        @RequestMapping("/create")
        public Burger createBurger(@RequestBody Burger burger){
            return this.burgerService.createBurger(burger);
        }

To see how the application works you must have: XAMPP, etc. and Postman, etc.

How to use it:
        
        1. Run XAMPP and start MySql
        2. Open Postman and set on body tap
            - raw
            - JSON dialect
        3. Run the application and make sure Tomcat is running on port: 8080
        4. Put a few pieces of bread,meats, ingredients, and sauces in the database ( you can follow the instruction written with comments on each method
        5. To create the burger you need to build JSON object "Burger" with its constructor, so you can put whatever ingredients you want.
        6. Hit the /create endpoint and it will return your made burger with calculated price.
        
        And your burger is already in the base, so if you want to get it you can hit /get/burger/name endpoint and it will display it. 
    
        
_ Created by Iliyan Boyanov


    
