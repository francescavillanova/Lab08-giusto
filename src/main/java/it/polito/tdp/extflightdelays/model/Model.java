package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph<Airport, DefaultWeightedEdge> grafo;
	
	
    public void creaGrafo(int distanza) {
    	
    	this.grafo=new SimpleWeightedGraph<Airport, DefaultWeightedEdge>(DefaultWeightedEdge.class);
    	
    	ExtFlightDelaysDAO dao=new ExtFlightDelaysDAO();
    	List<Tratta> listaTratta=dao.mediaDistanza(distanza);
    	List<Airport> listaAeroporti=dao.loadAllAirports();
    	
    	Map<Integer, Airport> mappaAeroporti=new HashMap<Integer, Airport>();
		for(Airport a: listaAeroporti) {
			mappaAeroporti.put(a.getId(), a);
		}
		
		Graphs.addAllVertices(this.grafo, listaAeroporti);
		
		for(Tratta t: listaTratta) {
			Airport partenza=mappaAeroporti.get(t.getOriginAirportId());
			Airport destinazione=mappaAeroporti.get(t.getDestinationAirportId());
			
			if(!this.grafo.containsEdge(partenza, destinazione)) {
				DefaultWeightedEdge e=this.grafo.addEdge(partenza, destinazione);
				this.grafo.setEdgeWeight(e, t.getMedia());
			} else {
				DefaultWeightedEdge ee=this.grafo.getEdge(partenza, destinazione);
//				double nuovaMedia=t.getMedia()+
				this.grafo.setEdgeWeight(ee, t.getMedia());
			}
			
			
		}
		
		System.out.println(grafo);
		System.out.println(grafo.vertexSet().size());
		System.out.println(grafo.edgeSet().size());
    }

}
