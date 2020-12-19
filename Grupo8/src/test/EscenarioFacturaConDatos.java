package test;

import agregado.Celular;
import personas.Fisica;
import servicios.DomicilioCasa;
import servicios.Factura;
import servicios.Internet100;

public class EscenarioFacturaConDatos {
	private Factura factura;
	
	{
		factura=new Factura(new Fisica("Jorge",14125235));
		Internet100 internet100=new Internet100(new DomicilioCasa("aaagasga",1212));
		factura.nuevaContratacion(internet100);
		factura.nuevaContratacion(new Celular(3, internet100));
	}

}
