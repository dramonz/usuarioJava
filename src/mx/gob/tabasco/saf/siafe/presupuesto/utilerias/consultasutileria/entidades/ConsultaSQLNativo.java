package mx.gob.tabasco.saf.siafe.presupuesto.utilerias.consultasutileria.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConsultaSQLNativo {
	
	/**
	 * Cadena de texto del SQL Nativo de la base de datoa que se esta utilizando
	 */
	private String sqlNativo = "";
	
	/**
	 * Cadena de texto que contiene los nombre de los campos separados por "," en el mismo orden de las columnas recibidas en el resultado
	 * Puedes definir menos columnas de las recibidas en el resultado pero no mas.
	 */
	private String columnas;
	
	/**
	 * Si esta utilizando la paginacion, el resultado maximo por pagina.
	 */
	private int resultadoMaximo = 100;
	
	/**
	 * Si se esta utilizando paginacion, apartir de que elementos se cargaran los resultados.
	 */
	private int primerResultado = 0;
	
	
	private List<Object> result;
	
	
	

	public String getSqlNativo() {
		return sqlNativo;
	}

	public ConsultaSQLNativo setSqlNativo(String sqlNativo) {
		this.sqlNativo = sqlNativo;
		return this;
	}

	public String getColumnas() {
		return columnas;
	}

	public ConsultaSQLNativo setColumnas(String columnas) {
		this.columnas = columnas;
		return this;
	}

	public int getResultadoMaximo() {
		return resultadoMaximo;
	}

	public ConsultaSQLNativo setResultadoMaximo(int resultadoMaximo) {
		this.resultadoMaximo = resultadoMaximo;
		return this;
	}

	public int getPrimerResultado() {
		return primerResultado;
	}

	public ConsultaSQLNativo setPrimerResultado(int primerResultado) {
		this.primerResultado = primerResultado;
		return this;
	}
	

	public List<Object> getResult() {
		return this.result;
	}

	public void setResult(List<Object> result) {
		this.result = result;
	}
	
	
	
	/**
	 * Convierte el Listado en HashMap utilizando el result y las columnas definidas.
	 * @return
	 */
	public List<HashMap<String, Object>> getHasMapResult(){
		
		String[] columns = this.columnas.split(",");
		List<Object> result = this.getResult();
		
		List<HashMap<String, Object>> resultHashMap = new ArrayList<HashMap<String, Object>>();
		
		int columns_result = result.size();
		
		for (int i = 0; i < columns_result; i++){
			resultHashMap.add(this.hashMapElement((Object[]) result.get(i), columns));
		}
		
		return resultHashMap;
		
	}
	
	/**
	 * Combierte un arreglo de objetos e un HashMap utilizando los nombre de las columnas pasados. 
	 * @param valores
	 * @param columns
	 * @return HashMap
	 */
	private HashMap<String, Object> hashMapElement(Object[] valores, String[] columns){
		
		int count_valores = valores.length;
		int count_columns = columns.length;
		
		HashMap<String, Object> fila = new HashMap<String, Object>();
		
		
		if ((count_valores) == count_columns){
			for (int i = 0; i < count_columns; i++){
				fila.put(columns[i].trim(), valores[i]);
			}
		}
		else {
			if ( count_columns <  count_valores){
				for (int i = 0; i < count_columns; i++){
					fila.put(columns[i].trim(), valores[i]);
				}
			}else {
				
			}
		}
		
		return fila;
	}
	
	
	
}
