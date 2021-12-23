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
        val set = extendedSetOf<String, Any>(
            "Dirk" at "name", "Arnhem" at "city", 44 at "age"
        )

        assertThat(set.isEmpty()).isFalse()
        assertThat(set.size).isEqualTo(3)

        assertThat(set.contains("name", "Dirk")).isTrue()
        assertThat(set.contains("city", "Arnhem")).isTrue()
        assertThat(set.contains("age", 44)).isTrue()
        assertThat(set.contains("surname", "Groot")).isFalse()
        assertThat(set.contains("name", "John")).isFalse()
        assertThat(set.contains("city", "Dirk")).isFalse()
    }

    @Test
    fun `element projection`() {
        val set = extendedSetOf("Dirk" at "name", "Arnhem" at "city", 44 at "age")
        val element = set.at("name")

        assertThat(element).isEqualTo("Dirk")
    }
}
