package br.ce.aparecido;

public class User {
	
	private Long id;
	private String name;
	private String job;
	
	public User(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
