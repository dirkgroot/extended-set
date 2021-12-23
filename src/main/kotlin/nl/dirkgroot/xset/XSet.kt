package nl.dirkgroot.xset

interface XSet<S, E> {
    val size: Int

    fun add(scope: S, element: E)
    fun isEmpty(): Boolean
    fun contains(scope: S, element: E): Boolean
    fun at(scope: S): E?
}
