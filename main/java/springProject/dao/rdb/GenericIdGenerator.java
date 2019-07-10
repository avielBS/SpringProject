package springProject.dao.rdb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GenericIdGenerator {
	private Long id;

	public GenericIdGenerator() {
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
