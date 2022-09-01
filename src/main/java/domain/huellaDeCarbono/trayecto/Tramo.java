package domain.huellaDeCarbono.trayecto;

import apiDistancia.ServicioApiDistancia;
import domain.huellaDeCarbono.espacio.Espacio;
import domain.huellaDeCarbono.medioDeTransporte.MedioDeTransporte;
import domain.miembro.Miembro;

import java.io.IOException;
import java.util.Collection;

public class Tramo {
  private Espacio partida;
  private Espacio llegada;
  private MedioDeTransporte transporte;
  private Collection<Miembro> miembros;
  private double distancia;

  public Tramo(Espacio partida, Espacio llegada, MedioDeTransporte transporte, Collection<Miembro> miembros) throws IOException {
    this.partida = partida;
    this.llegada = llegada;
    this.transporte = transporte;
    if(miembros.size() == 1 || transporte.puedoSerCompartido()) {
      this.miembros = miembros;
    }
    distancia =  ServicioApiDistancia.getInstancia().obtenerDistancia(partida, llegada);
  }


  public Espacio getPartida() {
    return partida;
  }

  public Espacio getLlegada() {
    return llegada;
  }

  public MedioDeTransporte getTransporte() {
    return transporte;
  }

  public Collection<Miembro> getMiembros(){ return miembros;}

  public void agregarMiembro(Miembro miembro) {
    if(transporte.puedoSerCompartido()) {
      miembros.add(miembro);
    }
  }

  public double calcularHuellaCarbonoTramo() {
    System.out.println("CalculoTramo: " + (this.transporte.getFactorEmision() * this.calcularDistancia()) / miembros.size());
    return (this.transporte.getFactorEmision() * this.calcularDistancia()) / miembros.size();
  }

  public double calcularDistancia() {
    return distancia;
    //return ServicioApiDistancia.getInstancia().obtenerDistancia(llegada,partida);
  }

  public boolean tieneMiembro(Miembro miembro) {
    return miembros.contains(miembro);
  }

  public double getDistancia() {
    return distancia;
  }
}
