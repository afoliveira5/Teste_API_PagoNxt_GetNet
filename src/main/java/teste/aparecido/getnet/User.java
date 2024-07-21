package teste.aparecido.getnet;


public class User {
	
	public String id;
	public String name;
	public String job;
	
	public User(String name, String job) {
		this.name = name;
		this.job = job;
	}
	
//	public User(String name, String job) {
//		super();
//		this.name = name;
//		this.job = job;
//	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", job=" + job + "]";
	}
	
}
