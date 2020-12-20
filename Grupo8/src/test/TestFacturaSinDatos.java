package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mediospagos.PagoEfectivo;
import personas.Fisica;
import servicios.DomicilioCasa;
import servicios.Factura;
import servicios.Internet100;
import servicios.Internet500;

public class TestFacturaSinDatos {

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
		EscenarioFacturaSinDatos EFD=new EscenarioFacturaSinDatos();
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

	/*@Test
	public void testEliminaContratacion() {
		EscenarioFacturaSinDatos EFD=new EscenarioFacturaSinDatos();
		Internet100 i100=(Internet100) EFD.getFactura().getListaContrataciones().get(1);
		EFD.getFactura().eliminaContratacion(0);
		Assert.assertEquals(i100, EFD.getFactura().getListaContrataciones().get(0));
	}*/
	
	@Test
	public void testModificaContratacionCorrecto() {
		EscenarioFacturaSinDatos EFD=new EscenarioFacturaSinDatos();
		EFD.getFactura().modificaContratacion(1, "CAMBIAR", "INTERNET500");
		Assert.assertEquals(Internet500.class, EFD.getFactura().getListaContrataciones().get(1).getClass());
	}
	
	@Test
	public void testModificaContratacionAccionVacia() {
		EscenarioFacturaSinDatos EFD=new EscenarioFacturaSinDatos();
		EFD.getFactura().modificaContratacion(1, "", "INTERNET500");
		Assert.assertEquals(Internet500.class, EFD.getFactura().getListaContrataciones().get(1).getClass());
	}
	
	@Test
	public void testModificaContratacionAccionNULL() {
		EscenarioFacturaSinDatos EFD=new EscenarioFacturaSinDatos();
		EFD.getFactura().modificaContratacion(1, null, "INTERNET500");
		Assert.assertEquals(Internet500.class, EFD.getFactura().getListaContrataciones().get(1).getClass());
	}
	
	@Test
	public void testModificaContratacionServicioVacia() {
		EscenarioFacturaSinDatos EFD=new EscenarioFacturaSinDatos();
		EFD.getFactura().modificaContratacion(1, "CAMBIAR", "");
		Assert.assertEquals(Internet500.class, EFD.getFactura().getListaContrataciones().get(1).getClass());
	}
	
	@Test
	public void testModificaContratacionServicioNULL() {
		EscenarioFacturaSinDatos EFD=new EscenarioFacturaSinDatos();
		EFD.getFactura().modificaContratacion(1, "CAMBIAR", null);
		Assert.assertEquals(Internet500.class, EFD.getFactura().getListaContrataciones().get(1).getClass());
	}
	
	@Test
	public void testPrecioFinalValido() {
		EscenarioFacturaSinDatos EFD=new EscenarioFacturaSinDatos();
		PagoEfectivo efect=new PagoEfectivo();
		EFD.getFactura().precioFinal(EFD.getFactura().getPersona(), efect);
		Boolean precioEx=true;
		Boolean precioAct=EFD.getFactura().getTotalSinP()==0;
		Assert.assertEquals(precioEx, precioAct);
	}
	
	@Test
	public void testPrecioFinalPersonaNULL() {
		Factura factura=new Factura(new Fisica("Jorge",14125235));
		Internet500 internet500=new Internet500(new DomicilioCasa("assdfaf",1245));
		Internet100 internet100=new Internet100(new DomicilioCasa("hola",1212));
		
		factura.nuevaContratacion(internet500);
		factura.nuevaContratacion(internet100);
		PagoEfectivo efect=new PagoEfectivo();
		factura.precioFinal(null, efect);
		Boolean precioEx=true;
		Boolean precioAct=factura.getTotalSinP()==0;
		Assert.assertEquals(precioEx, precioAct);
	}
	
	@Test
	public void testPrecioFinalPersonaNULLTipoNULL() {
		Factura factura=new Factura(new Fisica("Jorge",14125235));
		Internet500 internet500=new Internet500(new DomicilioCasa("assdfaf",1245));
		Internet100 internet100=new Internet100(new DomicilioCasa("hola",1212));
		
		factura.nuevaContratacion(internet500);
		factura.nuevaContratacion(internet100);
		
		factura.precioFinal(null, null);
		Boolean precioEx=true;
		Boolean precioAct=factura.getTotalSinP()==0;
		Assert.assertEquals(precioEx, precioAct);
	}
	
	@Test
	public void testPrecioFinalTipoNULL() {
		Factura factura=new Factura(new Fisica("Jorge",14125235));
		Internet500 internet500=new Internet500(new DomicilioCasa("assdfaf",1245));
		Internet100 internet100=new Internet100(new DomicilioCasa("hola",1212));
		
		factura.nuevaContratacion(internet500);
		factura.nuevaContratacion(internet100);
		PagoEfectivo efect=new PagoEfectivo();
		factura.precioFinal(factura.getPersona(), null);
		Boolean precioEx=true;
		Boolean precioAct=factura.getTotalSinP()==0;
		Assert.assertEquals(precioEx, precioAct);
	}
}
