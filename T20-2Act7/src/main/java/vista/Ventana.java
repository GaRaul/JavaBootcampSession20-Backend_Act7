package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField tfCantidad;

	/**
	 * Launch the application.
	 */
	public static void vista() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCantidad = new JLabel("Cantidad a convertir");
		lblCantidad.setBounds(10, 28, 151, 14);
		contentPane.add(lblCantidad);

		JLabel lblResultadoEtiqueta = new JLabel("Resultado");
		lblResultadoEtiqueta.setBounds(316, 28, 72, 14);
		contentPane.add(lblResultadoEtiqueta);

		JLabel lblResultado = new JLabel("0");
		lblResultado.setBounds(398, 28, 158, 14);
		contentPane.add(lblResultado);

		tfCantidad = new JTextField();
		tfCantidad.setBounds(158, 25, 102, 20);
		contentPane.add(tfCantidad);
		tfCantidad.setColumns(10);

		JButton btnConvertir = new JButton("Euros a ptas");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					double cantidad = Double.valueOf(tfCantidad.getText());
					double resultado;
					if (btnConvertir.getText().equals("Euros a ptas")) {
						resultado = cantidad * 166.386;

					} else {
						resultado = cantidad / 166.386;

					}

					lblResultado.setText(String.valueOf(resultado));

				} catch (Exception ex) {
					System.out.println("Introduce un valor valido");
				}
			}
		});

		btnConvertir.setBounds(80, 80, 151, 23);
		contentPane.add(btnConvertir);

		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnConvertir.getText().equals("Euros a ptas")) {
					btnConvertir.setText("Ptas a Euros");
				} else {
					btnConvertir.setText("Euros a ptas");
				}
			}
		});
		btnCambiar.setBounds(286, 80, 89, 23);
		contentPane.add(btnCambiar);
	}

}
