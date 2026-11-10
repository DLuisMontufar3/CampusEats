package campuseats;

import campuseats.provisional.ResumenBasico;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Patrón FACADE: única puerta de entrada del sistema.
 * El main solo conoce cargar() y resumen(desde, hasta).
 */
public class ServicioAnalitica {
    private final RepoAnalitica repo;
    private final List<Metrica> metricas = new ArrayList<>();

    public ServicioAnalitica() {
        this.repo = new RepoAnaliticaMemoria();
        // TODO (integrante 3): reemplazar por PlatosTop, PedidosPorHora y la tercera métrica
        metricas.add(new ResumenBasico());
    }

    /** Lee fuentes, limpia y guarda en el repositorio. */
    public void cargar() {
        repo.limpiar();
        List<LineaPedido> limpias = obtenerLineasLimpias();
        repo.guardar(limpias);
        System.out.println("Líneas cargadas en el repositorio: " + repo.total());
    }

    /** Consulta el repositorio por rango de fechas y ejecuta las métricas. */
    public void resumen(LocalDate desde, LocalDate hasta) {
        List<LineaPedido> lineas = repo.buscar(desde, hasta);
        System.out.println("=== Resumen " + desde + " a " + hasta + " ===");
        for (Metrica m : metricas) {
            System.out.println("--- " + m.nombre() + " ---");
            System.out.println(m.calcular(lineas));
        }
    }

    private List<LineaPedido> obtenerLineasLimpias() {
        // TODO (integración): 
        //   1. FabricaFuentes (integrante 1) -> lee config/fuentes.json y crea los adaptadores
        //   2. Pipeline (integrante 2)       -> aplica los filtros de limpieza
        //   3. devolver las líneas finales
        // TEMPORAL: datos de prueba para poder ejecutar mi parte.
        return campuseats.provisional.DatosPrueba.lineas();
    }
}
