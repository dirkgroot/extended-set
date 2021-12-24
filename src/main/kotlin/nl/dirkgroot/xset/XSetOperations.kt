package nl.dirkgroot.xset

infix fun <E, S> XSet<E, S>.isSubsetOf(other: XSet<E, S>) =
    this.all { (e, s) -> other.contains(e, s) }
