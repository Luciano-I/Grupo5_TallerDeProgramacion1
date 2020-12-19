package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import personas.Fisica;
import personas.Persona;

public class TestPersonaFisica {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Fisica persona=new Fisica("Jorge", 31355235);
		String nombre=persona.getNombre();
		int dni=persona.getDNI();
		Assert.assertEquals("Jorge", persona.getNombre());
		Assert.assertEquals(31355235, persona.getDNI());
	}

	@Test
	public void TestSetDNI() {
		Fisica persona=new Fisica("Jorge", 31355235);
		persona.setDNI(32455236);
		int dni=persona.getDNI();
		Assert.assertEquals(32455236, dni);
	}
	
}
