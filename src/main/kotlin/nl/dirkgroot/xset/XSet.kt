package nl.dirkgroot.xset

interface XSet<S, E> {
    val size: Int

    fun add(scope: S, element: E)
    fun isEmpty(): Boolean
    fun contains(scope: S, element: E): Boolean

    /**
     * Element projection. Returns the value at the given scope if, and only if,
     * the set contains exactly 1 element at the given scope. Returns `null` otherwise.
     *
     * @param scope the scope to project.
     */
    fun at(scope: S): E?
}
