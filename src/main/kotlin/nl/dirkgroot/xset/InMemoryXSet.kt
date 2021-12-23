package nl.dirkgroot.xset

class InMemoryXSet<S, E> : XSet<S, E> {
    private val map: MutableMap<S, MutableSet<E>> = mutableMapOf()

    override val size: Int
        get() = map.map { (_, v) -> v.size }.sum()

    override fun add(scope: S, element: E) {
        map.getOrPut(scope, ::mutableSetOf).add(element)
    }

    override fun isEmpty() = map.isEmpty()

    override fun contains(scope: S, element: E) = map[scope]?.any { it == element } ?: false

    override fun at(scope: S) = map[scope]?.singleOrNull()
}
