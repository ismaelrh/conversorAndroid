package com.ismaro3.conversor;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.MenuItem;

public class MenuAjustes extends SherlockListActivity{

	public static final String[] titles = new String[] { 
		"Decimales","Información"
	};

	public static final String[] descriptions = new String[] {
        "Número de decimales a mostrar",
        "Más acerca de este autor",
	};

	public static final Integer[] images = { R.drawable.icono,
		R.drawable.icono};

	 	ListView listView;
	    List<RowItem> rowItems;
	 

	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.ajustes);
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	        this.setTitle("Opciones");
	        /*Establece la lista de objetos para rellenar*/
	        rowItems = new ArrayList<RowItem>();
	        for (int i = 0; i < titles.length; i++) {
	            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
	            rowItems.add(item);
	        }
	 
	   
	        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
	                R.layout.fila_imagen, rowItems);
	        this.setListAdapter(adapter);
	        
	    }
	    
		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			// TODO Auto-generated method stub
			super.onListItemClick(l, v, position, id);
			
			switch (position)
			{
			/*Opción de número de decimales*/
			case 0:
				new AlertDialog.Builder(this)
				.setTitle("Número de decimales")
		        .setSingleChoiceItems(R.array.decimales, Aux.decimales-1, null)
		        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int whichButton) {
		                dialog.dismiss();
		                int selectedPosition = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
		               Aux.decimales = selectedPosition+1;
		            }
		        })
		        .show();
			}
	
	    }
	    

		
		
		

		/*Maneja el botón UP*/
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			switch(item.getItemId()){
			case android.R.id.home:
				finish();
				return true;
			
			}	
			
			return super.onOptionsItemSelected(item);
		}
}
