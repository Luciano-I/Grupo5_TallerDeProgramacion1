package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import servicios.Factura;
import personas.Fisica;
import personas.Persona;

public class TestFacturaConDatos {

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
		Assert.assertEquals(persona, factura.getPersona());
	}
	
	@Test
	public void testBuscaContratacion() {
		int posicion;
		EscenarioFacturaConDatos EFD=new EscenarioFacturaConDatos();
		posicion=EFD.getFactura().buscaContratacion("Magallanes 1212");
		Assert.assertEquals(1, posicion);
	}

}
