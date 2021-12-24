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
}
