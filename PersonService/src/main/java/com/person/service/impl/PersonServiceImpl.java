package com.person.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.person.dto.Person;
import com.person.repository.PersonRepository;
import com.person.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Resource
	private PersonRepository personRepository;

	private static final AtomicLong counter = new AtomicLong();

	private static List<Person> users;
	static {
		users = populateDummayData();
	}

	@Override
	public Person findById(long id) {

		for (Person p : users) {
			if (p.getId() == id) {
				return p;
			}
		}

		return null;
	}

	private static List<Person> populateDummayData() {

		List<Person> users = new ArrayList<Person>();
		users.add(new Person(counter.incrementAndGet(), "Sam", 30, 70000));
		users.add(new Person(counter.incrementAndGet(), "Tom", 40, 50000));
		users.add(new Person(counter.incrementAndGet(), "Jerome", 45, 30000));
		users.add(new Person(counter.incrementAndGet(), "Silvia", 50, 40000));
		return users;
	}

	@Override
	public Person findByName(String name) {
		for (Person p : users) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void saveUser(Person person) {
		person.setId(counter.incrementAndGet());
		users.add(person);

	}

	@Override
	public void updateUser(Person person) {
		int index = users.indexOf(person);
		users.set(index, person);

	}

	@Override
	public void deleteUserById(long id) {
		for (Iterator<Person> iterator = users.iterator(); iterator.hasNext();) {
			Person user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}

	}

	@Override
	public List<Person> findAllUsers() {
		return users;
	}

	@Override
	public void deleteAllUsers() {
		users.clear();

	}

	@Override
	public boolean isUserExist(Person person) {
		return findByName(person.getName()) != null;
	}

	// The below will fetch 5 employees based on the page
	@Override
	public List<Person> findPersons(String pageNo) {
		List<Person> persons = new ArrayList<>();
		Pageable pageable = PageRequest.of(Integer.valueOf(pageNo), 5);
		Page<Person> page = personRepository.findAll(pageable);
		if (page.getTotalElements() > 0) {
			page.stream().forEach(p -> persons.add(p));
		}
		// If the page has persons then it returns the same else it returns empty list.
		return persons;
	}

	// Saving all the Person entities into the DB which came from POSTMAN.
	@Override
	public List<Person> saveAllPersons(List<Person> persons) {
		//Doing the Optional Check to avoid NullPointerException
		Optional<List<Person>> opt = Optional.ofNullable(persons);
		List<Person> personsList = new ArrayList<>();
		if (opt.isPresent()) {
			personRepository.saveAll(persons).forEach(p -> personsList.add(p));
		}
		return personsList;
	}

}
