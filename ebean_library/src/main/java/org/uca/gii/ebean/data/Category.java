package org.uca.gii.ebean.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id 
	@SequenceGenerator(name="category_id_seq",
    sequenceName="category_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="category_id_seq")
	@Column(name = "id", updatable=false)
	private int id;
	@Column(name="description")
     private String descripcion;
	@Column(name="recommended_age")
     private int minimum_age;
	@ManyToMany(mappedBy="categories")
	private List<Book> books;
     
    public Category() {	
	}
    
    public Category(String description, int age) {
    	this.descripcion = description;
    	this.minimum_age = age;
    }
	/* (non-Javadoc)
	 * @see org.uca.gii.mybatis.data.borra#getDescripcion()
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/* (non-Javadoc)
	 * @see org.uca.gii.mybatis.data.Category#getMinimum_age()
	 */
	/* (non-Javadoc)
	 * @see org.uca.gii.mybatis.data.borra#getMinimum_age()
	 */
	public int getMinimum_age() {
		return minimum_age;
	}
	/**
	 * @param minimum_age the minimum_age to set
	 */
	public void setMinimum_age(int minimum_age) {
		this.minimum_age = minimum_age;
	}
	
/* (non-Javadoc)
 * @see org.uca.gii.mybatis.data.borra#toString()
 */
@Override
public String toString() {
	return this.descripcion +" for >=" +this.minimum_age;
}

/**
 * @return the id
 */
public int getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @return the books
 */
public List<Book> getBooks() {
	return books;
}

/**
 * @param books the books to set
 */
public void setBooks(List<Book> books) {
	this.books = books;
}

}
