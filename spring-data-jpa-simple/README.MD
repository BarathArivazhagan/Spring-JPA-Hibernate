
#Simple project to demostrate Spring Data JPA #


## User Entity ##
```
       @Entity
	@Table(name="USER")
	protected static class User implements Serializable{	

		
		private static final long serialVersionUID = -3740149288617227418L;
		
		@Id
		@Column(name="USER_ID")
		private int userId;
		
		
		@Column(name="USER_NAME")
		private String userName;
    
    //getters and setters
}

```


## User Repository: JpaRepository##

```

interface UserRepository extends JpaRepository<User, Integer>{}

```


## User service ## : to perform CRUD operations in User Entity 


```
  	@Service
	class UserSerivce{
		
			
		
		@Autowired
		UserRepository userRep;
		
		
		public void addUser(User user){
						userRep.save(user);
		}
		
		public User getUser(int userId){
					User user=userRep.findOne(userId);
			return user;
		}
		
		
	}
```
