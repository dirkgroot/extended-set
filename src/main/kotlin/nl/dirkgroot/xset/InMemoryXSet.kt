package nl.dirkgroot.xset

class InMemoryXSet<E, S> : XSet<E, S> {
    private val map: MutableMap<S, MutableSet<E>> = mutableMapOf()

    override val size: Int
        get() = map.map { (_, v) -> v.size }.sum()

    override fun add(element: E, atScope: S) {
        map.getOrPut(atScope, ::mutableSetOf).add(element)
    }

    override fun isEmpty() = map.isEmpty()

    override fun contains(element: E, atScope: S) = map[atScope]?.contains(element) ?: false

    override fun at(scope: S) = map[scope]?.singleOrNull()

    override fun iterator() =
        map.asSequence()
            .flatMap { (scope, elements) ->
                elements.asSequence().map { XSetElement(it, scope) }
            }.iterator()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InMemoryXSet<*, *>

        if (map != other.map) return false

        return true
    }

    override fun hashCode(): Int {
        return map.hashCode()
    }
}
