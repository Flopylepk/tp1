import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Cuenta {
private String nombre;
private String contraseña;
private double dinero;
private LocalDate hoy;
private String transacciones;



public Cuenta (String a, String b, LocalDate c) {
	this.nombre=a;
	this.contraseña=b;
	this.dinero=2000;
	this.hoy=c;
	this.transacciones=" transferir: ";
}


public void AgregarOperacion(String nuevo) {
	this.transacciones=transacciones + "\n " + nuevo+ "  fecha : "+LocalDate.now();
}
public void Transferir(Cuenta cuenta, double monto) {
	while (monto>dinero) {
		monto=Double.parseDouble(JOptionPane.showInputDialog(" Error dinero insuficiente : Ingrese nuevamente"));
	}
	this.dinero=this.dinero-monto;
	this.AgregarOperacion(" transferencia: "+" desde : "+this.nombre+ " a: "+cuenta.nombre+   " monto: "+monto);
	
	cuenta.dinero=cuenta.dinero+monto;
	cuenta.AgregarOperacion(" transferencia: "+" desde : "+this.nombre+ " a: "+cuenta.nombre+   " monto: "+monto);
	
	
}
public boolean Retiro(double monto) {
	boolean flag=true;
	if (monto<this.dinero) {
		JOptionPane.showMessageDialog(null, " la transaccion es correcta ");
		this.dinero=this.dinero-monto;
		
	} else {
		flag=false;
	}
	return flag;
}

public double Deposito(double x) {
	this.dinero=this.dinero+x;
	return x;
}
////// GET/SET DINERO
public double getDinero() {
	return this.dinero;
}
public void setDinero(double a) {
	this.dinero=a;
}
///////// GET/SET NOMBRE
public String getNombre() {
	return this.nombre;

}
public void setNombre(String a) {
	this.nombre=a;
}
///////////// GET/SET CONTRASEÑA
public String getContraseña() {
	return this.contraseña;
}
public void setContraseña(String a) {
	this.contraseña=a;
}
/////////// GET/SET LocalDate
public LocalDate getHoy() {
	return this.hoy;
}
public void setHoy(LocalDate a) {
	this.hoy=a;
}


@Override
public String toString() {
	return "Cuenta [nombre=" + nombre + ", contraseña=" + contraseña + ", dinero=" + dinero + ", hoy=" + hoy
			+ ", transacciones=" + transacciones + "]";
}






}
