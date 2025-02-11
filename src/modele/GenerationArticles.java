package modele;

import java.util.LinkedList;
import java.util.List;

public class GenerationArticles {

	public static void main(String[] args) {
		Tomates mesArticles = générationDeBaseDesTomates();
		System.out.println(mesArticles);
		List<Tomate> tomates = mesArticles.getLesTomates();
		for(Tomate graine: tomates) {
			System.out.println(graine.toStringAvecTomatesApparentées());
		}
	}
	
	public static Tomates générationDeBaseDesTomates() {
		Tomates mesArticles = new Tomates();
		mesArticles.addTomates(GenerationTomates());
		mesArticles.addTomates(GenerationTomatesCerises());
		updateEpuisées(mesArticles);
		tomatesApparentées(mesArticles);
		return mesArticles;
	}

	private static void updateEpuisées(Tomates mesArticles) {
		mesArticles.getTomate("Tomate Délice du Jardinier").setDisponible(false);
		mesArticles.getTomate("Tomate Belle Rose").setDisponible(false);
		mesArticles.getTomate("Tomate Coeur de Boeuf Jaune").setDisponible(false);	
		mesArticles.getTomate("Tomate Chair de Boeuf « Beefsteak »").setDisponible(false);			
	}
	
	private static void tomatesApparentées(Tomates mesArticles) {
		List<Tomate> tomates = mesArticles.tomatesDeType(TypeTomate.TOMATES);
		génerationAléatoireTomatesApparentées(tomates);
		List<Tomate> tomatesCerises = mesArticles.tomatesDeType(TypeTomate.TOMATES_CERISES);
		génerationAléatoireTomatesApparentées(tomatesCerises);
	}

	private static void génerationAléatoireTomatesApparentées(List<Tomate> tomates) {
		for (Tomate graine: tomates) {
			while (graine.getTomatesApparentées().size() < 4) {
				int random = (int) (tomates.size() * Math.random());
				graine.addTomateApparentée(tomates.get(random));
			}
		}
	}

