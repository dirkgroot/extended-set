package nl.dirkgroot.xset

infix fun <E, S> XSet<E, S>.isSubsetOf(other: XSet<E, S>) =
    this.all { (e, s) -> other.contains(e, s) }

infix fun <NE, NS, S> XSet<XSet<NE, NS>, S>.restrictTo(to: XSet<XSet<NE, NS>, S>): XSet<XSet<NE, NS>, S> =
    fold(extendedSetOf()) { acc, (thisElement, thisScope) ->
        if (to.any { (toElement, toScope) -> toScope == thisScope && toElement isSubsetOf thisElement })
            acc.add(thisElement, thisScope)
        acc
    }
