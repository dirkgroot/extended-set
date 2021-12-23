package nl.dirkgroot.xset

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import assertk.assertions.isZero
import org.junit.jupiter.api.Test

class ExtendedSetTest {
    @Test
    fun `empty xset`() {
        val set = extendedSetOf<String, String>()

        assertThat(set.isEmpty()).isTrue()
        assertThat(set.size).isZero()
    }

    @Test
    fun `xset with some elements`() {
        val set = extendedSetOf<Any, String>(
            "Dirk" at "name", "Arnhem" at "city", 44 at "age"
        )

        assertThat(set.isEmpty()).isFalse()
        assertThat(set.size).isEqualTo(3)

        assertThat(set.contains("Dirk", "name")).isTrue()
        assertThat(set.contains("Arnhem", "city")).isTrue()
        assertThat(set.contains(44, "age")).isTrue()
        assertThat(set.contains("Groot", "surname")).isFalse()
        assertThat(set.contains("John", "name")).isFalse()
        assertThat(set.contains("Dirk", "city")).isFalse()
    }

    @Test
    fun `element projection`() {
        val set = extendedSetOf<Any, String>("Dirk" at "name", "Arnhem" at "city", 44 at "age")
        val element = set.at("name")

        assertThat(element).isEqualTo("Dirk")
    }
}
