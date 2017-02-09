package net.sgoliver.android.bd;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private SQLiteDatabase db;
    public String tvCon;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		//Inicializamos el boton
		Button buttonEnviar = (Button) findViewById(R.id.buttonentrar);
		//Le aplicamos un clickListener
		buttonEnviar.setOnClickListener(this);


		
		//Abrimos la base de datos 'DBUsuarios' en modo escritura
        UsuariosSQLiteHelper usdbh =
            new UsuariosSQLiteHelper(this, "DBAutobuses", null, 1);
 
        db = usdbh.getWritableDatabase();
 
        //Si hemos abierto correctamente la base de datos
        //if(db != null)
        //{
            //Cerramos la base de datos
        //    db.close();
        //}



	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}






    /**
     * Boton de enviar y el menu de seleccion de FECHA.
     * @param v
     */
    @Override
    public void onClick(View v){

        if (v.getId() == R.id.buttonentrar) {
            EditText etMatricula = (EditText) findViewById(R.id.etMatricula);
            EditText etContrasenya = (EditText) findViewById(R.id.etContrasenya);

            String matricula;
            String contrasenya;


            matricula = etMatricula.getText().toString();
            contrasenya = etContrasenya.getText().toString();


            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setText(tvCon);

            //Condició per comprobar que l'usuari no deixa cap camp necessari buit.
            if ( (!matricula.equals("")) && (!contrasenya.equals("")) ) {

                if (cercaUsuari(matricula, contrasenya)){
                    //Anem a la següent activity.
                    Intent i = new Intent(this,LogOutActivity.class);
                    startActivity(i);
                    //Finalitzem l'activity actual.
                    finish();

                }else{
                    //Toast per mostrar missatge indicant que alguna de les dades es incorrecte.
                    Toast.makeText(MainActivity.this, "Les dades introduides no són correctes.",
                            Toast.LENGTH_SHORT).show();
                }

            }else{
                //Toast per mostrar missatge indicant que no es poden deixar camps buits.
                Toast.makeText(MainActivity.this, "No es poden deixar camps buits.",
                        Toast.LENGTH_SHORT).show();
            }
        }
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

        String contrasenyaBD = consultaUsuari(usuari);

        if( comprobarContrasenya(contrasenya, contrasenyaBD) ){
            correcte = true;
        }

        return correcte;
    }


    /**
     * Metode que rep la matricula i realitza una cerca en la base de dades interna buscant la contrasenya
     * d'aquesta matricula, agafa la matricula i la retorna.
     * @param matricula
     * @return
     */
    public String consultaUsuari(String matricula){
        String contrasenya = null;


        //Cursor c = db.rawQuery("SELECT contrasenya FROM autobuses WHERE " + "( matricula = '" + matricula + "')", null);
        Cursor c = db.rawQuery("SELECT contrasenya FROM autobuses WHERE " + "( matricula = '" + matricula + "')", null);


        //Recorremos los resultados para mostrarlos en pantalla

        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya m�s registros
            do {
                //contrasenya = c.getString(0);
                tvCon = c.getString(0);
            } while(c.moveToNext());
        }
        //Cursor c = db.rawQuery(" ", null);

        return contrasenya;
    }


    /**
     * Metode que s'encarrega de realitzar la comprobació de la contrasenya introduida.
     * El metode rep 2 cadenes de text:
     *              contrasenya --> contrasenya que ha introduit l'usuari.
     *              contrasenya2 --> contrasenya de l'usuari en la base de dades.
     * Compara les dues cadenes i si son iguals retorna el boolean com true, si no son iguals
     * retorna el boolean com false.
     * @param contrasenya
     * @param contrasenya2
     * @return
     */
    public boolean comprobarContrasenya(String contrasenya, String contrasenya2){
        boolean correcte = false;

        if (contrasenya == contrasenya2){
            correcte = true;
        }

        return correcte;
    }
}
