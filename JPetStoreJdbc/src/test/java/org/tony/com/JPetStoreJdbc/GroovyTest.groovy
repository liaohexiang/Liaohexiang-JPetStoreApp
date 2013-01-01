package org.tony.com.JPetStoreJdbc

class GroovyTest {

	 def name;
	 def create(name){
		 return name;
	 }
	 
	 def update (name){
		 def user = create "liaohexiang";
		 return user;
	 }
	
}
