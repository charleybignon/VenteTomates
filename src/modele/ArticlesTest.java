package modele;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ArticlesTest {

	@Test
	public void testTomates() {
		assertEquals(47, GenerationArticles.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES).size());
		assertEquals(GenerationArticles.GenerationTomates(), GenerationArticles.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES));
	}
	
	@Test
	public void testTomatesAppariement() {
		List<Tomate> tomates = GenerationArticles.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES);
		for (Tomate tomate : tomates) {
			assertEquals(4, tomate.getTomatesApparentées().size());
		}
	}
	
	@Test
	public void testTomatesCerises() {
		assertEquals(16, GenerationArticles.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES_CERISES).size());
		assertEquals(GenerationArticles.GenerationTomatesCerises(), GenerationArticles.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES_CERISES));
	}
	
	@Test
	public void testTomatesCerisesAppariement() {
		List<Tomate> tomates = GenerationArticles.générationDeBaseDesTomates().tomatesDeType(TypeTomate.TOMATES_CERISES);
		for (Tomate tomate : tomates) {
			assertEquals(4, tomate.getTomatesApparentées().size());
		}
	}
	
	@Test 
	public void testTomatesEtTomatesCerisesParCouleur() {
		for (int i = 0; i < Couleur.values().length; i++) {
			List<Tomate> tomates = GenerationArticles.générationDeBaseDesTomates().tomatesDeCouleur(Couleur.values()[i]);
			assertTrue(tomates.size() > 0);
			for (Tomate tomate : tomates) {
				assertEquals(Couleur.values()[i], tomate.getCouleur());
			}
		}
	}
	
	@Test 
	public void testTomatesParCouleur() {
		for (int i = 0; i < Couleur.values().length; i++) {
			List<Tomate> tomates = GenerationArticles.générationDeBaseDesTomates().tomatesDetypeDeCouleur(TypeTomate.TOMATES, Couleur.values()[i]);
			assertTrue(tomates.size() > 0);
			for (Tomate tomate : tomates) {
				assertEquals(TypeTomate.TOMATES, tomate.getTypeGraine());
				assertEquals(Couleur.values()[i], tomate.getCouleur());
			}
		}
	}
	
	@Test 
	public void testTomatesCerisesParCouleur() {
		for (int i = 0; i < Couleur.values().length; i++) {
			List<Tomate> tomates = GenerationArticles.générationDeBaseDesTomates().tomatesDetypeDeCouleur(TypeTomate.TOMATES_CERISES, Couleur.values()[i]);
			if (!(Couleur.values()[i] == Couleur.MULTICOLORE)  && !(Couleur.values()[i] == Couleur.BLEU)) {
				assertTrue(tomates.size() > 0);
				for (Tomate tomate : tomates) {
					assertEquals(TypeTomate.TOMATES_CERISES, tomate.getTypeGraine());
					assertEquals(Couleur.values()[i], tomate.getCouleur());
				}
			}
		}
	}
	
	@Test 
	public void testGetterTomateParDésignation() {
		Tomates articles = GenerationArticles.générationDeBaseDesTomates();
		assertNotNull(articles.getTomate("Tomate Brandywine"));
		assertNull(articles.getTomate("Tomate Brandywine goes to Hollywood"));
		assertEquals("Tomate Brandywine", articles.getTomate("Tomate Brandywine").getDésignation());
	}

}
