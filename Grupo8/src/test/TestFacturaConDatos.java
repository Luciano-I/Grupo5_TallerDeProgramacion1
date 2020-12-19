package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import servicios.DomicilioCasa;
import servicios.Factura;
import servicios.Internet100;
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
		posicion=EFD.getFactura().buscaContratacion("hola 1212");
		Assert.assertEquals(1, posicion);
	}
	
	@Test
	public void testNuevaContratacion() {
		Factura factura=new Factura(new Fisica("Jorge",14125235));
		Internet100 internet100=new Internet100(new DomicilioCasa("hola",1212));
		factura.nuevaContratacion(internet100);
		Assert.assertEquals(internet100, factura.getListaContrataciones().get(factura.getListaContrataciones().indexOf(internet100)));
	}

	@Test
	public void testEliminaContratacion() {
		EscenarioFacturaConDatos EFD=new EscenarioFacturaConDatos();
		Internet100 i100=(Internet100) EFD.getFactura().getListaContrataciones().get(1);
		EFD.getFactura().eliminaContratacion(0);
		Assert.assertEquals(i100, EFD.getFactura().getListaContrataciones().get(0));
	}
	
	@Test
	public void testModificaContratacion() {
		
	}
}
