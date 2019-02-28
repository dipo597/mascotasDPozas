package mascota;

import java.time.LocalDate;

/**
 * @author Lucas González DW1E
 * <p>
 * Clase mamífero que extiende mascota.
 */
public class Mamifero extends Mascota{
	
	private String chip;
	
	public Mamifero(String nombre, String especie, LocalDate fechaNacimiento, String chip) {
		
		super(nombre, especie, fechaNacimiento);
		setChip(chip);
	}
	
	@Override
	public String toString() {
		
		return "Mamífero: \n"+super.toString()+"\nChip: "+getChip();
	}
	
	@Override
	public LocalDate calcularProximaRevision() {

		LocalDate proximaRevision;
		
		int edadAños = getFechaNacimiento().until(LocalDate.now()).getYears(); boolean continuar = true; int i = 0; int b = 0;
		
		if (edadAños <= 2) {
			
			i=3;
			b=3;
		} else {
			i=6;
			b=6;
		}
		
		do {
			
			if (getFechaNacimiento().plusMonths(i).isBefore(LocalDate.now())) {
			
				i+=b;
			} else {
				continuar = false;
			}
			
		}while(continuar);

		proximaRevision = getFechaNacimiento().plusMonths(i);
		
		return proximaRevision;
	}

	public String getChip() {
		return chip;
	}

	private void setChip(String chip) {
		
		if (getChip() != null) {
				
			throw new IllegalArgumentException("No puedes alterar el chip de un mamífero.");
		} else if (!chip.matches("\\d{15}$")) {
			
			throw new IllegalArgumentException("Chip inválido. Debe tener 15 digitos.");
		}
		
		this.chip = chip;
	}

}
