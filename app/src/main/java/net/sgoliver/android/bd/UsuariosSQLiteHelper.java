package net.sgoliver.android.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
 
public class UsuariosSQLiteHelper extends SQLiteOpenHelper {

    String[] sentenciasSQL = new String [6];





    public UsuariosSQLiteHelper(Context contexto, String nombre,
                               CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        sentenciasSQL [0] = "CREATE TABLE autobuses (matricula TEXT, contraseña TEXT)";
        sentenciasSQL [1] = "CREATE TABLE rutas (matricula TEXT, latitud NUMBER, longitud NUMBER, data TEXT)";
        sentenciasSQL [2] = "CREATE TABLE jornada (matricula TEXT, hora_inici TEXT, hora_fi TEXT)";
        sentenciasSQL [3] = "INSERT INTO autobuses VALUES ('1111A', '1234')";
        sentenciasSQL [4] = "INSERT INTO autobuses VALUES ('2222B', '4321')";
        sentenciasSQL [5] = "INSERT INTO autobuses VALUES ('3333C', '1423')";




        //Se ejecuta la sentencia SQL de creaci�n de la tabla
        for (int i = 0; i < sentenciasSQL.length; i++) {
            db.execSQL(sentenciasSQL[i]);
        }
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, 
                          int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aqu� utilizamos directamente 
        //      la opci�n de eliminar la tabla anterior y crearla de nuevo 
        //      vac�a con el nuevo formato.
        //      Sin embargo lo normal ser� que haya que migrar datos de la 
        //      tabla antigua a la nueva, por lo que este m�todo deber�a 
        //      ser m�s elaborado.
 
        //Se elimina la versi�n anterior de la tabla
        //db.execSQL("DROP TABLE IF EXISTS Usuarios");
 
        //Se crea la nueva versi�n de la tabla
        //db.execSQL(sqlCreate);
    }

    /**
     * Metode per a realitzar la cerca del usuari en la taula autobusos i comprovar que les dades són
     * correctes.
     * @param usuari
     * @param contrasenya
     * @return
     */
    
    public boolean cercaUsuari(String usuari, String contrasenya){
        boolean correcte = false;



        return correcte;
    }
}

