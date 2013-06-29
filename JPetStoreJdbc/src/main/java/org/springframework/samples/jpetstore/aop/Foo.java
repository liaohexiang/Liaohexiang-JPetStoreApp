package org.springframework.samples.jpetstore.aop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Foo extends FooParent {

	private static final long serialVersionUID = 1L;
	private int a;
	private int b;
	private boolean c;
	private boolean d;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public boolean isC() {
		return c;
	}
	public void setC(boolean c) {
		this.c = c;
	}
	public boolean isD() {
		return d;
	}
	public void setD(boolean d) {
		this.d = d;
	}
	
	
	public static void main(String[]  args) throws IOException, ClassNotFoundException{
		
		Foo foo = new Foo();
		foo.setA(100);
		foo.setB(200);
		foo.setC(true);
		foo.setD(false);
		foo.setX(300);
		foo.setY(400);
		FileOutputStream fileout = new FileOutputStream(new File("c:\\foo.dat")); 
		ObjectOutputStream out = new ObjectOutputStream(fileout);
		out.writeObject(foo);
		out.close();
		
		FileInputStream filein = new FileInputStream(new File("c:\\foo.dat") );
		ObjectInputStream in = new ObjectInputStream(filein);
		Foo foo1 = (Foo)in.readObject();
		in.close();
		System.out.println(foo1.isC()+" "+foo1.isD());
		
	}
	
}
