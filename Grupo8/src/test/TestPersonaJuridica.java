package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import personas.Fisica;
import personas.Juridica;

public class TestPersonaJuridica {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Juridica persona=new Juridica("Molinos SA", 313552359);
		String nombre=persona.getNombre();
		int cuit=persona.getCUIT();
		Assert.assertEquals("Molinos SA", persona.getNombre());
		Assert.assertEquals(31355235, persona.getCUIT());
	}

	@Test
	public void testSetNombre() {
		Juridica persona=new Juridica("Molinos SA", 313552359);
		persona.setNombre("La Merced");
		Assert.assertEquals("La Merced", persona.getNombre());
	}
	
	@Test
	public void testSetCUIT() {
		Juridica persona=new Juridica("Molinos SA", 313552359);
		int cuit=334553352;
		persona.setCUIT(cuit);
		Assert.assertEquals(cuit, persona.getCUIT());
	}
}
