/**
 * 
 */
package com.person.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.person.dto.Person;

/**
 * @author Sunil
 *
 */
public interface PersonRepository extends PagingAndSortingRepository<Person,Long>{
	

}
