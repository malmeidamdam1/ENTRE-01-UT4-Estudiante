/**
 * Un objeto de esta clase guarda informaci�n de una unidad
 * de trabajo
 * Toda UT adem�s del nombre,  fecha de finalizaci�n,
 * y peso en la evaluaci�n tiene asociado un objeto ponderaci�n
 * que incluye las ponderaciones usadas para cada instrumento de evaluaci�n
 */
public class UnidadTrabajo {
    private String nombre;
    private Fecha fechaFin; //atributo con TD la Clase Fecha
    private int pesoUnidad;
    private PonderacionInstrumentos ponderacion; //atributo con TD la Clase Ponderacion..

    /**
     * Constructor 1
     */
    public UnidadTrabajo(String nombre, int dia, int mes, int year, int peso,
    int controles, int actividades, int proyectos) {
        this.nombre = nombre;
        this.fechaFin = new Fecha(dia,mes,year); //referencia a un metodo de la clase Fecha
        this.pesoUnidad = peso;
        this.ponderacion = new PonderacionInstrumentos(controles, actividades, proyectos);
        
        //Como nuestro ATB "fechaFin" es TD ("Fecha"-una Clase) sus valores se dan de la siguiente forma:
        
        // ATB = new Constructor("String", int, int,...) 

    }

    /**
     * Constructor 2
     */
    public UnidadTrabajo(String nombre, Fecha fechaFin, int peso,
    PonderacionInstrumentos ponderacion) {
        this.nombre = nombre;
        this.fechaFin = fechaFin; //Aqui al momento de llamar al metodo, te pedira que pases un objeto Fecha que ya tendra definido el (dia, mes y a�o) cuando se creo ese objeto
        this.pesoUnidad = peso;
        this.ponderacion = ponderacion;
    }

    /**
     * Accesor nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Mutador nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Accesor fecha de fin de UT
     */
    public Fecha getFechaFin() {
        return fechaFin;
    }

    /**
     * Mutador fecha de fin de UT
     */
    public void setFechaFin(Fecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Accesor peso de la UT en la evaluaci�n
     */
    public int getPesoUnidad() { //le cambie double por int (revertir)
        return this.pesoUnidad;
    }

    /**
     * Accesor para el peso de la UT
     */
    public void setPesoUnidad(int pesoUnidad) {
        this.pesoUnidad = pesoUnidad;
    }

    /**
     * Accesor ponderaci�n
     */
    public PonderacionInstrumentos getPonderacion() {
        return ponderacion;
    }

    /**
     * Mutador ponderaci�n
     */
    public void setPonderacion(PonderacionInstrumentos ponderacion) {
        this.ponderacion = ponderacion;
    }

    /**
     * Devuelve true si la UT actual ha finalizado antes
     * que la recibida como par�metro
     */
    public boolean anteriorA(UnidadTrabajo unidad) { //Que comparar dos objetos unidad su fecha
        UnidadTrabajo unidadNueva =  // Crear variable con TDato UT, 
        new UnidadTrabajo(unidad.getNombre() , unidad.getFechaFin() , unidad.getPesoUnidad() , //creo objeto UT y 
                                                                                                //le asigno sus valores 
                                                                                                //van a ser (los que tenga el objeto UT creado por usuario)
                unidad.getPonderacion());

        Fecha fechaUTNueva = unidad.getFechaFin(); //hago variable local separando el dato de la fecha del nuevo objeto "unidad" del resto

        return (this.fechaFin.antesQue(fechaUTNueva)); //utilizo el met de la Clasae fecha "antesQue()" llamandolo con el ATB fecha de este objeto UT y lo comparo
                                                        //en forma de PARAM con el objeto unidadNueva, como el met "antesQue()" es booleano lo que salga de ahi
                                                        // me devuelve aqui ya sea T o F. (Es decir la evaluacion se hace en el otro met)// return true;
    }

    /**
     * Devuelve una copia (clon) de la unidad de trabajo actual con el nombre
     * "Copia de " + nombre de la UT actual
     * Se clonan tambi�n los objetos que incluya
     */
    public UnidadTrabajo clonar() {
        UnidadTrabajo copiaUT = new UnidadTrabajo(this.getNombre(), this.getFechaFin(), this.getPesoUnidad(), this.getPonderacion());
             
        return copiaUT; 
    }

    /**
     * Representaci�n textual de la UT
     */
    public String toString() {
        String str = "Unidad de trabajo - " + this.nombre +
            "\n\tFecha finalizaci�n: " + this.getFechaFin().toString() +
            " | Peso UT: " + this.pesoUnidad + "%\n";
        str += this.ponderacion;
        return str;
    }

    /**
     * Este m�todo se ha incluido solo para testear la clase m�s f�cilmente
     */
    public void print() {
        System.out.println(this.toString());

    }

}
