package salaDeCine;

import static org.junit.Assert.*;

import org.junit.Test;

public class SalaDeCineTest {

	@SuppressWarnings("unused")
	@Test (expected = IllegalArgumentException.class)
	public void ConstruirSalaConValoresInvalidos() {
		SalaDeCine sala = new SalaDeCine(2, 0);
		SalaDeCine sala2 = new SalaDeCine(1, -2);
	}
	
	@Test
	public void ocuparYdesocupar() {
		SalaDeCine sala = new SalaDeCine(5, 10);
		
		sala.ocupar(2, 2);
		sala.ocupar(3, 1);
		
		assertTrue(sala.isOcupado(2, 2));
		assertTrue(sala.isOcupado(3, 1));
		assertFalse(sala.isOcupado(4, 1));
		
		sala.desocupar(2, 2);
		
		assertFalse(sala.isOcupado(2, 2));
		
		sala.ocupar(2, 2);
		sala.ocupar(3, 3);
		
		assertEquals(sala.cuantasOcupadas(), 3);
		
		assertTrue(sala.hayEspacioPara(5));
		assertTrue(sala.hayEspacioPara(10));
		assertFalse(sala.hayEspacioPara(11));
	}
	
	@Test (expected = Error.class)
	public void ocuparYaOcupado() {
		SalaDeCine sala = new SalaDeCine(5, 10);
		
		sala.ocupar(1, 1);
		sala.ocupar(1, 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void ocuparConValoresInvalidos() {
		SalaDeCine sala = new SalaDeCine(5, 10);
		
		sala.ocupar(-1, 1);
		sala.ocupar(1, -1);
	}
	
	@Test (expected = Error.class)
	public void desocuparYaOcupado() {
		SalaDeCine sala = new SalaDeCine(5, 10);
		
		sala.desocupar(1, 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void desocuparConValoresInvalidos() {
		SalaDeCine sala = new SalaDeCine(5, 10);
		
		sala.desocupar(-1, 1);
		sala.desocupar(1, -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void isOcupadoConValoresInvalidos() {
		SalaDeCine sala = new SalaDeCine(5, 10);
		
		sala.isOcupado(-1, 1);
		sala.isOcupado(1, -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void hayEspacioParaConValoresInvalidos() {
		SalaDeCine sala = new SalaDeCine(5, 10);
		
		sala.hayEspacioPara(-1);
		sala.hayEspacioPara(0);
	}

}
