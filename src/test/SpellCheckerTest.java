
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import SpellChecker;

class SpellCheckerTest {
    //1
	@Test
	void howManyWords() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("first");
		checker.addWord("second");

		assertEquals(2, checker.howManyWords());
	}
    //2
	@Test
	void newWordAdded() {
		SpellChecker checker = new SpellChecker();
		int before = checker.howManyWords();

		checker.addWord("new");

		assertEquals(before + 1, checker.howManyWords());
	}
    //3
	@Test
	void wordAlreadyExists() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("same");
		int before = checker.howManyWords();
		checker.addWord("same");

		assertEquals(before, checker.howManyWords());
	}
    //4
	@Test
	void properlySpelledWord() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("worcestershire");

		assertTrue(checker.isSpelledCorrectly("worcestershire"));
	}
    //5
	@Test
	void improperlySpelledWord() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("worcestershire");

		assertFalse(checker.isSpelledCorrectly("worshersershire"));
	}
    //6
	@Test
	void ignoreCase() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("worcestershire");

		assertTrue(checker.isSpelledCorrectly("woRcestersHire"));
	}
    //7
	@Test
	void suggestWord() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("banana");
		checker.addWord("bank");
		checker.addWord("banner");

		assertEquals("bank", checker.suggestNextAlphabeticallyClosestWord("bamk")); 
	}

    //8
	@Test
	void suggestSameWordWhenCorrect() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("bank");

		assertEquals("bank", checker.suggestNextAlphabeticallyClosestWord("bank"));
	}
    //1st additional. Maybe user accidentally added a word that is not correct, 
    // so they want to remove it.
	@Test
	void removeoneWord() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("bamk");
        checker.addWord("bank");

		checker.removeWord("bamk");

		assertEquals(1, checker.howManyWords());
		assertFalse(checker.isSpelledCorrectly("bamk"));

	}

    //2nd additional. 
	@Test
	void countCharacters() {
		SpellChecker checker = new SpellChecker();
		checker.addWord("one");
		assertEquals(3, checker.countCharactersInWord());
	}

}
