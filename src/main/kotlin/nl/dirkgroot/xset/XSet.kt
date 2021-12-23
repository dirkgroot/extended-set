package nl.dirkgroot.xset

interface XSet<S> {
    val size: Int

    fun add(scope: S, element: Any?)
    fun isEmpty(): Boolean
    fun contains(scope: S, element: Any?): Boolean
    fun at(scope: S): Any?
}