	static List<Tomate> GenerationTomates() {
		List<Tomate> tomates = new LinkedList<Tomate>();
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.NOIR, "Tomate Noire de Crimée", null, "Noire_Crimee-1", 
				"Résistante à la sécheresse. Beaux fruits de 120-150 g pouvant même atteindre 500 g. \r\n"
				+ "\r\n"
				+ "Peau lisse devenant rouge trés sombre à pourpre à maturité. Sa chair est dense, son goût puissant et sucré.\r\n"
				+ "\r\n"
				+ "Une variété locale lui ressemble beaucoup : La Charbonnière du Berry, extra !", 
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Andine Cornue", null, "TomateAndine4-2-scaled", 
				"Le poivron des Andes !\r\n"
				+ "\r\n"
				+ "Très rustique et précoce. Fruits de 80 à 150 gr. \r\n"
				+ "\r\n"
				+ "Considérée comme l'une des meilleures. Découverte au Pérou et importée en France par un ingénieur agronome, "
				+ "spécialiste de l'agriculture tropicale, dans les années 50.\r\n"
				+ "En forme de poivron, d'un rouge vif, elle contient peu de graines, ce n'est quasiment que de la chair. Sans acidité, très digeste et parfumée.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.JAUNE, "Tomate Ananas", null, "ananas-2-scaled", 
				"Très ancienne variété originaire du Kentucky. Fruits de 250 à 400 gr. en moyenne, pouvant atteindre 1 kg.\r\n"
				+ "\r\n"
				+ "Cette variété tardive produit d'énormes tomates rondes dont la chair est semblable à celle d'une tranche d'ananas, jaune orangée rayée de rouge.\r\n"
				+ "\r\n"
				+ "Contient peu de graines, ferme, juteuse, sucrée et très parfumée. Il faut absolument la manger crue, elle est délicieuse et irremplaçable !\r\n",
				50, 4.10F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Coeur de Boeuf Rouge", null, "coeur-de-boeuf-rouge-2-scaled", 
				"Les gens l'adorent !\r\n"
				+ "\r\n"
				+ "Variété tardive, fruits de 300 à 400 gr, à la chair dense, juteuse, douce, sans acidité et très parfumée.\r\n"
				+ "\r\n"
				+ "A consommer en salade, purée ou confite.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Reine de Sainte Marthe", null, "TomateReineSteMarthe-2-scaled", 
				"Productive, fruits de 150 à 250 gr.\r\n"
				+ "\r\n"
				+ "Variété française retrouvée à la Ferme-Conservatoire de Mille Variétés Anciennes à Sainte Marthe en Sologne. "
				+ "C'est un magnifique fruit à la chair dense, juteuse, sucrée et très parfumée. "
				+ "Le fruit est lourd, rond, bien rouge et de forme régulière. Tout à fait indiquée pour faire des tomates farcies.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.VERT, "Tomate Green Zebra", null, "Green_Zebra", 
				"Cette variété est originaire des Etats-Unis.\r\n"
				+ "\r\n"
				+ "C'est une magnifique variété de mi-saison aux fruits verts zébrés de jaune.\r\n"
				+ "\r\n"
				+ "La chair de couleur vert émeraude est dense, juteuse et légèrement acidulée. Excellente en salade, en conserve ou confite.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Royale des Guineaux", null, "I-Grande-4896-tomate-royale-des-guineaux-ab.net_l", 
				"Précoce et productive. Fruits de 150 à 200 gr.\r\n"
				+ "\r\n"
				+ "Sa peau est fine et sa chair ferme, juteuse et d'excellente saveur. On vous la conseille en salade en sauce ou en jus. Résistante aux maladies.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Rose de Berne", null, "Rose_Berne", 
				"Tomate aux beaux fruits ronds à peau fine caractéristique des tomates roses !\r\n"
				+ "\r\n"
				+ "Cette variété récoltée à maturité totale reste une des plus appréciées des vrais gourmets amateurs de tomates ! "
				+ "Mais elle n�est pas très productive.\r\n"
				+ "\r\n"
				+ "Sa chair est fine, parfumée, très juteuse et vraiment très rafraîchissante. Elle contient peu de graines.\r\n"
				+ "\r\n"
				+ "Elle n'a pratiquement pas de peau.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Bonne Fée",
				"Cette variété fait partie de notre collection les Trésors du Conservatoire.", "Bonne_fee-4-scaled", 
				"Variété très rare disponible uniquement au conservatoire.\r\n"
				+ "\r\n"
				+ "Très grosse tomate de mi-saison, aux fruits légèrement aplatis, magnifique, variété très rare.\r\n"
				+ "\r\n"
				+ "La chair est juteuse, douce, sucrée, au goût excellent, constant dans la saison.",
				25, 5.00F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Coeur Fondant",  
				"Cette variété fait partie de notre collection les Trésors du Conservatoire.","coeurfondant-scaled",
				"Variété très rare disponible uniquement au conservatoire.\r\n"
				+ "\r\n"
				+ "Tomate rouge de taille petite à grosse, tardive, de forme allongée, légèrement en forme de coeur, peu sensible au fendillement.\r\n"
				+ "\r\n"
				+ "Chair dense et très juteuse, sucrée, peu acide, beaucoup de goût, bien adaptée à la cuisson, farcie ou en sauce et coulis.",
				25, 5.00F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Purple Calabash", null, "PurpleCalabash", 
				"Variété ancestrale de mi-saison à tardive, produisant des fruits aplatis, tourmentés, très côtelés, de couleur rouge foncé à pourpre.\r\n"
				+ "\r\n"
				+ "Juteuse au goût intense. Une tomate unique en son genre !",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Belle Fille des Maraîchers", 
				"Cette variété fait partie de notre collection les Trésors du Conservatoire.", "bellefille_maraichers-scaled", 
				"Variété très rare disponible uniquement au conservatoire.\r\n"
				+ "\r\n"
				+ "Très grosse tomate de mi-saison, toute ronde, formant des grappes, au goût excellent.",
				25, 5.00F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Grosse de Trélazé", 
				"Cette variété fait partie de notre collection les Trésors du Conservatoire.", "Tomate-grosse-de-Trelaze", 
				"Variété très rare disponible uniquement au conservatoire.\r\n"
				+ "\r\n"
				+ "énorme tomate tardive, dont le poids peut atteindre 1 kg !\r\n"
				+ "\r\n"
				+ "Côtelée et légèrement aplatie, de couleur rouge clair, peu sensible au fendillement et de bonne conservation.\r\n"
				+ "\r\n"
				+ "Son goût est puissant et sucré, elle est juteuse, et se prête à tout usage culinaire, crue ou cuite.",
				25, 5.00F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Grosse Hâtive d'Orléans", 
				"Variété Locale de la Région Centre-Val de Loire", "grosse_horleans-1-scaled", 
				"Tomate vraiment hâtive, au cycle court, qui donne beaucoup en début de saison.\r\n"
				+ "\r\n"
				+ "C'est une tomate de taille moyenne, légèrement aplatie, côtelée autour du pédoncule, à la peau ferme, de bonne conservation.\r\n"
				+ "\r\n"
				+ "Nous participons à sa sauvegarde et à sa reproduction en unissant nos efforts à ceux de l'URGC (Union des Ressources Génétiques "
				+ "de la Région Centre), dont l'objet est le sauvetage des variétés potagères et des races animales anciennes en voie de disparition.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ORANGE, "Tomate Mangue", 
				"Cette variété fait partie de notre collection les Trésors du Conservatoire.", "mangue-scaled", 
				"Variété très rare disponible uniquement au conservatoire.\r\n"
				+ "\r\n"
				+ "Tomate hâtive, de taille moyenne, lourde, à la peau tendue orangée au départ, qui devient jaune à maturité.\r\n"
				+ "\r\n"
				+ "L'intérieur est surprenant, coupée en deux, les loges de formes biscornues dessinent une espèce de statue maya. "
				+ "Sa chair orangée de qualit� exceptionnelle évoque la mangue.\r\n"
				+ "\r\n"
				+ "Elle est juteuse juste ce qu'il faut, de fermeté moyenne, sucrée, peu acide et son goût est délicieux.\r\n"
				+ "\r\n"
				+ "On peut la manger encore tard dans la saison et elle se conserve bien.",
				25, 5.00F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.MULTICOLORE, "Tomate Tigrella Bicolore", null,"Tomate-Tigrella-Bicolore-1-scaled", 
				"Variété précoce, originaire d'Angleterre, donnant des fruits de taille moyennes de 70 à 100g , bicolores, rouges à rayures jaunes.\r\n"
				+ "\r\n"
				+ "Variété productive très résistante aux maladies.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Buissonnante", null, "Tomate-Buissonnante-2-1-scaled", 
				"Les avantages de cette variété sont : excellent goût, bonne grosseur et pas besoin de piquet de support. "
				+ "Quoi demander de mieux ? Excellent rendement.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.BLEU, "Tomate Belle Bacchante", null, "tomate_bacchante-scaled", 
				"Très belle tomate bleue, très productive et assez résistante aux maladies.\r\n"
				+ "\r\n"
				+ "Création de Tom Wagner, donnée par le château de la Bourdaisière.\r\n"
				+ "\r\n"
				+ "Tomate de type prune, goût propre aux tomates bleues.\r\n"
				+ "\r\n"
				+ "Cette tomate se conserve longtemps apr�s la récolte.",
				25, 5.00F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Belle Rose", 
				"Cette variété fait partie de notre collection les Trésors du Conservatoire", "bellerose-scaled", 
				"Variété très rare disponible uniquement au conservatoire.\r\n"
				+ "\r\n"
				+ "Grosse tomate rouge, de mi-saison, très légèrement aplatie, peu sensible au fendillement, dont les côtes plongent vers le pédoncule.\r\n"
				+ "\r\n"
				+ "Beaucoup de chair moyennement ferme, juteuse, au goût excellent ! Elle est constante en goût au cours de la saison.\r\n"
				+ "\r\n"
				+ "Cette tomate est une merveille à manger crue ou en coulis et sauce.",
				25, 5.00F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.JAUNE, "Tomate Coeur de Boeuf Jaune", null, "Coeur_Boeuf_Jaune", 
				"Comme toutes les tomates Coeur de boeuf, elle est très charnue et a peu de graines. Sa couleur est jaune-orangé.\r\n"
				+ "\r\n"
				+ "Variété tardive, fruits de 300 à 400 gr à la chair juteuse, douce, sans acidité et très parfumée.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.MULTICOLORE, "Tomate Banana Legs", null, "bananalegs2-scaled", 
				"Cette tomate jaune de mi-saison, obtenue en 1984, tout comme la Green Zébra, par le \" magicien \" Tom Wagner, est très appréciée. "
				+ "Elle ressemble � une petite banane d'environ 10 cm de long. Les fruits de cette variété productive poussent sur une longue période.\r\n"
				+ "\r\n"
				+ "Elle est peu juteuse et contient peu de graines.\r\n"
				+ "\r\n"
				+ "Il est intéressant de la couper dans le sens de la longueur et d'en déposer des tranches sur une salade de tomates d'autres couleurs, "
				+ "l'effet est garanti ! Sa saveur évoque l'agrume.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.NOIR, "Tomate Stripes of Yore", null, "Stripes-of-Yore", 
				"Variété nouvelle de Tom Wagner. Grappes de tomates moyennes productives de mi-saison, couleur zébrée jaune et bleu violacées voire noire.\r\n"
				+ "\r\n"
				+ "Goût vraiment doux et bien sucré lorsque les fruits sont récoltés très murs.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.JAUNE, "Tomate Poivron Jaune", null, "tomate_poivron_jaune2-1", 
				"Variété de mi-saison, fruits de 80 à 100 g. De type Andine Cornue. \r\n"
				+ "\r\n"
				+ "Tomate en forme de poivron à la chair ferme, et au goût légèrement fruité et acidulé.\r\n"
				+ "\r\n"
				+ "A consommer en salade et coulis.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Château Rose", 
				"Cette variété fait partie de notre collection les Trésors du Conservatoire.", "Chateau_Rose-scaled", 
				"Variété très rare disponible uniquement au conservatoire.\r\n"
				+ "\r\n"
				+ "Tomate retrouvée d’un don de 1990. \r\n"
				+ "\r\n"
				+ "Variété rare. Jolie tomate rose à la forme ronde parfaite.\r\n"
				+ "\r\n"
				+ "De taille moyenne. Très peu sensible aux maladies et fendillement.\r\n"
				+ "\r\n"
				+ "La peau est lisse, la chair est douce et très parfumée.",
				25, 5.00F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Château de Chartres",  
				"Variété Locale de la Région Centre-Val de Loire", "Chateau-de-Chartres-scaled",
				"Tomate française de variété ancienne rare, de mi-saison, régionale, retrouvée en Croatie. Très gros fruits rouge intense de 600g à 1kg, légèrement côtelés.\r\n"
				+ "\r\n"
				+ "Fruits charnus, peu de graines et très bon goût, comparable à la Bonne Fée.\r\n"
				+ "\r\n"
				+ "Nous participons à sa sauvegarde et à sa reproduction en unissant nos efforts à ceux de l’URGC "
				+ "(Union des Ressources Génétiques de la Région Centre), dont l’objet est le sauvetage des variétés potagères et des races animales "
				+ "anciennes en voie de disparition.",
				25, 5.00F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.JAUNE, "Tomate Jaune Saint Vincent", null, "stvincent-scaled", 
				"Variété de mi-saison aux très beaux fruits assez gros, de 150 à 250 g, d’un jaune intense, à la chair juteuse, douce, "
				+ "sucrée et acidulée (juste ce qu’il faut !), très parfumée, de culture très simple.\r\n"
				+ "\r\n"
				+ "C’est à l’évidence une des meilleures tomates jaunes qui existe !",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ORANGE, "Tomate Brandywine", null, "Brandywine-scaled", 
				"Grosse tomate américaine de variété ancienne tardive, rouge-orangée.\r\n"
				+ "\r\n"
				+ "Les fruits de 150 à 200 gr. environ ont une chair fine, juteuse et douce au goût raffiné et vineux. Productive et très vigoureuse.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Charbonnière du Berry", 
				"Variété Locale de la Région Centre-Val de Loire", "Charboniere-du-Berry-scaled", 
				"Gros fruits pourpres marbrés de vert de 300 à 800 g. à bien laisser mûrir. Attention cependant au fendillement.\r\n"
				+ "\r\n"
				+ "Chair ferme et fine, au goût prodigieux et légèrement sucré. Croissance déterminée. Comparable à la Noire de Crimée.\r\n"
				+ "\r\n"
				+ "Nous participons à sa sauvegarde et à sa reproduction en unissant nos efforts à ceux de l’URGC "
				+ "(Union des Ressources Génétiques de la Région Centre), dont l’objet est le sauvetage des variétés potagères et "
				+ "des races animales anciennes en voie de disparition.",
				50, 5.00F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.VERT, "Tomate Evergreen", null, "TomateEverGreen1-scaled", 
				"Magnifique variété de taille moyenne, dont la chair d’un vert émeraude intense est exceptionnelle, juteuse, fine, douce et très fruitée !\r\n"
				+ "\r\n"
				+ "Variété de mi-saison, fruits de 100 à 150 g, de culture facile.\r\n"
				+ "\r\n"
				+ "On cueille les fruits vers la mi-août, lorsqu’apparaît sur le fruit un dessin de pelure d’oignon. "
				+ "À ce moment-là le fruit est tendre sous la main, indice de maturité.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Chair de Boeuf « Beefsteak »", null, "Tomates-Beefsteak-TEMP-l", 
				"Très connue aux Etats-Unis sous le nom de « Beefsteak Tomato ».\r\n"
				+ "\r\n"
				+ "Cette tomate de couleur pourpre, a une chair épaisse, fondante et fortement parfumée !",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Marmande", null, "Tomate-marmande-TEMP", 
				"Variété traditionnelle plate et côtelée, assez précoce, vigoureuse et productive.\r\n"
				+ "\r\n"
				+ "Ses fruits de 150 à 250 g ont une chair ferme, sucrée et parfumée au goût typé.\r\n"
				+ "\r\n"
				+ "À cuisiner en salade, farcie, en gratin ou en sauce.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ORANGE, "Tomate Carotina", null, "Carotina-2-scaled", 
				"C’est la plus belle des tomates orange foncée qui soient ! Fruits de 200 à 250g, juteuse, parfumée et mielleuse, elle fond dans la bouche.\r\n"
				+ "\r\n"
				+ "Ronde et bien galbée, riche en provitamine A. Résistante aux maladies, excellente production : idéale en maraîchage.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Merveille des Marchés", null, "Tomate-merveille-des-marches-2-TEMP", 
				"Très ancienne variété datant des années 1880, qui était cultivée par les maraîchers, car très productive.\r\n"
				+ "\r\n"
				+ "Le fruit est gros, rond, légèrement aplati, à la peau lisse, rouge et à chair rose. Il est goûteux et contient peu de graines.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Sainte Lucie", null, "Tomate-sainte-lucie.TEMP_l", 
				"Belle variété tardive, énorme, rouge foncé, très productive.\r\n"
				+ "\r\n"
				+ "Chair lourde et épaisse. La peau s’épluche très facilement.\r\n"
				+ "\r\n"
				+ "Idéale pour la cuisson.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Voyage", null, "Tomate-voyageur-TEMP", 
				"Une étonnante variété aux fruits de 100 g, quasiment divisés en portions, à la chair épaisse, juteuse, et sucrée.\r\n"
				+ "\r\n"
				+ "À consommer nature ou en salade.\r\n"
				+ "\r\n"
				+ "Variété Précoce et productive.\r\n"
				+ "",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Poire de Nouvelle Zélande", null, "Poire-de-Nouvelle-Zelande-scaled", 
				"Grosse tomate de mi-saison, en forme de poire rose à collet parfois vert. Saveur soyeuse et chair dense fondante et peau fine.\r\n"
				+ "\r\n"
				+ "Très productive. A consommer en salade ou en sauce.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate San Merzano", null, "Tomate-San-Marzano-TEMP-1", 
				"Tomate allongée, de taille moyenne, à chair dense et ferme.\r\n"
				+ "\r\n"
				+ "Contient peu de graines et de jus.\r\n"
				+ "\r\n"
				+ "Traditionnellement utilisée en Italie pour les pizzas.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Belle Angevine", null, "Tomate-Belle-Angevine-1-scaled", 
				"Vieille variété française, ronde et rouge, variété productive.\r\n"
				+ "\r\n"
				+ "A cuisiner en salade et en coulis.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Coeur Rose", null, "TomateCoeur-scaled", 
				"Variété de grosses tomates Coeur de couleur Rose, portant des fruits de 300 à 400 gr, à chair dense, juteuse, douce, "
				+ "sans acidité et très parfumée.\r\n"
				+ "\r\n"
				+ "Variété tardive.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.JAUNE, "Tomate Jaune de Thoune", null, "jaune_thoune-scaled", 
				"Tomate moyenne orange très productive durant toute la saison.\r\n"
				+ "\r\n"
				+ "Tomate assez sucrée se prêtant bien en coulis ou en sauce où la saveur est exaltée.\r\n"
				+ "\r\n"
				+ "Variété assez précoce, vigoureuse et assez résistante face aux aléas environnementaux. Adaptée au climat difficile de montagne. ",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Petit Bec", null, "Tomate-petit-bec-TEMP", 
				"Variété du Québec, hâtive. Tomates rouges, de taille moyenne, en grappes.\r\n"
				+ "\r\n"
				+ "Forte productivité et croissance déterminée à environ 50cm de hauteur.\r\n"
				+ "\r\n"
				+ "Saveur sucrée et acidulée. Variété Idéale pour faire des sauces tomates.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Délicieuse de Burpée", null, "Tomate-Delicieuse-de-Burpee-Ressemble-scaled", 
				"Variété américaine de mi-saison, vigoureuse. Beaux fruits de 200 à 500 g.\r\n"
				+ "\r\n"
				+ "Chair ferme, juteuse, sucrée et très parfumée. Peau fine qui ne se fendille pas.\r\n"
				+ "\r\n"
				+ "Se cuisine en salade, purée, farcie, coulis et sauce.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.JAUNE, "Tomate Beauté Blanche", null, "IMG_3088-scaled", 
				"Variété très productive, jus abondant et très doux, idéale pour les enfants.\r\n"
				+ "\r\n"
				+ "Avec son excellente qualité gustative, elle est idéale cuisinée en salade. À bien tailler.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ORANGE, "Tomate Russian Persimmon", null, "Tomate-Russian-persimmon.-TEMP", 
				"Variété originaire d’Ukraine aux jolis fruits orange, ressemblant à des kakis, un peu aplatis, pesant de 120 à 250g.\r\n"
				+ "\r\n"
				+ "Sa chair est juteuse, et sa saveur douce. Bonne crue ou cuite.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Demit de Rosoy", null, "Tomate-Demit-de-Rosoy-scaled", 
				"Cette variété a été sélectionnée par une famille de jardiniers sur 3 générations.\r\n"
				+ "\r\n"
				+ "Grosse tomate rouge côtelée, de très bonne qualité gustative, charnue et fondante, et ayant peu de graines.\r\n"
				+ "\r\n"
				+ "C’est une variété tardive.",
				50, 3.85F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.ROUGE, "Tomate Joie de la Table", null, "Tomate-Joie-de-la-Table-ressemble-scaled", 
				"Variété rustique, précoce vigoureuse et productive.\r\n"
				+ "\r\n"
				+ "Ses fruits de 150 à 250 g, très légèrement côtelés, ont une chair fine, juteuse et savoureuse.\r\n"
				+ "\r\n"
				+ "Elles sont délicieuses en salade.",
				50, 3.95F));
		tomates.add(new Tomate(TypeTomate.TOMATES, Couleur.NOIR, "Tomate Black Tomato", null, "IMG_8925-scaled", 
				"Gros fruit rond et aplati, rouge sombre, ombré près du pédoncule, pesant de 200 à 400 gr.\r\n"
				+ "\r\n"
				+ "Sa chair pourpre est charnue et juteuse. Très bonne saveur.",
				50, 3.95F));
		return tomates;
	}
	
	static List<Tomate> GenerationTomatesCerises() {
		List<Tomate> tomatesCerises = new LinkedList<Tomate>();
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.ROUGE, "Tomate Miel du Mexique", null, "IMG_5460", 
				"Excellente résistance à la sécheresse. Rendement très élevé, fruits de taille moyenne de 15 à 20 gr.\r\n"
				+ "\r\n"
				+ "Produit des fruits jusqu'en fin de belle saison, sans perte de goût et sans s'abîmer.\r\n"
				+ "\r\n"
				+ "Les fruits sont bien ronds, rouge vif, juteux, au goût exquis, doux, non acide. Tomate très sucrée.", 
				50, 3.95F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.ROUGE, "Tomate Cocktail Clémentine", null, "TomateGardenersDelight-2", 
				"Variété précoce, ne se taille pas.\r\n"
				+ "\r\n"
				+ "Elle produit des grappes de petites tomates de la taille des mirabelles (5 à 6 grammes) . Les fruits sont nombreux, fermes, juteux et sucrés. "
				+ "Idéal à croquer nature à l'apéritif, en brochette ou pour décorer un plat. On peut aussi en faire des confitures.\r\n"
				+ "\r\n"
				+ "Type : tomates cerises", 
				50, 3.85F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.ROUGE, "Tomate Délice du Jardinier", null, "GardenersDelight2", 
				"Aussi appelée Gardener's delight, cette tomate a un rendement énorme. C'est une variété précoce, vigoureuse productive "
				+ "qui produit de belles grappes de fruits sans discontinuer jusqu'aux premières gelées.\r\n"
				+ "\r\n"
				+ "également appelée Délice du jardinier ou Merveille du jardinier, elle a de petits fruits pesant de 20 à 30 g, à chair ferme, "
				+ "regorgeant d'un jus sucré et acidulé. C'est l'une des plus parfumées et des meilleures tomates cerises.", 
				50, 3.85F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.ROUGE, "Tomate Prune Noire", null, "IMG_1124-scaled", 
				"Tomate rustique, productive, à chair douce, ferme et juteuse, et à peau ferme.\r\n"
				+ "\r\n"
				+ "Fruits en grappe de 25 à 30 grammes, à consommer nature ou confite.", 
				50, 3.85F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.JAUNE, "Tomate Groseille Champagne", null, "IMG_0648-scaled", 
				"Petite tomate d'environ 1,5 cm de diamètre, au goût exceptionnel, un véritable bonbon.", 
				50, 3.95F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.ORANGE, "Tomate Orange Bourgois", null, "OrangeBourgois2", 
				"C'est une petite tomate avec des fruits de 50 g environ, productive, à grappes. \r\n"
				+ "\r\n"
				+ "C'est une petite tomate à la peau fine, sa chair est juteuse, fruitée, douce et sucrée. C'est la meilleure des tomates oranges.\r\n"
				+ "\r\n"
				+ "Dégustez-la nature, et aussi excellente en confiture.", 
				50, 3.85F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.VERT, "Tomate Green Grape", null, "TomateGreenGrape2-scaled", 
				"La tomate Green Grape ou Raisin Vert est une variété de mi-saison, produit de nombreuses grappes de petits fruits verts (20g), "
				+ "à la chair juteuse, sucrée et très parfumée. Pour apéritif et cocktails. Cette variété est particulièrement résistante au Mildiou.", 
				50, 3.85F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.ROUGE, "Tomate Groseille Rouge", null, "groseillerouge-scaled", 
				"Très proche du type sauvage, cette espèce de mi-saison proche de la tomate cultivée, "
				+ "produit de très nombreux petits fruits rouges ronds en grappes portant de nombreux fruits de 1,5 à 2 grammes. "
				+ "Ces micro-tomates sont fermes à la saveur acidulée et parfumée.\r\n"
				+ "Tomates à manger à la croque-au-sel, en garniture ou à mettre en bocaux.\r\n"
				+ "\r\n"
				+ "Tomate très résistante au mildiou et à l'oédium.", 
				50, 3.95F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.ORANGE, "Tomate Groseille Orange", null, "IMG_5532-scaled", 
				"Très proche du type sauvage, cette espèce de mi-saison proche de la tomate cultivée, "
				+ "produit de très nombreux petits fruits oranges ronds en grappes portant de nombreux fruits de 1,5 à 2 grammes. "
				+ "Ces micro-tomates sont fermes à la saveur acidulée et parfumée.\r\n"
				+ "Tomates à manger à la croque-au-sel, en garniture ou à mettre en bocaux.\r\n"
				+ "\r\n"
				+ "Tomate très résistante au mildiou et à l'oédium.", 
				50, 3.95F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.ROUGE, "Tomate Cerise de Touraine", null, "Cerise-de-Touraine-scaled", 
				"Tomate cerise rouge, aux fruits pesant de 20 à 45g.\r\n"
				+ "\r\n"
				+ "Variété locale de mi-saison.\r\n"
				+ "\r\n"
				+ "Nous participons à sa sauvegarde et à sa reproduction en unissant nos efforts à ceux de l'URGC "
				+ "(Union des Ressources Génétiques de la Région Centre), dont l'objet est le sauvetage des variétés potagères "
				+ "et des races animales anciennes en voie de disparition.", 
				50, 3.85F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.VERT, "Tomate Claro Verde", null, "Claro-Verde-scaled", 
				"Variété connue depuis 2011, améliorée par Tom Wagner à partir de la Green Grappe. Excellent goût, subtile.\r\n"
				+ "\r\n"
				+ "Fruit ovale et vert à la peau translucide qui fait penser à un grain de raisin. A Récolter bien mûre. "
				+ "Plante très vigoureuse, à tuteurer absolument !", 
				50, 3.85F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.JAUNE, "Tomate Poire Jaune", null, "Tomate-poire-jaune.TEMP_", 
				"Grappes de mini-tomates en forme de poire William, légèrement acidulées, productive, ne se taille pas.\r\n"
				+ "\r\n"
				+ "En garniture, brochettes, cocktail. à croquer nature !", 
				50, 3.85F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.NOIR, "Tomate Negro Azteca", null, "Negro-Azteca-1-scaled", 
				"Variété ancestrale pourpre foncé, provenant des Aztèques, selon Eduardo Valenzuela, de mi-saison, fruits de 15-20g.\r\n"
				+ "\r\n"
				+ "Chair dense, douce et sucrée, avec peu de graines. Résistante à la sécheresse.", 
				50, 3.85F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.ROUGE, "Tomate Brown Berry", null, "Tomate-Black-Berry-1-TEMP", 
				"Tomate cerise rouge foncé tirant vers le brun, croquante, à déguster nature.", 
				50, 3.95F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.ROUGE, "Tomate Black Zebra", null, "IMG_0130-scaled", 
				"C'est une petite tomate cocktail ronde, pourpre et rayée de vert. Les fruits sont très nombreux et regroué�es en grappes, de 6 à 8 fruits.\r\n"
				+ "\r\n"
				+ "Variété précoce avec une saveur très douce.", 
				50, 3.95F));
		tomatesCerises.add(new Tomate(TypeTomate.TOMATES_CERISES, Couleur.ORANGE, "Tomate Mirabelle Blanche", null, "Tomate-Mirabelle-Blanche-scaled", 
				"Cette variété précoce produit en masse des grappes de fruit de 5 g, juteux, au goût acidulé.\r\n"
				+ "\r\n"
				+ "à cuire par exemple avec des tomatillos, aubergines, poivrons, piments, oignons et coriandre.", 
				50, 3.95F));
		return tomatesCerises;
	}

}
