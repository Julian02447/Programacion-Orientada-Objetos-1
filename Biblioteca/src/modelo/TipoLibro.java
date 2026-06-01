package modelo;

public enum TipoLibro {

    // ✅ MEJORA: nombre en MAYÚSCULAS_CON_GUIÓN_BAJO según convención Java
    REFERENCIA, COLECCION_GENERAL;

    public static TipoLibro getREFERENCIA()       { return REFERENCIA; }
    public static TipoLibro getCOLECCION_GENERAL() { return COLECCION_GENERAL; }
}
