package mascota;

import java.time.LocalDate;

/**
 * @author Lucas González DW1E
 * <p>
 * Clase ave que extiende mascota.
 */
public class Ave extends Mascota{
	
	private String anilla;
	
	public Ave(String nombre, String especie, LocalDate fechaNacimiento, String anilla) {
		
		super(nombre, especie, fechaNacimiento);
		setAnilla(anilla);
	}
	
	@Override
	public String toString() {
		
		return "Ave: \n"+super.toString()+"\nAnilla: "+getAnilla();
	}

	public String getAnilla() {
		return anilla;
	}
	
	@Override
	public LocalDate calcularProximaRevision() {
		
		LocalDate proximaRevision;
		
		boolean continuar = true; int i = 6;
		
		do {
		
			if (getFechaNacimiento().plusMonths(i).isBefore(LocalDate.now())) {
			
				i+=6;
			} else {
				continuar = false;
			}
			
		}while(continuar);

		proximaRevision = getFechaNacimiento().plusMonths(i);
		
		return proximaRevision;
	}

	public void setAnilla(String anilla) {
		
		if (getAnilla() != null) {
			
			throw new IllegalArgumentException("No puedes alterar la anilla de un ave.");
		} else if (!anilla.matches("[a-zA-Z]{3}-\\d{3}")) {
			
			throw new IllegalArgumentException("Anilla inválido. Debe tener la forma (AAA-999).");
		}

		this.anilla = anilla;
	}

}
