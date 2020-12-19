package test;

import personas.Fisica;
import servicios.DomicilioCasa;
import servicios.Factura;
import servicios.Internet100;

public class EscenarioFacturaConDatos {
	private Factura factura;
	
	{
		factura=new Factura(new Fisica("Jorge",14125235));
		factura.nuevaContratacion(new Internet100(new DomicilioCasa("aaagasga",1212)));
	}

}
