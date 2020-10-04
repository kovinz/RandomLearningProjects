@file:kotlinx.cinterop.InteropStubs
@file:Suppress("UNUSED_VARIABLE", "UNUSED_EXPRESSION")
package lib

import kotlin.native.SymbolName
import kotlinx.cinterop.internal.*
import kotlinx.cinterop.*

// NOTE THIS FILE IS AUTO-GENERATED

fun ints(c: Byte, d: Short, e: Int, f: Int): Unit {
    return kniBridge0(c, d, e, f)
}

fun uints(c: UByte, d: UShort, e: UInt, f: UInt): Unit {
    return kniBridge1(c, d, e, f)
}

fun doubles(a: Float, b: Double): Unit {
    return kniBridge2(a, b)
}

@SymbolName("lib_kniBridge0")
private external fun kniBridge0(p0: Byte, p1: Short, p2: Int, p3: Int): Unit
@SymbolName("lib_kniBridge1")
private external fun kniBridge1(p0: UByte, p1: UShort, p2: UInt, p3: UInt): Unit
@SymbolName("lib_kniBridge2")
private external fun kniBridge2(p0: Float, p1: Double): Unit
