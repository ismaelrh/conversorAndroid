package com.ismaro3.conversor;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuPrincipal extends ListActivity {

	public static final String MODO = "MODO";

	ListView listView;
    List<RowItem> rowItems;
    
    public static String[] titles;
    public static String[] desc;
    public static Integer[] images = { R.drawable.icono,
		R.drawable.icono,R.drawable.icono,R.drawable.icono,R.drawable.icono,
		R.drawable.icono,R.drawable.icono,R.drawable.icono,R.drawable.icono,
		R.drawable.icono,R.drawable.icono};;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
		setContentView(R.layout.activity_menu_principal);
		this.setTitle("Conversor de Unidades");
		/*Poblamos el ListView con los elementos del menu*/
		
		 titles = getResources()
                .getStringArray(R.array.titulosMenu);
		 desc = getResources().getStringArray(R.array.descripcionMenu);
		 
		 /*Establece la lista de objetos para rellenar*/
	        rowItems = new ArrayList<RowItem>();
	        for (int i = 0; i < titles.length; i++) {
	            RowItem item = new RowItem(images[i], titles[i], desc[i]);
	            rowItems.add(item);
	        }
	        
		 
	        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
	                R.layout.fila_imagen, rowItems);
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
		/*No esperamos información de retorno*/
		
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		/*Primer elemento del menú, lanzo la actividad de 
		 * menú de opciones
		 */
		
			Intent i = new Intent(this,MenuAjustes.class);
			startActivity(i);
		
		return super.onOptionsItemSelected(item);
	}
	
	

	
}
