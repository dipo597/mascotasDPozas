package mascota;
import java.time.LocalDate;

public class MascotaCalcularProximaRevision {
	
	@Override
	public LocalDate calcularProximaRevision() {
		
		LocalDate proximaRevision;
		
		int edadAños = getFechaNacimiento().until(LocalDate.now()).getYears();
		
		proximaRevision = getFechaNacimiento().plusYears(edadAños+1);
		
		return proximaRevision;
	}

}
