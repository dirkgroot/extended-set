package nl.dirkgroot.xset

interface XSet<E, S> {
    val size: Int

    fun add(element: E, atScope: S)
    fun isEmpty(): Boolean
    fun contains(element: E, atScope: S): Boolean

    /**
     * Element projection. Returns the value at the given scope if, and only if,
     * the set contains exactly 1 element at the given scope. Returns `null` otherwise.
     *
     * @param scope the scope to project.
     */
    fun at(scope: S): E?
}
