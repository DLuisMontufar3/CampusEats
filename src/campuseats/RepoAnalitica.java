package campuseats;

import java.time.LocalDate;
import java.util.List;

/** Patrón REPOSITORY: oculta dónde y cómo se guardan los datos limpios. */   h
public interface RepoAnalitica {
    void guardar(List<LineaPedido> lineas);
    List<LineaPedido> buscar(LocalDate desde, LocalDate hasta);
    int total();
    void limpiar();
}
