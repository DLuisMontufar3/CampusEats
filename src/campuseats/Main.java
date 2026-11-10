package campuseats;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ServicioAnalitica servicio = new ServicioAnalitica();
        servicio.cargar();
        servicio.resumen(LocalDate.of(2000, 1, 1), LocalDate.of(2100, 12, 31));
    }
}
