# Extended sets in Kotlin

## Goal

Practice, learning, having fun.

## Introduction

Since about 1-2 years ago, I'm a somewhat regular reader of Ron Jeffries' blog
(<https://ronjeffries.com/>). Recently he started a new series of blogs about extended set theory,
or XST for short. In this series Ron shares the adventures het has in implementing a set-theoretic
data structure, based on XST, in Codea Lua.

I didn't know about XST before Ron started writing about it, but now I know of it's existence, it
has me thoroughly intrigued. So much, that I felt the urge to see how extended sets (or XSets for
short) could be implemented in a somewhat useful way in Kotlin.

## What is XST?

Extended set theory is a replacement for set theory, invented by Dave Childs, which extends set
theory with the concept of scopes. Every element in a set is an element of that set under a certain
scope.

In "classical" set theory, we write **x ∈ S** to denote that **x** is an element of **S**. In
extended set theory, we write **x ∈<sub>s</sub> S** to denote that **x** is an element of **S**
under scope **s**. A "classical" set looks like this: **{ Mike, London, 42 }**. An extended version
of this set could look like this: **{ Mike<sup>name</sup>, London<sup>city</sup>, 42<sup>age</sup>
}**.

From this simple example, I think it's clear that thanks to the added scope, we could represent any
data structure as a set (of sets (of sets (of... well, you get it))).

## More information

Information about XST is not easy to find online (it doesn't even have it's own Wikipedia page).
However, <http://xegesis.org> contains a couple of articles and papers about XST. I found
[this paper](http://xsp.xegesis.org/Xsp-uxr.pdf) quite easy to read and informative.
