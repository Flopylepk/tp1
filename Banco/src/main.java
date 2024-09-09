import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] opciones = { "transferir", "deposito", "retiro", "salir" };
		String[] contactos = { " Franco " };
		int elegida;
		int cont1;
		LocalDate hoy = LocalDate.now();
		String nombre = validar(" ingrese su nombre ");
		String contraseña = validar("ingrese su contraseña");
		Cuenta unica = new Cuenta(nombre, contraseña, hoy);
		Cuenta dos = new Cuenta(" Franco ", " 1234 ", hoy);
		JOptionPane.showMessageDialog(null, unica,
				"SESIÓN INICIADA",
				JOptionPane.DEFAULT_OPTION,
				new ImageIcon(main.class.getResource("/img/banco.png")));

		do {

			elegida = JOptionPane.showOptionDialog(null, "elija lo que quiere hacer", "MENU",
					JOptionPane.INFORMATION_MESSAGE, 0, null, opciones, opciones[0]);
			switch (elegida) {
			case 0:
				
				cont1 = JOptionPane.showOptionDialog(null, "elija a que cuenta quiere tranferir ", "MENU",
						JOptionPane.INFORMATION_MESSAGE, 0, null, contactos, contactos[0]);
				double transferencia = validarnum("ingrese cuanto dinero quiere enviar");

				unica.Transferir(dos, transferencia);
			
				JOptionPane.showMessageDialog(null, unica, "Datos de la cuenta",JOptionPane.DEFAULT_OPTION,
						new ImageIcon(main.class.getResource("/img/banco.png")));
				
				JOptionPane.showMessageDialog(null, dos,"Datos de la cuenta",JOptionPane.DEFAULT_OPTION,
						new ImageIcon(main.class.getResource("/img/banco.png")));
				break;
			case 1:
				
				double deposito = validarnum(" ingrese cuanto dinero quiere depositar ");
				unica.Deposito(deposito);
				JOptionPane.showMessageDialog(null, " Operación exitosa ");
				unica.AgregarOperacion(" deposito ");
				JOptionPane.showMessageDialog(null, unica, "Datos de la cuenta",JOptionPane.DEFAULT_OPTION,
						new ImageIcon(main.class.getResource("/img/banco.png")));

				break;
			case 2:
				
				double retiro = validarnum(" ingrese cuanto dinero quiere retirar ");
				while (!unica.Retiro(retiro)) {
					retiro = validarnum(" ingrese cuanto dinero quiere retirar ");
				}
				;
				unica.AgregarOperacion(" retiro ");
				JOptionPane.showMessageDialog(null, unica,"Datos de la cuenta",JOptionPane.DEFAULT_OPTION,
						new ImageIcon(main.class.getResource("/img/banco.png")));
				break;

			default:
				JOptionPane.showMessageDialog(null, "cerrando sesion...");
				break;
			}
		} while (elegida != 3);

	}

	public static String validar(String mensaje) {
		String a = JOptionPane.showInputDialog(mensaje);
		while (a.isEmpty()) {
			a = JOptionPane.showInputDialog("Error: " + mensaje);
		}

		return a;
	}

	public static double validarnum(String mensaje) {
		boolean flag = true;
		String x;
		do {
			x = JOptionPane.showInputDialog(mensaje);
			while (x.isEmpty()) {
				x = JOptionPane.showInputDialog(" Error : " + mensaje);
			}
			for (int i = 0; i < x.length(); i++) {
				if (!Character.isDigit(x.charAt(i))) {
					JOptionPane.showMessageDialog(null, " usted no completo un número ");
					flag = false;
					break;
				}
			}
		} while (!flag);
		return Double.parseDouble(x);
	}

}
