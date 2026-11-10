package campuseats;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Implementación en memoria del repositorio. */
public class RepoAnaliticaMemoria implements RepoAnalitica {
    private final List<LineaPedido> datos = new ArrayList<>();

    @Override
    public void guardar(List<LineaPedido> lineas) {
        datos.addAll(lineas);
    }

    @Override
    public List<LineaPedido> buscar(LocalDate desde, LocalDate hasta) {
        return datos.stream()
                .filter(l -> !l.fecha().toLocalDate().isBefore(desde)
                          && !l.fecha().toLocalDate().isAfter(hasta))
                .toList();
    }

    @Override
    public int total() { return datos.size(); }

    @Override
    public void limpiar() { datos.clear(); }
}
