package net.sgoliver.android.bd;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        //Creamos los campos y el boton.

		//Inicializamos el boton
		Button buttonEnviar = (Button) findViewById(R.id.buttonentrar);
		//Le aplicamos un clickListener
		buttonEnviar.setOnClickListener(this);
		
		//Abrimos la base de datos 'DBUsuarios' en modo escritura
        UsuariosSQLiteHelper usdbh =
            new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
 
        SQLiteDatabase db = usdbh.getWritableDatabase();
 
        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
            //Cerramos la base de datos
            db.close();
        }

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



        }
    }

}
