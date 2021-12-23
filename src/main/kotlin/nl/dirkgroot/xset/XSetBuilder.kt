package nl.dirkgroot.xset

data class XSetElement<E, S>(val element: E, val atScope: S)

infix fun <E, S> E.at(scope: S): XSetElement<E, S> = XSetElement(this, scope)

fun <E, S> extendedSetOf(vararg elements: XSetElement<E, S>): XSet<E, S> =
    elements.fold(InMemoryXSet()) { acc, (e, s) ->
        acc.add(e, s)
        acc
    }
