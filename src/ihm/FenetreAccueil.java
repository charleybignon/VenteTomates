package ihm;

import modele.Tomates;
import modele.Tomate;
import modele.TypeTomate;
import modele.Couleur;
import modele.GenerationArticles;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class FenetreAccueil extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPaneTomates;
	private JPanel gridPanelTomates;
	
	private static Tomates tomates;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tomates = GenerationArticles.générationDeBaseDesTomates();
					FenetreAccueil frame = new FenetreAccueil();
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
	public FenetreAccueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JComboBox<String> comboBoxType = new JComboBox<String>();
		comboBoxType.setModel(new DefaultComboBoxModel<String>(new String[] { "Toutes les tomates", 
				"Cerises & Cocktails (16)", 
				"Autres Tomates (47)"}));
		panelSouth.add(comboBoxType);
		
		JComboBox<String> comboBoxCouleur = new JComboBox<String>();
		comboBoxCouleur.setModel(new DefaultComboBoxModel<String>(new String[] { "Couleurs", 
				"Bleu", 
				"Vert", 
				"Rouge", 
				"Orange", 
				"Jaune", 
				"Noir", 
				"Multicolore" }));
		panelSouth.add(comboBoxCouleur);
		
		comboBoxType.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		String type = (String) comboBoxType.getSelectedItem();
        		String couleur = (String) comboBoxCouleur.getSelectedItem();
        		modifierGridTomate(type, couleur);
        	}
		});
		
		comboBoxCouleur.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		String type = (String) comboBoxType.getSelectedItem();
        		String couleur = (String) comboBoxCouleur.getSelectedItem();
        		modifierGridTomate(type, couleur);
        	}
		});
		
		JButton btnConseilsCulture = new JButton("New button");
		panelSouth.add(btnConseilsCulture);
		
		scrollPaneTomates = new JScrollPane();
		//scrollPane.setBackground(new Color(255, 248, 164));
		contentPane.add(scrollPaneTomates, BorderLayout.CENTER);
		
		gridPanelTomates = new JPanel();
		gridPanelTomates.setBackground(new Color(255, 248, 164));
		gridPanelTomates.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		scrollPaneTomates.setViewportView(gridPanelTomates);
	
		modifierGridTomate("Toutes les tomates", "Couleurs");
	}

	private void modifierGridTomate(String type, String couleur) {
		this.gridPanelTomates.removeAll();
		List<Tomate> listTomatesAffichees;
		if (type.equals("Toutes les tomates") && couleur.equals("Couleurs")) {
			listTomatesAffichees = FenetreAccueil.tomates.getLesTomates();
		} 
		else if (type.equals("Toutes les tomates")) {
			listTomatesAffichees = FenetreAccueil.tomates.tomatesDeCouleur(Couleur.getCouleur(couleur));
		}
		else if (couleur.equals("Couleurs")) {
			listTomatesAffichees = FenetreAccueil.tomates.tomatesDeType(TypeTomate.getTypeTomate(type));
		}
		else {
			listTomatesAffichees = FenetreAccueil.tomates.tomatesDetypeDeCouleur(TypeTomate.getTypeTomate(type), Couleur.getCouleur(couleur));
		}
		int nbLignes;
		if (listTomatesAffichees.size()%3 != 0) {
			nbLignes = (listTomatesAffichees.size()/3) + 1;
		} else {
			nbLignes = (listTomatesAffichees.size()/3);
		}
		
		//On calcule le nombre de cases vide à ajouter en fonction du nombre de lignes et du nombre de tomates à afficher
		int nbPanelVide = 3*nbLignes - listTomatesAffichees.size();
		if (listTomatesAffichees.size() <= 3) {
			nbPanelVide += 3;
		}
		if (nbLignes==1) {
			nbLignes++;
		}
		gridPanelTomates.setLayout(new GridLayout(nbLignes, 3, 60, 20));
		
		ajouterTomatesGrid(listTomatesAffichees);
			
		ajouterCasesVidesGrid(nbPanelVide);
	}
	

	private void ajouterCasesVidesGrid(int nbPanelVide) {
		for (int i=0; i<nbPanelVide; i++) {
			JLabel imageLabel = new JLabel();
			imageLabel.setSize(200, 200);
			JLabel titleLabel = new JLabel("     ");
			titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
			JPanel panelCase = new JPanel();
			panelCase.setBackground(new Color(255, 248, 164));
			panelCase.add(imageLabel, BorderLayout.CENTER);
		    panelCase.add(titleLabel, BorderLayout.SOUTH);
			gridPanelTomates.add(panelCase);
			
			scrollPaneTomates.revalidate();
			scrollPaneTomates.repaint();
		}
	}
	

	private void ajouterTomatesGrid(List<Tomate> listTomatesAffichees) {
		for (Tomate t : listTomatesAffichees) {
			ImageIcon imageIcon = new ImageIcon("img\\Tomates200x200\\" + t.getNomImage() + ".jpg");
			JLabel imageLabel = new JLabel(imageIcon);
			JLabel titleLabel = new JLabel(t.getDésignation());
			titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
			JPanel panelCase = new JPanel();
			panelCase.setLayout(new BorderLayout());
			imageLabel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
			titleLabel.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));
			panelCase.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			panelCase.setBackground(Color.WHITE);
			panelCase.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                // Créer et afficher une nouvelle fenêtre
	                FenetreDescription fenetre = new FenetreDescription(t);
	                fenetre.setVisible(true);
	            }
	        });
			panelCase.add(imageLabel, BorderLayout.CENTER);
		    panelCase.add(titleLabel, BorderLayout.SOUTH);
			gridPanelTomates.add(panelCase);
			
			scrollPaneTomates.revalidate();
			scrollPaneTomates.repaint();
		}
	}

}
