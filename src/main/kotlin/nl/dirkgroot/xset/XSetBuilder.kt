package nl.dirkgroot.xset

data class XSetElement<S>(val element: Any?, val scope: S)

infix fun <S> Any?.at(scope: S): XSetElement<S> = XSetElement(this, scope)

fun <S> extendedSetOf(vararg elements: XSetElement<S>): XSet<S> =
    elements.fold(InMemoryXSet()) { acc, (e, s) ->
        acc.add(s, e)
        acc
    }
