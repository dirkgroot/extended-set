package nl.dirkgroot.xset

data class XSetElement<S, E>(val element: E, val scope: S)

infix fun <S, E> E.at(scope: S): XSetElement<S, E> = XSetElement(this, scope)

fun <S, E> extendedSetOf(vararg elements: XSetElement<S, E>): XSet<S, E> =
    elements.fold(InMemoryXSet()) { acc, (e, s) ->
        acc.add(s, e)
        acc
    }
