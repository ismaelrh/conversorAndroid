package com.ismaro3.conversor;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuPrincipal extends ListActivity {

	public static final String MODO = "MODO";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
		setContentView(R.layout.activity_menu_principal);
		
		/*Poblamos el ListView con los elementos del menu*/
		String[] menu = getResources()
                .getStringArray(R.array.elementosMenu);
		ArrayAdapter adapter = new ArrayAdapter<String>(this, 
		        R.layout.fila_lista, menu);
		this.setListAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_principal, menu);
		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		/*Lanzamos la otra actividad, pasándole la posición pulsada.
		 * Así, la nueva actividad se encargará de todo lo demás,
		 * según el tipo de conversión a realizar.
		 */
		Intent i = new Intent(this,MenuConversor.class);
		i.putExtra(MODO, position);
		startActivity(i);
		
		
	}

	
}
