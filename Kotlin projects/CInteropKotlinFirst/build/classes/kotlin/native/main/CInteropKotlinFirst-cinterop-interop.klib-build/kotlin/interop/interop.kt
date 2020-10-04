@file:kotlinx.cinterop.InteropStubs
@file:Suppress("UNUSED_VARIABLE", "UNUSED_EXPRESSION")
package interop

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

fun struct_by_value(s: CValue<MyStruct>): Unit {
    memScoped {
        return kniBridge3(s.getPointer(memScope).rawValue)
    }
}

fun struct_by_pointer(s: CValuesRef<MyStruct>?): Unit {
    memScoped {
        return kniBridge4(s?.getPointer(memScope).rawValue)
    }
}

fun union_by_value(u: CValue<MyUnion>): Unit {
    memScoped {
        return kniBridge5(u.getPointer(memScope).rawValue)
    }
}

fun union_by_pointer(u: CValuesRef<MyUnion>?): Unit {
    memScoped {
        return kniBridge6(u?.getPointer(memScope).rawValue)
    }
}

fun myFun(i: Int): Int {
    return kniBridge7(i)
}

fun accept_fun(f: MyFun?): Unit {
    return kniBridge8(f.rawValue)
}

fun supply_fun(): MyFun? {
    return interpretCPointer<CFunction<(Int) -> Int>>(kniBridge9())
}

@CStruct("struct { int p0; double p1; }")
class MyStruct(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(16, 8)
    
    var a: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var b: Double
        get() = memberAt<DoubleVar>(8).value
        set(value) { memberAt<DoubleVar>(8).value = value }
    
}

@CStruct("union { int p0; struct { int p0; double p1; } p1; float p2; }")
class MyUnion(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(16, 8)
    
    var a: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    val b: MyStruct
        get() = memberAt(0)
    
    var c: Float
        get() = memberAt<FloatVar>(0).value
        set(value) { memberAt<FloatVar>(0).value = value }
    
}

typealias MyFunVar = CPointerVarOf<MyFun>
typealias MyFun = CPointer<CFunction<(Int) -> Int>>

@SymbolName("interop_kniBridge0")
private external fun kniBridge0(p0: Byte, p1: Short, p2: Int, p3: Int): Unit
@SymbolName("interop_kniBridge1")
private external fun kniBridge1(p0: UByte, p1: UShort, p2: UInt, p3: UInt): Unit
@SymbolName("interop_kniBridge2")
private external fun kniBridge2(p0: Float, p1: Double): Unit
@SymbolName("interop_kniBridge3")
private external fun kniBridge3(p0: NativePtr): Unit
@SymbolName("interop_kniBridge4")
private external fun kniBridge4(p0: NativePtr): Unit
@SymbolName("interop_kniBridge5")
private external fun kniBridge5(p0: NativePtr): Unit
@SymbolName("interop_kniBridge6")
private external fun kniBridge6(p0: NativePtr): Unit
@SymbolName("interop_kniBridge7")
private external fun kniBridge7(p0: Int): Int
@SymbolName("interop_kniBridge8")
private external fun kniBridge8(p0: NativePtr): Unit
@SymbolName("interop_kniBridge9")
private external fun kniBridge9(): NativePtr
