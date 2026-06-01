package modelo;

import java.util.ArrayList;

// ✅ MEJORA: ahora gestiona Prestamos (no Usuarios + Libros por separado).
//    Se eliminó la lista de Libros que era redundante y nunca se usaba.
public class SistemaPrestamo {

    private ArrayList<Prestamo> prestamos;

    public SistemaPrestamo() {
        prestamos = new ArrayList<>();
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    // ✅ MEJORA: busca el préstamo ACTIVO de un usuario por su NUIP.
    //    Antes, devolver() tomaba siempre el ÚLTIMO usuario sin importar quién era.
    public Prestamo buscarPrestamoActivo(String nuip) {
        for (Prestamo p : prestamos) {
            if (p.getUsuario().getNuip().equals(nuip)
                    && p.getEstado() == EstadoPrestamo.PRESTADO) {
                return p;
            }
        }
        return null; // no encontrado
    }

    // ✅ MEJORA: estadísticas para el área de resultados
    public long contarPorEstado(EstadoPrestamo estado) {
        long count = 0;
        for (Prestamo p : prestamos) {
            if (p.getEstado() == estado) count++;
        }
        return count;
    }
}
