/**
 * 
 */
package com.java8.lambda;

/**
 * @author maheshrajannan
 *
 */
public class CheckPersonByGenderAndAge implements CheckPerson {
	/* (non-Javadoc)
	 * @see com.java8.lambda.CheckPerson#test(com.java8.lambda.Person)
	 */
	public boolean test(Person p) {
		return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
	}
}
