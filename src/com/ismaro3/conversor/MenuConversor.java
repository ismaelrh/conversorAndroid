package com.ismaro3.conversor;

import java.text.DecimalFormat;
import java.util.Locale;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class MenuConversor extends SherlockActivity {

	
	
	/*Atributos de la clase*/
	private TextView mTitulo;
	private EditText mUnidad1;
	private EditText mUnidad2;


	private Spinner mLst1;
	private Spinner mLst2;
	private Button tec0;
	private Button tec1;
	private Button tec2;
	private Button tec3;
	private Button tec4;
	private Button tec5;
	private Button tec6;
	private Button tec7;
	private Button tec8;
	private Button tec9;
	private Button tecPunto;
	private Button tecBorrar;
	private Button tecBorrarTodo;
	private int modo;
	
	
	public static DecimalFormat decimalCientifico;
	public static DecimalFormat decimalNormal;
	
	/*Guardan la opcion seleccionada en el spinner*/
	private int seleccSpinner1= 0;
	private int seleccSpinner2 =0;
	ArrayAdapter<CharSequence> adapter;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conversor); //Fijo el layout de la actividad
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		/*Cojo los extras pasados al llamar a la actividad, que incluyen
		 * el tipo de conversión: 0 (longitud), 1 (area), 2(volumen)
		 */
		Bundle extras = getIntent().getExtras(); 
		modo = extras.getInt(MenuPrincipal.MODO);
		
		/*Iniciamos la notación de los números, según el número de decimales*/
		String almohadillas = new String(new char[Aux.decimales-1]).replace("\0", "#");
		decimalNormal = new DecimalFormat("#." + almohadillas + "#");
		decimalCientifico = new DecimalFormat("0.0" + almohadillas + "E00");

		
		// Inicializa campos para poder manipularlos
	    mTitulo = (TextView) findViewById(R.id.lblConversor);
	    mUnidad1 = (EditText) findViewById(R.id.txtUnidad1);
	    mUnidad2 = (EditText) findViewById(R.id.txtUnidad2);
	    mLst1 = (Spinner) findViewById(R.id.lstUnidad1);
	    mLst2 = (Spinner) findViewById(R.id.lstUnidad2);
	    tec0 = (Button) findViewById(R.id.tec0);
	    tec1 = (Button) findViewById(R.id.tec1);
	    tec2 = (Button) findViewById(R.id.tec2);
	    tec3 = (Button) findViewById(R.id.tec3);
	    tec4 = (Button) findViewById(R.id.tec4);
	    tec5 = (Button) findViewById(R.id.tec5);
	    tec6 = (Button) findViewById(R.id.tec6);
	    tec7 = (Button) findViewById(R.id.tec7);
	    tec8 = (Button) findViewById(R.id.tec8);
	    tec9 = (Button) findViewById(R.id.tec9);
	    tecPunto = (Button) findViewById(R.id.tecPunto);
	    tecBorrar = (Button) findViewById(R.id.tecBorrar);
	    tecBorrarTodo = (Button) findViewById(R.id.tecBorrarTodo);
	    
	    mUnidad1.setKeyListener(null);
	    mUnidad2.setKeyListener(null);
	   
	   
	    
	    
	    /*Prepara la interfaz según el modo de conversión seleccionado*/
	    switch(modo){
	    case 0:
	    	mTitulo.setText(R.string.tLongitud);
	    	Aux.factores = Aux.equivLongitud;
	    	
		     adapter = ArrayAdapter.createFromResource(this,
		         R.array.udsLongitud, android.R.layout.simple_spinner_item);
	    	break;
	    case 1:
	    	mTitulo.setText(R.string.tArea);
	    	Aux.factores = Aux.equivSuperficie;
		     adapter = ArrayAdapter.createFromResource(this,
		         R.array.udsSuperficie, android.R.layout.simple_spinner_item);
	    	break;
	    case 2:
	    	mTitulo.setText(R.string.tVolumen);
	    	Aux.factores = Aux.equivVolumen;
		     adapter = ArrayAdapter.createFromResource(this,
		         R.array.udsVolumen, android.R.layout.simple_spinner_item);
	    	break;
	    case 3:
	    	mTitulo.setText(R.string.tPeso);
	    	Aux.factores = Aux.equivPeso;
		     adapter = ArrayAdapter.createFromResource(this,
		         R.array.udsPeso, android.R.layout.simple_spinner_item);
	    	break;
	    case 4:
	    	mTitulo.setText(R.string.tTiempo);
	    	Aux.factores = Aux.equivTiempo;
		     adapter = ArrayAdapter.createFromResource(this,
		         R.array.udsTiempo, android.R.layout.simple_spinner_item);
	    	break;
	    	
	    }
	    
	   //Especifica el layout que usar cuando se despliegue el menú.
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    
	    // Apply the adapter to the spinner
	    mLst1.setAdapter(adapter);
	    mLst2.setAdapter(adapter);

	    mUnidad1.setText("0");
	    mUnidad2.setText("0");
	    
	  
	
	    tec0.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(0);
    			}
		});
	    tec1.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(1);
    			}
		});
	    tec2.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(2);
    			}
		});
	    tec3.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(3);
    			}
		});
	    tec4.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(4);
    			}
		});
	    tec5.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(5);
    			}
		});
	    tec6.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(6);
    			}
		});
	    tec7.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(7);
    			}
		});
	    tec8.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(8);
    			}
		});
	    tec9.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(9);
    			}
		});
	    tecPunto.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(10);
    			}
		});
	    tecBorrar.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(11);
    			}
		});
	
	    tecBorrarTodo.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View view) {
			
    			gestionarTeclado(12);
    			}
		});
	   
	    mLst1.setOnItemSelectedListener(new OnItemSelectedListener() {
	        @Override
	        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
	            
	        	int seleccionado = mLst1.getSelectedItemPosition(); /*Nueva seleccion*/
	        	
	        	
	        	/*Real ya convertido según la nueva selección de la lista*/
	        	Aux.valor1 = Aux.calcularConversion(Aux.valor1,seleccSpinner1,seleccionado);
	        	/*seleccSpinner1 = elemento seleccionado*/
	        	seleccSpinner1 = seleccionado;	
	        	
	        	
	        	Aux.ponerTexto(Aux.valor1,mUnidad1);
	        	
	        	
	        	
	        }

	        @Override
	        public void onNothingSelected(AdapterView<?> parentView) {
	            // your code here
	        }

	    });
	    mLst2.setOnItemSelectedListener(new OnItemSelectedListener() {
	        @Override
	        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
	            
	        	
	        	int seleccionado = mLst2.getSelectedItemPosition(); /*Nueva seleccion*/
	        	/*Real ya convertido según la nueva selección de la lista*/
	        	Aux.valor2 = Aux.calcularConversion(Aux.valor2,seleccSpinner2,seleccionado);
	        	/*seleccSpinner2= elemento seleccionado*/
	        	seleccSpinner2 = seleccionado;	
	        	
	        	Aux.ponerTexto(Aux.valor2,mUnidad2);

	        }

	        @Override
	        public void onNothingSelected(AdapterView<?> parentView) {
	            // your code here
	        }

	    });
	    
	    
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



	public void gestionarTeclado(int id){
		int focused = 0;
		EditText viewTexto = null;
		if(getCurrentFocus().equals(mUnidad1)){
			focused = 1;
			viewTexto = mUnidad1;
		}
		else if (getCurrentFocus().equals(mUnidad2)){
			focused = 2;
			viewTexto = mUnidad2;
		}
		
		if(focused==1||focused==2){
			
			/*Cojo el texto actual*/
			
			String texto = viewTexto.getText().toString();
			if(id==10){/*Boton de punto*/
				if(puedesPunto(texto)){
					texto+=".";
				}
			}
			else if (id==11){/*Botón de borrar*/
				if(texto.length()==1){
					/*Si solo queda un caracter,
					 * en vez de borrarlo */
					 
					texto = "0";
				}
				else{
					/*Borro el ultimo caracter*/
					int posicionE = Aux.esCientifico(texto);
					if(posicionE<0){
						/*No está en notación científica*/
					texto = texto.substring(0,texto.length()-1);
					}
					else{
						/*Está en notación científica, borro la E*/
						texto = texto.substring(0,posicionE);
					}
					
				}	
			}
			else if(id==12){/*Botón de borrar todo*/
				texto = "0";
				/*El otro cuadro se actualiza automáticamente*/
			}
			else if (id==0){/*Botón de número 0*/
				if(!texto.equals("0")){
					texto+="0";
				}
				
			}
			
			else{/*Botón de número*/
				if(texto.equals("0")){
					/*Si está vacía la caja,
					 * sustituyo el 0 por el número.
					 */
					texto = String.format(Locale.US,"%d",id);
				}
				else{
					/*Añado el número a la derecha*/
					texto+= id;
				}
			}
			/*Establezco el texto*/
			viewTexto.setText(texto);
			
			/*Realizo la conversión al momento*/
			if(focused==1){
				Aux.valor1 = Double.parseDouble(mUnidad1.getText().toString());
				Aux.ponerResultado(mLst1,mLst2,mUnidad2,0);
			}
			else{
				Aux.valor2 = Double.parseDouble(mUnidad2.getText().toString());
				Aux.ponerResultado(mLst2,mLst1,mUnidad1,1);
			}
			
		}
		
		
	}
	
	private boolean puedesPunto(String texto){
		
		boolean ceroPuntos = true;
		int i = 0;
		while( i < texto.length() && ceroPuntos){
			if(texto.charAt(i) == '.'){
				ceroPuntos = false;
			}
			i++;
		}
		return texto.length()>0 && ceroPuntos;
		
		}
	

}
