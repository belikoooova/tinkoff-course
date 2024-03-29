package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.ContactUtilities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task5Test {

    @Test
    @DisplayName("ASC test")
    void ascendingTest() {
        // given
        String[] names = new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};

        // when
        var result = ContactUtilities.parseContacts(names, "ASC");

        // then
        assertThat(result[0].getLastName()).isEqualTo("Aquinas");
        assertThat(result[1].getLastName()).isEqualTo("Descartes");
        assertThat(result[2].getLastName()).isEqualTo("Hume");
        assertThat(result[3].getLastName()).isEqualTo("Locke");
    }

    @Test
    @DisplayName("DESC test")
    void descendingTest() {
        // given
        String[] names = new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};

        // when
        var result = ContactUtilities.parseContacts(names, "DESC");

        // then
        assertThat(result[0].getLastName()).isEqualTo("Gauss");
        assertThat(result[1].getLastName()).isEqualTo("Euler");
        assertThat(result[2].getLastName()).isEqualTo("Erdos");
    }

    @Test
    @DisplayName("Incorrect sorting parameter test")
    void incorrectSortingParameterTest() {
        // given
        String[] names = new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};

        // when and then
        assertThrows(IllegalArgumentException.class, () -> ContactUtilities.parseContacts(names, "HW"));
    }

    @Test
    @DisplayName("Empty array")
    void emptyArrayTest() {
        // given
        String[] names = new String[0];

        // when
        var result = ContactUtilities.parseContacts(names, "DESC");

        // then
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("NULL array")
    void nullArrayTest() {
        // given
        String[] names = null;

        // when
        var result = ContactUtilities.parseContacts(names, "DESC");

        // then
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Only name")
    void onlyNameTest() {
        // given
        String[] names = new String[] {"Carl Gauss", "Leonhard", "Paul"};

        // when
        var result = ContactUtilities.parseContacts(names, "DESC");

        // then
        assertThat(result[0].getFirstName()).isEqualTo("Paul");
        assertThat(result[1].getFirstName()).isEqualTo("Leonhard");
        assertThat(result[2].getFirstName()).isEqualTo("Carl");
    }
}
