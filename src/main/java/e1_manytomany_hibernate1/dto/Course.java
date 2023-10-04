package e1_manytomany_hibernate1.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int duration;
	private double fees;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns=@JoinColumn(name = "c_id"),
	inverseJoinColumns = @JoinColumn(name = "s_id"))
	private List<Students> students;
	
//	@Override
//	public String toString() {
//		return "Course [name=" + name + ", duration=" + duration + ", fees=" + fees + ", students=" + students + "]";
//	}
	
	public Course() {
		super();
	}

	public Course(String name, int duration, double fees) {
		super();
		this.name = name;
		this.duration = duration;
		this.fees = fees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}
	
	
}
