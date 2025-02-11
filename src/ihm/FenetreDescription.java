package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.Couleur;
import modele.Tomate;
import modele.TypeTomate;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FenetreDescription extends JFrame {

	private JPanel contentPane;
	JPanel panelGauche;
	JPanel panelDroite;
	
	Tomate tomate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tomate tomateTest = new Tomate(TypeTomate.TOMATES_CERISES, Couleur.NOIR, "Tomate Negro Azteca", null, "Negro-Azteca-1-scaled", 
							"Variété ancestrale pourpre foncé, provenant des Aztèques, selon Eduardo Valenzuela, de mi-saison, fruits de 15-20g.\r\n"
									+ "\r\n"
									+ "Chair dense, douce et sucrée, avec peu de graines. Résistante à la sécheresse.", 
									50, 3.85F);
					FenetreDescription frame = new FenetreDescription(tomateTest);
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
	public FenetreDescription(Tomate t) {
		this.tomate = t;		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelValidation = new JPanel();
		contentPane.add(panelValidation, BorderLayout.SOUTH);
		
		JButton buttonAjouter = new JButton("Ajouter au panier");
		panelValidation.add(buttonAjouter);
		
		JButton buttonAnnuler = new JButton("Annuler");
		panelValidation.add(buttonAnnuler);		
		
		JPanel panelPresentationTomate = new JPanel();
		contentPane.add(panelPresentationTomate, BorderLayout.CENTER);
		panelPresentationTomate.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panelGauche = new JPanel();
		panelPresentationTomate.add(panelGauche);
		panelGauche.setLayout(new BoxLayout(panelGauche, BoxLayout.Y_AXIS));
		
		JLabel JLabelNomTomate = new JLabel(tomate.getDésignation());
		panelGauche.add(JLabelNomTomate);
		
		ImageIcon imageIcon = new ImageIcon("img\\Tomates200x200\\" + t.getNomImage() + ".jpg");
		JLabel JLabelmg = new JLabel(imageIcon);
		panelGauche.add(JLabelmg);
		
		JLabel JLabelStock = new JLabel("stock");
		panelGauche.add(JLabelStock);
		
		JComboBox<String> comboBoxSimilaires = new JComboBox<String>();
		panelGauche.add(comboBoxSimilaires);
		
		JPanel panelDroite = new JPanel();
		panelPresentationTomate.add(panelDroite);
		panelDroite.setLayout(new BoxLayout(panelDroite, BoxLayout.Y_AXIS));
		
		JLabel JLabelDescription = new JLabel("Description : ");
		panelDroite.add(JLabelDescription);
		
		JLabel JLabelDescriptionTomate = new JLabel(tomate.getDescription());
		panelDroite.add(JLabelDescriptionTomate);
		
		JPanel panelNbGraines = new JPanel();
		panelDroite.add(panelNbGraines);
		
		JLabel lblNewLabel = new JLabel("Nombre de graines :");
		panelNbGraines.add(lblNewLabel);
		
		JPanel panelPrix = new JPanel();
		panelDroite.add(panelPrix);
		
		JLabel JLabelPrixDesignation = new JLabel("Prix : ");
		panelPrix.add(JLabelPrixDesignation);
		
		JLabel JLabelPrix = new JLabel(Float.toString(tomate.getPrixTTC()));
		panelPrix.add(JLabelPrix);
		
		JSpinner spinnerQuantite = new JSpinner();
		panelPrix.add(spinnerQuantite);
	}


}

