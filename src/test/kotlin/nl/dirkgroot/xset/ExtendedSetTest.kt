package nl.dirkgroot.xset

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isNotEqualTo
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
        val set = extendedSetOf<Any, String>("Dirk" at "name", "Arnhem" at "city", 44 at "age")

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
        val set = extendedSetOf("Dirk" at "name", "Arnhem" at "city", 44 at "age", "foo" at "bar", "baz" at "bar")

        assertThat(set.at("name")).isEqualTo("Dirk")
        assertThat(set.at("bar")).isEqualTo(null)
    }

    @Test
    fun `type safe nested extended sets`() {
        val p1 = extendedSetOf<Any, String>("Dirk" at "name", "Arnhem" at "city", 44 at "age")
        val p2 = extendedSetOf<Any, String>("Julia" at "name", "Arnhem" at "city", 19 at "age")
        val set = extendedSetOf(p1 at "p1", p2 at "p2")
        val parent1 = extendedSetOf(set at "double nested")
        val parent2 = extendedSetOf(parent1 at "triple nested")

        assertThat(parent2.size).isEqualTo(1)
        assertThat(parent2.at("triple nested")?.size).isEqualTo(1)
        assertThat(parent2.at("triple nested")?.at("double nested")?.size).isEqualTo(2)
        assertThat(parent2.at("triple nested")?.at("double nested")?.at("p1")?.size).isEqualTo(3)
    }

    @Test
    fun equality() {
        val p1 = extendedSetOf<Any, String>("Dirk" at "name", "Arnhem" at "city", 44 at "age")
        val p2 = extendedSetOf<Any, String>("Dirk" at "name", "Arnhem" at "city", 44 at "age")
        val p3 = extendedSetOf<Any, String>("Dirk" at "name")

        assertThat(p1).isEqualTo(p2)
        assertThat(p1).isNotEqualTo(p3)
    }

    @Test
    fun `subset of`() {
        val p1 = extendedSetOf<Any, String>("Dirk" at "name", "Arnhem" at "city", 44 at "age")
        val p2 = extendedSetOf<Any, String>("Dirk" at "name")
        val p3 = extendedSetOf<Any, String>("Dirk" at "name", "Groot" at "surname")

        assertThat(p2 isSubsetOf p1).isTrue()
        assertThat(p3 isSubsetOf p1).isFalse()
    }
}
