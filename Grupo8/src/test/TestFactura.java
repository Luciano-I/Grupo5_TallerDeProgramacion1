package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servicios.Factura;
import personas.Fisica;
import personas.Persona;

public class TestFactura {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Fisica persona=new Fisica("Jorge",31212515);
		Factura factura=new Factura(persona);
	}

}
